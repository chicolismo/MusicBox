package tcp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tcp.Instrument;

import static org.junit.Assert.assertEquals;
import static tcp.Instrument.Id;
import static tcp.Instrument.NUMBER_OF_INSTRUMENTS;

public class InstrumentTest {
    private Instrument i;

    @Before
    public void setUp() throws Exception {
        this.i = new Instrument();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestToString() throws Exception {
        i.setInstrument(Id.PIANO);
        assertEquals("I[PIANO]", i.toString());
    }

    @Test
    public void nextInstrument() throws Exception {
        i.setInstrument(0);
        i.nextInstrument();
        assertEquals(1, i.getInstrument());

        i.setInstrument(Id.PIANO);
        i.nextInstrument();
        assertEquals("I[PICCOLO]", i.toString());
    }

    @Test
    public void prevInstrument() throws Exception {
        i.setInstrument(0);
        i.prevInstrument();
        assertEquals(NUMBER_OF_INSTRUMENTS - 1, i.getInstrument());
    }
}