package tcp;

/**
 * Created by chico on 30/05/16.
 */
public class Octave {
    private static final int defaultOctave = 5;
    private static final int maxOctave = 8;
    private static final int minOctave = 0;
    private int value;

    public Octave() {
        value = defaultOctave;
    }

    public void increase() {
        if (value < maxOctave) {
            ++value;
        }
    }

    public void decrease() {
        if (value > minOctave) {
            --value;
        }
    }

    public void set(int newOctave) {
        if (newOctave <= maxOctave && newOctave >= minOctave) {
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
