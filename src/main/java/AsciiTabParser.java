import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsciiTabParser {
    TabsBuffer buffer;

    public void load(InputStream in) throws IOException {
//      new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
//              .lines()
//      rea
        String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        // todo shit
        var lines = text.split("\n");

        // basic algo:
        // buffer lines with match to [a-zA-Z]?\|-

        buffer = new TabsBuffer();
        for (var line : lines) {

            if (line.matches("[A-Za-z]\\|-.*")) {
                buffer.add(line);
            } else {
                // throw away buffer after
                // if was usable add to
                buffer.end();

            }

        }

    }

    public MutableTabs parseTabs() {
        return buffer.parseTabs();
    }

    class TabsBuffer {

        List<List<String>> all = new ArrayList<>();
        List<String> linesBuffer = new ArrayList<>();

        public void add(String line) {
            linesBuffer.add(line);
        }

        public void end() {
            if (linesBuffer.size() >= 4) {
                all.add(new ArrayList<>(linesBuffer));
            }
            linesBuffer.clear();
        }

        public int size() {
            return all.size();
        }

        public MutableTabs parseTabs() {

//            List<Picks> picks = new ArrayList<>();

            var mTabs = new MutableTabs();

            var pattern = Pattern.compile("\\d+|x");
            ArrayList<Map<Integer, List<String>>> lines = new ArrayList<>();
            var timeOffset = 0;
            for (var tabLine : all) {
                for (int stringIdx = 0; stringIdx < tabLine.size(); stringIdx++) {
                    var line = tabLine.get(stringIdx);
                    Matcher m = pattern.matcher(line);
                    while (m.find()) {
                        pattern.matcher(line).results();
                        mTabs.setNote(timeOffset + m.start(), stringIdx, m.group());
                    }
                }
                var maxLength = tabLine.stream()
                        .mapToInt(String::length)
                        .max()
                        .getAsInt();

                timeOffset += maxLength;
            }
            System.out.println(lines);
            return mTabs;
        }
    }
}
