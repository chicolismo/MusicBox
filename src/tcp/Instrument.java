package tcp;

/**
 * Retorna um objeto do tipo Instrument, que mantém a informação dos instrumentos disponíveis, bem como do instrumento
 * atual da música.
 * <p>
 * <p>
 * Também é responsável pela mudança do instrumento.
 * </p>
 */
public class Instrument {
    public static final int DEFAULT_ID;
    public static final int NUMBER_OF_INSTRUMENTS;
    public static final Id[] IDS;
    private static final String format = "I[%s]";

    static {
        IDS = Id.values();
        NUMBER_OF_INSTRUMENTS = IDS.length;
        DEFAULT_ID = Id.PIANO.ordinal();
    }

    private int currentInstrument;
    private boolean hasChanged;

    public Instrument() {
        currentInstrument = DEFAULT_ID;
        hasChanged = false;
    }

    public int getInstrument() {
        return currentInstrument;
    }

    public void setInstrument(Id id) {
        int ordinal = id.ordinal();
        if (ordinal != currentInstrument) {
            setChanged(true);
            currentInstrument = ordinal;
        }
    }

    public void setInstrument(int index) {
        if (index != currentInstrument) {
            currentInstrument = index;
            setChanged(true);
        }
    }

    public boolean isChanged() {
        return hasChanged;
    }

    public void setChanged(boolean value) {
        hasChanged = value;
    }

    @Override
    public String toString() {
        return String.format(format, IDS[currentInstrument].toString());
    }

    public void nextInstrument() {
        setChanged(true);
        if (currentInstrument < (NUMBER_OF_INSTRUMENTS - 1)) {
            ++currentInstrument;
        } else {
            currentInstrument = 0;
        }
    }

    public void prevInstrument() {
        setChanged(true);
        if (currentInstrument > 0) {
            --currentInstrument;
        } else {
            currentInstrument = NUMBER_OF_INSTRUMENTS - 1;
        }
    }

    public enum Id {
        ACCORDIAN, ACOUSTIC_BASS, ACOUSTIC_GRAND, AGOGO, ALTO_SAX, APPLAUSE, ATMOSPHERE,
        BAGPIPE, BANJO, BARITONE_SAX, BASSLEAD, BASSOON, BIRD_TWEET, BLOWN_BOTTLE, BOWED, BRASS_SECTION, BREATH_NOISE,
        BRIGHT_ACOUSTIC, BRIGHTNESS, CALLIOPE, CELESTA, CELLO, CHARANG, CHIFF, CHOIR, CHOIR_AAHS, CHURCH_ORGAN,
        CLARINET, CLAVINET, CONTRABASS, CRYSTAL, DISTORTION_GUITAR, DRAWBAR_ORGAN, DULCIMER, ECHOES,
        ELECTRIC_BASS_FINGER, ELECTRIC_BASS_PICK, ELECTRIC_CLEAN_GUITAR, ELECTRIC_GRAND, ELECTRIC_JAZZ_GUITAR,
        ELECTRIC_MUTED_GUITAR, ELECTRIC_PIANO, ELECTRIC_PIANO_1, ELECTRIC_PIANO_2, ENGLISH_HORN, FIDDLE, FIFTHS, FLUTE,
        FRENCH_HORN, FRETLESS_BASS, FX_ATMOSPHERE, FX_BRIGHTNESS, FX_CRYSTAL, FX_ECHOES, FX_GOBLINS, FX_RAIN, FX_SCI,
        FX_SOUNDTRACK, GLOCKENSPIEL, GOBLINS, GUITAR, GUITAR_FRET_NOISE, GUITAR_HARMONICS, GUNSHOT, HALO, HARMONICA,
        HARPISCHORD, HELICOPTER, HONKEY_TONK, INSTRUMENT_NAME, KALIMBA, KOTO, LEAD_BASSLEAD, LEAD_CALLIOPE,
        LEAD_CHARANG, LEAD_CHIFF, LEAD_FIFTHS, LEAD_SAWTOOTH, LEAD_SQUARE, LEAD_VOICE, MARIMBA, MELODIC_TOM, METALLIC,
        MUSIC_BOX, MUTED_TRUMPET, NEW_AGE, NYLON_STRING_GUITAR, OBOE, OCARINA, ORCHESTRA_HIT, ORCHESTRAL_STRINGS,
        OVERDRIVEN_GUITAR, PAD_BOWED, PAD_CHOIR, PAD_HALO, PAD_METALLIC, PAD_NEW_AGE, PAD_POLYSYNTH, PAD_SWEEP,
        PAD_WARM, PAN_FLUTE, PERCUSSIVE_ORGAN, PIANO, PICCOLO, PIZZICATO_STRINGS, POLYSYNTH, RAIN, RECORDER, REED_ORGAN,
        REVERSE_CYMBAL, ROCK_ORGAN, SAWTOOTH, SCI, SEASHORE, SHAMISEN, SHANAI, SITAR, SKAKUHACHI, SLAP_BASS_1,
        SLAP_BASS_2, SOPRANO_SAX, SOUNDTRACK, SQUARE, STEEL_DRUMS, STEEL_STRING_GUITAR, STRING_ENSEMBLE_1,
        STRING_ENSEMBLE_2, SWEEP, SYNTH_BASS_1, SYNTH_BASS_2, SYNTH_DRUM, SYNTH_STRINGS_1, SYNTH_STRINGS_2, SYNTH_VOICE,
        SYNTHBRASS_1, SYNTHBRASS_2, TAIKO_DRUM, TANGO_ACCORDIAN, TELEPHONE_RING, TENOR_SAX, TIMPANI, TINKLE_BELL,
        TREMOLO_STRINGS, TROMBONE, TRUMPET, TUBA, TUBULAR_BELLS, VIBRAPHONE, VIOLA, VIOLIN, VOICE, VOICE_OOHS, WARM,
        WHISTLE, WOODBLOCK, XYLOPHONE
    }
}
