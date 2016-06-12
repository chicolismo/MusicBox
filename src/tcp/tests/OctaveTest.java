package tcp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tcp.Octave;

import static org.junit.Assert.assertEquals;

public class OctaveTest {
    private Octave o;
    private int defaultValue = Octave.DEFAULT_OCTAVE;
    private int maxValue = Octave.MAX_OCTAVE;
    private int minValue = Octave.MIN_OCTAVE;

    @Before
    public void setUp() throws Exception {
        this.o = new Octave();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Testa se o valor da oitava é reduzido em 1.
     *
     * @throws Exception
     */
    @Test
    public void increase() throws Exception {
        o.set(defaultValue);
        o.increment();
        assertEquals(defaultValue + 1, o.get());
    }

    /**
     * Ao incrementar a oitava, valor da deve saturar em Octave.MAX_OCTAVE
     *
     * @throws Exception
     */
    @Test
    public void increaseMustSaturateInMaxOctave() throws Exception {
        o.set(maxValue);
        o.increment();
        assertEquals(maxValue, o.get());
    }

    /**
     * Testa se o valor da oitava é reduzido em 1.
     *
     * @throws Exception
     */
    @Test
    public void decrease() throws Exception {
        o.set(defaultValue);
        o.decrement();
        assertEquals(defaultValue - 1, o.get());
    }

    /**
     * Ao decrementar a oitava, o valor mínimo deve saturar em zero.
     *
     * @throws Exception
     */
    @Test
    public void decreaseMustSaturateInZero() throws Exception {
        o.set(minValue);
        o.decrement();
        assertEquals(minValue, o.get());
    }

    @Test
    public void set() throws Exception {
        o.set(4);
        assertEquals(4, o.get());
    }

    /**
     * Testa se os valores inválidos atribuidos nãos serão considerados.
     *
     * @throws Exception
     */
    @Test
    public void setValueMustBeValid() throws Exception {
        o.set(maxValue);
        o.set(maxValue + 1);
        assertEquals(maxValue, o.get());
        o.set(minValue);
        o.set(minValue - 1);
        assertEquals(minValue, o.get());
    }

    @Test
    public void get() throws Exception {
        o.set(2);
        assertEquals(2, o.get());
    }
}