package tcp.tests;

import org.junit.Before;
import org.junit.Test;
import tcp.Duration;

import static org.junit.Assert.assertEquals;
import static tcp.Duration.*;

public class DurationTest {
    private Duration d;

    @Before
    public void setUp() throws Exception {
        d = new Duration();
    }

    @Test
    public void setMinDuration() throws Exception {
        d.set(DEFAULT_DURATION);
        d.set(-1);
        assertEquals(DEFAULT_DURATION, d.get());
    }

    @Test
    public void setMaxDuration() throws Exception {
        d.set(DEFAULT_DURATION);
        d.set(9);
        assertEquals(DEFAULT_DURATION, d.get());
    }

    @Test
    public void setValidDuration() throws Exception {
        d.set(3);
        assertEquals(3, d.get());
    }

    @Test
    public void setValidCharDuration() throws Exception {
        d.set("w");
        assertEquals("w", d.getString());
        d.set("H");
        assertEquals("h", d.getString());
    }

    @Test
    public void setInvalidCharDuration() throws Exception {
        d.set("w");
        d.set("a");
        assertEquals("w", d.getString());
    }

    @Test
    public void get() throws Exception {
    }

    /*
    A duração máxima não deve passar de MAX_DURATION.
     */
    @Test
    public void incrementMaxDuration() throws Exception {
        d.set(MAX_DURATION);
        d.increment();
        assertEquals(MAX_DURATION, d.get());
    }

    /*
    A duração mínima não deve ser menor que MIN_DURATION.
     */
    @Test
    public void incrementMinDuration() throws Exception {
        d.set(MIN_DURATION);
        d.decrement();
        assertEquals(MIN_DURATION, d.get());
    }

    @Test
    public void decrement() throws Exception {
        d.set(MAX_DURATION);
        d.decrement();
        assertEquals(MAX_DURATION - 1, d.get());
    }

    @Test
    public void increment() throws Exception {
        d.set(MIN_DURATION);
        d.increment();
        assertEquals(MIN_DURATION + 1, d.get());
    }

    /*
    A representação string da duração padrão deve ser vazia.
     */
    @Test
    public void defaultDurationToString() throws Exception {
        d.set(DEFAULT_DURATION);
        assertEquals("", d.toString());
    }

    /*
    Testa a representação em string das outras durações.
     */
    @Test
    public void notDefaultDurationToString() throws Exception {
        d.set(MAX_DURATION);
        assertEquals("w", d.toString());
        d.set("H");
        assertEquals("h", d.toString());
    }
}