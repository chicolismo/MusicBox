package tcp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Objeto que controla a duração das notas da música.
 */
public class Duration {
    public static final List<String> OPTIONS;
    public static final HashSet<String> VALID_OPTIONS;
    public static final int DEFAULT_DURATION;
    public static final int MIN_DURATION;
    public static final int MAX_DURATION;

    static {
        OPTIONS = Arrays.asList("o", "x", "t", "s", "i", "q", "h", "w");
        VALID_OPTIONS = new HashSet<String>(OPTIONS);
        DEFAULT_DURATION = OPTIONS.indexOf("q");
        MIN_DURATION = 0;
        MAX_DURATION = OPTIONS.size() - 1;
    }

    private int index;

    public Duration() {
        index = DEFAULT_DURATION;
    }

    public void set(int value) {
        if (value >= MIN_DURATION && value <= MAX_DURATION) {
            this.index = value;
        }
    }

    public void set(String value) {
        value = value.toLowerCase();
        if (VALID_OPTIONS.contains(value)) {
            this.index = OPTIONS.indexOf(value);
        }
    }

    public int get() {
        return index;
    }

    public void increment() {
        if (index < MAX_DURATION) {
            ++index;
        }
    }

    public void decrement() {
        if (index > MIN_DURATION) {
            --index;
        }
    }

    public String getString() {
        return OPTIONS.get(index);
    }

    /*
    Se a duração for a padrão, não é necessário modificar a string da música.
     */
    public String toString() {
        if (index == DEFAULT_DURATION) {
            return "";
        } else {
            return getString();
        }
    }
}
