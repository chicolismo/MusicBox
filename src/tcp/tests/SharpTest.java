package tcp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tcp.Sharp;

import static org.junit.Assert.*;

/**
 * Created by chico on 30/05/16.
 */
public class SharpTest {
    private Sharp s;

    @Before
    public void setUp() throws Exception {
        s = new Sharp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isActive() throws Exception {
        s.setInactive();
        assertFalse(s.isActive());

        s.setActive();
        assertTrue(s.isActive());
    }

    @Test
    public void setInactive() throws Exception {
        s.setInactive();
        assertFalse(s.isActive());
    }

    @Test
    public void setActive() throws Exception {
        s.setActive();
        assertTrue(s.isActive());
    }

}