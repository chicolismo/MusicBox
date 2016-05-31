package tcp.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import tcp.StringParser;

/**
 * Created by chico on 29/05/16.
 */
public class StringParserTest {
    StringParser parser;
    private static final int maxOctave = 8;
    private static final int minOctave = 0;

    @Before
    public void setUp() throws Exception {
        parser = new StringParser();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void makeNote() throws Exception {
        parser.changeSharp(false);
        parser.changeOctave(7);
        assertEquals("C7", parser.makeNote("C"));

        parser.changeSharp(true);
        parser.changeOctave(6);
        assertEquals("A#6", parser.makeNote("A"));
    }

    @Test
    public void parse() {
        String note = parser.parse("#aboóc<if2g");
        assertEquals("T120 A#5 B5 C7 T110 F6 G2", note);
    }
}
