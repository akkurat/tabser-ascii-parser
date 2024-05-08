import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class AsciiTabParserTest {
    final String test1 = "-------------------------------------------------------------------------------\n" +
            "                           THE GUNS OF BRIXTON - The Clash\n" +
            "-------------------------------------------------------------------------------\n" +
            "Tabbed by: dead_kennedy77\n" +
            "Email: dima_zador@yahoo.com\n" +
            "\n" +
            "Tuning: Standard\n" +
            "\n" +
            "This is the bulk of a song and it should be right. I don't know what the order is,\n" +
            "though. Mute strumming down, and then strum the chord going up (like reggae or whatever).\n" +
            "\n" +
            "Part A\n" +
            "\n" +
            "      F#m           Am          F#m           Am\n" +
            "e|----x-9----x-9----x-7---x-7---x-9----x-9----x-7---x-7---------------------|\n" +
            "B|----x-10---x-10---x-7---x-7---x-10---x-10---x-7---x-7---------------------|\n" +
            "G|----x-11---x-11---x-7---x-7---x-11---x-11---x-7---x-7---------------------|\n" +
            "D|----x-11---x-11---x-9---x-9---x-11---x-11---x-9---x-9---------------------|\n" +
            "A|----x-9----x-9----x-9---x-9---x-9----x-9----x-9---x-9---------------------|\n" +
            "E|------------------x-7---x-7-----------------x-7---x-7---------------------|\n" +
            "\n" +
            "\n" +
            "\n" +
            "      G           Am          F#m           Am\n" +
            "e|----x-3---x-3---x-7---x-7---x-9----x-9----x-7---x-7-----------------------|\n" +
            "B|----x-3---x-3---x-7---x-7---x-10---x-10---x-7---x-7-----------------------|\n" +
            "G|----x-4---x-4---x-7---x-7---x-11---x-11---x-7---x-7-----------------------|\n" +
            "D|----x-5---x-5---x-9---x-9---x-11---x-11---x-9---x-9-----------------------|\n" +
            "A|----x-5---x-5---x-9---x-9---x-9----x-9----x-9---x-9-----------------------|\n" +
            "E|----x-3---x-3---x-7---x-7-----------------x-7---x-7-----------------------|\n" +
            "\n" +
            "Part B\n" +
            "\n" +
            "      F#m   Am    F#m   Am    G     Am    F#m   Am\n" +
            "e|----9~~---7~~---9~~---7~~---3~~---7~~---9~~---7~~-------------------------|\n" +
            "B|----10~~--7~~---10~~--7~~---3~~---7~~---10~~--7~~-------------------------|\n" +
            "G|----11~~--7~~---11~~--7~~---4~~---7~~---11~~--7~~-------------------------|\n" +
            "D|----11~~--9~~---11~~--9~~---5~~---9~~---11~~--9~~-------------------------|\n" +
            "A|----9~~---9~~---9~~---9~~---5~~---9~~---9~~---9~~-------------------------|\n" +
            "E|----------7~~---------7~~---3~~---7~~---------7~~-------------------------|\n" +
            "\n" +
            "For Part B you'll need a tremolo bar to play it right, but you can just shake your guitar\n" +
            "if you don't have one.\n" +
            "\n" +
            "Listen to the song to figure out how many times each part repeats and were it goes and\n" +
            "stuff. Email me for whatever.\n" +
            "\n" +
            "=============================================================================";

    @Test
    public void checkTabsAq() throws IOException {
        var parser = new AsciiTabParser();
        parser.load(new ByteArrayInputStream(test1.getBytes(StandardCharsets.UTF_8)));

        assertEquals(3, parser.buffer.size());

    }
}