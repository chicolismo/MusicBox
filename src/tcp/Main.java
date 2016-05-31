package tcp;

import tcp.StringParser;

import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        Player p = new Player();

        StringParser parser = new StringParser();
        String input = "cde>>>>>>>>>>>>>>>>>>>>>>>>>>>fgabocdefg";
        String output = parser.parse(input);
        System.out.println(output);
        p.play(output);
    }
}
