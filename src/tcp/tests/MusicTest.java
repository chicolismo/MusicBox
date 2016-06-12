package tcp.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tcp.Attack;
import tcp.Music;
import tcp.Octave;
import tcp.Tempo;

import static org.junit.Assert.assertEquals;

public class MusicTest {
    private Music music;

    @Before
    public void setUp() throws Exception {
        this.music = new Music();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void constructor() throws Exception {
        Music m = new Music(200, 6, true);
        Tempo t = new Tempo();
        Octave o = new Octave();
        o.set(6);
        t.set(200);
        assertEquals(t.toString(), m.getTempo().toString());
        assertEquals(o.get(), m.getOctave().get());
        assertEquals("T200 C#6", m.makeNote("C"));
    }

    @Test
    public void getTempo() throws Exception {
        Music m = new Music();
        Tempo t = m.getTempo();
        String result = t.toString();
        String defaultTempo = "T" + String.valueOf(Tempo.DEFAULT_TEMPO);
        assertEquals(defaultTempo, result);
    }

    @Test
    public void makeNote() throws Exception {
        Octave o = music.getOctave();
        Tempo t = music.getTempo();
        Attack a = music.getAttack();

        // Nota não presente nas notas válidas
        o.set(0);
        assertEquals("", music.makeNote("C"));

        assertEquals("A0", music.makeNote("A"));

        t.set(100);
        t.increment(100);
        o.set(0);
        assertEquals("T200 A0", music.makeNote("A"));

        t.set(300);
        o.set(5);
        a.set(50);
        assertEquals("T300 A5a50", music.makeNote("A"));
        a.set(Attack.DEFAULT_ATTACK);
        o.set(0);
        t.set(200);
        assertEquals("T200 A0", music.makeNote("A"));

        a.set(10);
        music.decrementAttack(5);
        o.set(4);
        t.set(120);
        assertEquals("T120 F4a5", music.makeNote("F"));
    }


    @Test
    public void setSharp() throws Exception {

    }
}