import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
        for(var line: lines ) {

            if(line.matches("[A-Za-bz]]\\|-")) {
               buffer.add(line);
            } else  {
                // throw away buffer after
                // if was usable add to
                buffer.end();

            }

        }

    }


    class TabsBuffer {

        List<List<String>> all = new ArrayList<>();
        List<String> linesBuffer = new ArrayList<>();

        public void add(String line) {
            linesBuffer.add(line);

        }

        public void end() {
            if(linesBuffer.size()>=4) {
                all.add(linesBuffer);
            }
            linesBuffer.clear();
        }

        public int size() {
            return linesBuffer.size();
        }
    }
}
