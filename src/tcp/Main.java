package tcp;

import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args) {
        Player p = new Player();

        StringParser parser = new StringParser();
        //String input = "C5a50";
        //String output = parser.parse(input);
        String output = "C5wwa90d127";
        System.out.println(output);
        p.play(output);
    }
}
