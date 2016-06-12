package tcp;

/**
 * Retorna um objeto Attack, que se encarrega de controlar o volume atual da música.
 */
public class Attack {
    public static final int SMALL_INCREMENT = 10;
    public static final int BIG_INCREMENT = 50;
    public static final int MIN_ATTACK = 0;
    public static final int MAX_ATTACK = 127;
    public static int DEFAULT_ATTACK = 64;
    private int value;

    public Attack() {
        this(DEFAULT_ATTACK);
    }

    public Attack(int attack) {
        set(attack);
    }

    /**
     * Atribui um valor ao ataque.
     * <p>
     * O valor do ataque deve ficar no intervalo [0..127], caso o valor fornecido esteja fora do intervalo,
     * ele será ignorado.
     *
     * @param value O novo valor do ataque
     */
    public void set(int value) {
        if (value >= MIN_ATTACK && value <= MAX_ATTACK) {
            this.value = value;
        }
    }

    /**
     * @return O valor atual do ataque.
     */
    public int get() {
        return value;
    }

    /**
     * Incrementa o valor do ataque da música pela quantidade especificada pelo argumento.
     * <p>
     * O valor máximo satura em MAX_ATTACK.
     * </p>
     *
     * @param amount A quantidade a ser aumentada.
     */
    public void increment(int amount) {
        value += amount;
        if (value > MAX_ATTACK) {
            value = MAX_ATTACK;
        }
    }

    public void decrement(int amount) {
        value -= amount;
        if (value < MIN_ATTACK) {
            value = MIN_ATTACK;
        }
    }

    @Override
    public String toString() {
        if (value != DEFAULT_ATTACK) {
            return String.format("a%d", get());
        } else {
            return "";
        }
    }
}
