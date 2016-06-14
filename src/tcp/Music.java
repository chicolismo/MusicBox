package tcp;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Retorna um objeto Music, responsável por controlar a formação das notas da música,
 * e que delega parte da funcionalidade para objetos de outras classe, que são seus campos.
 */
public class Music {
    private static final String[] VALID_NOTES_ARRAY = new String[] {
            "A0", "A#0", "B0", "C1", "C#1", "D1", "D#1", "E1", "F1", "F#1", "G1", "G#1",
            "A1", "A#1", "B1", "C2", "C#2", "D2", "D#2", "E2", "F2", "F#2", "G2", "G#2",
            "A2", "A#2", "B2", "C3", "C#3", "D3", "D#3", "E3", "F3", "F#3", "G3", "G#3",
            "A3", "A#3", "B3", "C4", "C#4", "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4",
            "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5",
            "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6", "G6", "G#6",
            "A6", "A#6", "B6", "C7", "C#7", "D7", "D#7", "E7", "F7", "F#7", "G7", "G#7",
            "A7", "A#7", "B7", "C8"
    };
    private static final HashSet<String> validNotes
            = new HashSet<String>(Arrays.asList(VALID_NOTES_ARRAY));
    private Tempo tempo;
    private Octave octave;
    private boolean sharp;
    private Instrument instrument;
    private Attack attack;
    private Duration duration;

    public Music() {
        tempo = new Tempo();
        octave = new Octave();
        sharp = false;
        instrument = new Instrument();
        attack = new Attack();
        duration = new Duration();
    }

    public Music(int tempo, int octave, boolean sharp) {
        this();
        this.tempo.set(tempo);
        this.octave.set(octave);
        this.sharp = sharp;
    }

    public Music(int tempo, int octave, boolean sharp, Instrument.Id id) {
        this(tempo, octave, sharp);
        this.instrument.setInstrument(id);
    }

    public Tempo getTempo() {
        return tempo;
    }

    public Octave getOctave() {
        return octave;
    }

    public Attack getAttack() {
        return attack;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Duration getDuration() {
        return duration;
    }

    /**
     * Dada uma string de nota A, B, C, D, E, F ou G, produz uma nota válida para o JFugue.
     *
     * <p>
     * Caso a combinação de nota com a oitava atual seja inválida, retorna uma string vazia.
     *
     * @param str A string representando a nota a ser criada.
     */
    public String makeNote(String str) {
        String result = null;

        if (sharp) {
            sharp = false;
            result = str + "#" + octave.toString();
        } else {
            result = str + octave.toString();
        }

        // Se não for uma nota válida, retornar string vazia.
        if (!isValidNote(result)) {
            result = "";
        }

        return addModifiers(result);
    }

    private boolean isValidNote(String note) {
        return validNotes.contains(note);
    }

    /**
     * Acrescenta modificadores extras além das notas musicais, como mudança do tempo, do instrumento,
     * ou a inclusão de um sustenido à nota atual.
     *
     * <p>
     * Também inclui a duração e o ataque atuais, caso haja alteração.
     *
     * @param str A string que representa a nota atual, para ser modificada se necessário
     * @return A nota acrescida de possíveis alterações, pronta para ser executada.
     */
    private String addModifiers(String str) {
        if (str != "") {
            str = String.format("%s%s%s", str, getDuration().toString(), getAttack().toString());
        }

        if (tempo.isChanged()) {
            tempo.setChanged(false);
            str = tempo.toString() + " " + str;
        }

        if (instrument.isChanged()) {
            str = instrument.toString() + " " + str;
            instrument.setChanged(false);
        }

        return str;
    }

    /* Oitava */
    public void incrementOctave() {
        octave.increment();
    }

    public void decrementOctave() {
        octave.decrement();
    }

    public void changeOctave(int value) {
        octave.set(value);
    }

    /* Tempo */
    public void incrementTempo(int amount) {
        tempo.increment(amount);
    }

    public void decrementTempo(int amount) {
        tempo.decrement(amount);
    }

    /* Sustenido */
    public void setSharp(boolean value) {
        sharp = value;
    }

    /* Instrumento */
    public void nextInstrument() {
        instrument.nextInstrument();
    }

    public void prevInstrument() {
        instrument.prevInstrument();
    }

    /* Ataque */
    public void incrementAttack(int amount) {
        attack.increment(amount);
    }

    public void decrementAttack(int amount) {
        attack.decrement(amount);
    }

    /* Duração */
    public void incrementDuration() {
        duration.increment();
    }

    public void decrementDuration() {
        duration.decrement();
    }
}
