package tcp;

public class Tempo {
    public static final int DEFAULT_TEMPO = 120;
    public static final int SMALL_INCREMENT = 10;
    public static final int BIG_INCREMENT = 100;

    private int value;
    private boolean valueHasChanged;

    public Tempo() {
        value = DEFAULT_TEMPO;
        valueHasChanged = false;
    }

    public void increment(int amount) {
        set(value + amount);
    }

    public void decrement(int amount) {
        set(value - amount);
    }

    public void set(int newTempo) {
        if (newTempo > 0 && newTempo != value) {
            valueHasChanged = true;
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

    public boolean isChanged() {
        return valueHasChanged;
    }

    public void setChanged(boolean value) {
        valueHasChanged = value;
    }
}
