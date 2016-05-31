package tcp;

/**
 * Created by chico on 30/05/16.
 */
public class Tempo {
    private static final int defaultTempo = 120;

    private int value;
    private boolean valueHasChanged;

    public Tempo() {
        value = defaultTempo;
        valueHasChanged = false;
    }

    public void increase(int amount) {
        if (amount != 0) {
            valueHasChanged = true;
        }
        value += amount;
    }

    public void decrease(int amount) {
        if (amount != 0 && value > 1) {
            valueHasChanged = true;
        }
        value -= amount;
        if (value < 1) {
            value = 1;
        }
    }

    public void set(int newTempo) {
        if (newTempo > 0) {
            value = newTempo;
        }
    }

    public int get() {
        return value;
    }

    @Override
    public String toString() {
        return "T" + String.valueOf(get());
    }

    public boolean hasChanged() {
        return valueHasChanged;
    }

    public void setUnchanged() {
        valueHasChanged = false;
    }
}
