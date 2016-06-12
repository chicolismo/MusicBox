package tcp;

/**
 * Objecto que controla a oitava atual da música
 */
public class Octave {
    public static final int DEFAULT_OCTAVE = 5;
    public static final int MAX_OCTAVE = 8;
    public static final int MIN_OCTAVE = 0;
    private int value;

    public Octave() {
        value = DEFAULT_OCTAVE;
    }

    public void increment() {
        if (value < MAX_OCTAVE) {
            ++value;
        }
    }

    public void decrement() {
        if (value > MIN_OCTAVE) {
            --value;
        }
    }

    public void set(int newOctave) {
        if (newOctave <= MAX_OCTAVE && newOctave >= MIN_OCTAVE) {
            value = newOctave;
        }
    }

    public int get() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
