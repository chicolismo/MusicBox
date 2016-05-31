package tcp;

import java.util.Locale;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by chico on 27/05/16.
 */
public class StringParser {

    private Note note;
    private Octave octave;
    private Tempo tempo;
    private Sharp sharp;

    public StringParser() {
        note = new Note();
        tempo = new Tempo();
        octave = new Octave();
        sharp = new Sharp();
    }

    public String makeNote(String str) {
        return addModifiers(note.make(str, sharp, octave));
    }

    public String addModifiers(String str) {
        if (tempo.hasChanged()) {
            tempo.setUnchanged();
            str = tempo.toString() + " " + str;
        }
        return str;
    }

    public void changeSharp(boolean value) {
        if (value) {
            sharp.setActive();
        } else {
            sharp.setInactive();
        }
    }

    public void changeOctave(int value) {
        octave.set(value);
    }

    public String parse(char c) {
        String instruction = "";

        switch (c) {
            // Se a letra for de uma das notas, inserir a nota.
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
                instruction = makeNote(String.valueOf(c));
                break;

            // Para as versões de "A" com acentos, tranformar em "A".
            case 'Á':
            case 'À':
            case 'Ã':
            case 'Â':
                instruction = makeNote("A");
                break;

            // Para as versões de "E" com acentos, tranformar em "E".
            case 'É':
            case 'Ê':
                instruction = makeNote("E");
                break;

            // Aumenta uma oitava
            case 'O':
            case 'Ó':
            case 'Ô':
            case 'Õ':
                octave.increase();
                break;

            // Diminui uma oitava
            case 'I':
            case 'Í':
                octave.decrease();
                break;

            // Mudanças de BMP
            case '<': // Aumenta BMP em 10
                tempo.decrease(10);
                break;

            case '>': // Diminui BMP em 10
                tempo.increase(10);
                break;

            case '{': // Aumenta BMP em 100
                tempo.decrease(100);
                break;

            case '}': // Diminui BMP em 100
                tempo.increase(100);
                break;

            // Insere um sustenido na próxima nota
            case '#':
                changeSharp(true);
                break;

            // Muda para a oitava selecionada
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
                changeOctave(Character.getNumericValue(c));
                break;

            case ' ':
            case '\n':
            case '\r':
                instruction = " ";
                break;
        }

        return instruction;
    }

    public String parse(String raw) {
        StringBuilder result = new StringBuilder();

        // Começa com o tempo padrão.
        result.append(tempo.toString()).append(" ");

        // Converte as letras para maiúsculas
        String uppercase = raw.toUpperCase(new Locale("pt", "BR"));

        // Para cada caractere, incluir seu resultado na string seguido de um espaço,
        // pois JFugue espera os tokens separados por espaço.
        String parsedString = null;
        for (char c : uppercase.toCharArray()) {
            parsedString = parse(c);
            // Só incluir se o resultado não for vazio.
            if (!parsedString.isEmpty()) {
                result.append(parsedString).append(" ");
            }
        }

        return result.toString().trim();
    }
}
