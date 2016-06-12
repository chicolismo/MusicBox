package tcp.tests;

import org.junit.Test;
import tcp.Instrument;
import tcp.Music;
import tcp.StringParser;

import static org.junit.Assert.assertEquals;

public class StringParserTest {
    private static final int maxOctave = 8;
    private static final int minOctave = 0;

    /**
     * Este é o teste mais importante, porque basicamente testa a interface do programa com o usuário.
     */
    @Test
    public void parse() {
        String note;
        StringParser p;

        p = new StringParser();
        note = p.parse("#aboóc!<if2g");
        assertEquals("T120 A#5 B5 C7 T110 F6a74 G2a74", note);

        p = new StringParser();
        note = p.parse("#aboóc!!<if;2g");
        assertEquals("T120 A#5 B5 C7 T110 F6a84 G2a74", note);

        p = new StringParser();
        note = p.parse("#ab$oóc!!<if;2g");
        assertEquals("T120 A#5 B5 C7a114 T110 F6a127 G2a117", note);

        p = new StringParser();
        note = p.parse("#ab$oóc!!<if;2g$2g7%g");
        assertEquals("T120 A#5 B5 C7a114 T110 F6a127 G2a117 G2a127 G7a77", note);

        p = new StringParser();
        note = p.parse("#\"ab\'$oóc!!<if\"\";2g$\'2g7%\'g");
        assertEquals("T120 A#5h B5h C7a114 T110 F6a127 G2wa117 G2ha127 G7a77", note);

        p = new StringParser();
        note = p.parse("7a?a");
        assertEquals("T120 A7 A5", note);

        p = new StringParser();
        Music m = p.getMusic();
        Instrument i = m.getInstrument();
        i.setInstrument(Instrument.Id.PIANO);
        note = p.parse("7a?a\nC");
        assertEquals("T120 A7 A5 I[PICCOLO] C5", note);
    }
}
