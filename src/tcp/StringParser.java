package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;

public class StringParser {
    private Music music;

    public StringParser() {
        music = new Music();
    }

    public StringParser(int bpm) {
        this();
        this.music.getTempo().set(bpm);
    }

    public Music getMusic() {
        return music;
    }

    public String makeNote(String str) {
        return music.makeNote(str);
    }

    public String parseChar(char c) {
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

            case 'Ç':
                instruction = makeNote("C");

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
                music.incrementOctave();
                break;

            // Diminui uma oitava
            case 'I':
            case 'Í':
                music.decrementOctave();
                break;

            // Mudanças de BMP
            case '<': // Diminui um pouco o BMP
                music.decrementTempo(Tempo.SMALL_INCREMENT);
                break;

            case '>': // Aumenta um pouco o BMP
                music.incrementTempo(Tempo.SMALL_INCREMENT);
                break;

            case '{': // Diminui bastante o BMP
                music.decrementTempo(Tempo.BIG_INCREMENT);
                break;

            case '}': // Aumenta bastante o BMP
                music.incrementTempo(Tempo.BIG_INCREMENT);
                break;

            // Insere um sustenido na próxima nota
            case '#':
                music.setSharp(true);
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
                music.changeOctave(Character.getNumericValue(c));
                break;

            case '?':
            case '.':
                music.changeOctave(Octave.DEFAULT_OCTAVE);
                break;

            case ' ':
                instruction = "A0a0"; // Nota que representará uma pausa (silêncio)
                break;

            case '\n':
                music.nextInstrument();
                break;

            case '\r':
                music.nextInstrument();
                break;

            case '!':
                music.incrementAttack(Attack.SMALL_INCREMENT);
                break;

            case ';':
                music.decrementAttack(Attack.SMALL_INCREMENT);
                break;

            case '$':
                music.incrementAttack(Attack.BIG_INCREMENT);
                break;

            case '%':
                music.decrementAttack(Attack.BIG_INCREMENT);
                break;

            case '\"':
                music.incrementDuration();
                break;

            case '\'':
                music.decrementDuration();
                break;
        }

        return instruction;
    }

    public String parse(BufferedReader buffer) throws IOException {
        StringBuilder result = new StringBuilder();
        String line = null;
        while ((line = buffer.readLine()) != null) {
            result.append(parse(line));
        }
        return result.toString().trim();
    }

    public String parse(String raw) {
        StringBuilder result = new StringBuilder();

        // Começa com o tempo padrão.
        result.append(music.getTempo().toString()).append(" ");

        // Converte as letras para maiúsculas
        String uppercase = raw.toUpperCase(new Locale("pt", "BR"));

        // Para cada caractere, incluir seu resultado na string seguido de um espaço,
        // pois JFugue espera os tokens separados por espaço.
        String parsedString = null;
        for (char c : uppercase.toCharArray()) {
            parsedString = parseChar(c);
            // Só incluir se o resultado não for vazio.
            if (!parsedString.isEmpty()) {
                result.append(parsedString).append(" ");
            }
        }

        return result.toString().trim();
    }
}
