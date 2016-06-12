package tcp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tcp.Attack;

import static org.junit.Assert.assertEquals;
import static tcp.Attack.BIG_INCREMENT;
import static tcp.Attack.SMALL_INCREMENT;

public class AttackTest {
    private Attack a;

    @Before
    public void setUp() throws Exception {
        this.a = new Attack();
    }

    @After
    public void tearDown() throws Exception {

    }

    /* Não pode ter um valor menor que zero ou maior que 127. */
    @Test
    public void set() throws Exception {
        a.set(8);

        a.set(-1);
        assertEquals(8, a.get());

        a.set(200);
        assertEquals(8, a.get());
    }

    /* Se o valor do ataque for 0, então deve retornar uma string vazia. */
    @Test
    public void testToString() throws Exception {
        a.set(8);
        assertEquals("a8", a.toString());
        a.set(0);
        assertEquals("", a.toString());
    }

    @Test
    public void increment() throws Exception {
        a.set(30);
        a.increment(SMALL_INCREMENT);
        assertEquals(30 + SMALL_INCREMENT, a.get());
        a.increment(BIG_INCREMENT);
        assertEquals(30 + SMALL_INCREMENT + BIG_INCREMENT, a.get());
    }

    /* Ataque deve saturar em 127 e não pode ser menor que 0 */
    @Test
    public void attackSaturation() throws Exception {
        a.set(0);
        a.decrement(1);
        assertEquals(0, a.get());

        a.set(127);
        a.increment(1);
        assertEquals(127, a.get());
    }

    @Test
    public void decrement() throws Exception {
        a.set(2 * BIG_INCREMENT);
        a.decrement(SMALL_INCREMENT);
        assertEquals(2 * BIG_INCREMENT - SMALL_INCREMENT, a.get());

        a.set(BIG_INCREMENT);
        a.decrement(3 * BIG_INCREMENT);
        assertEquals(0, a.get());
    }
}