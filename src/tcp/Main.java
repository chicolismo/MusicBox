package tcp;

import javax.swing.*;

public class Main {
    private static MainWindow window = new MainWindow();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Music Box");
        frame.setContentPane(new MainWindow().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        /*
        StringParser parser = new StringParser();
        Player p = new Player();
        p.play(parser.parse("aa\nab\nccca"));
        */

        /*
        String fileName = null;

        if (args.length > 0) {
            fileName = args[0];
        } else {
            System.out.println("É preciso fornecer o nome do arquivo a ser lido.");
            System.exit(1);
        }

        Player p = new Player();
        StringParser parser;
        if (args.length > 1) {
            parser = new StringParser(Integer.parseInt(args[1]));
        } else {
            parser = new StringParser();
        }

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(reader);
            String output = parser.parse(buffer);
            reader.close();
            buffer.close();
            System.out.println(output);
            p.play(output);
        } catch (Exception e) {
            System.err.println(String.format("Ocorreu um erro ao tentar ler o arquivo %s", fileName));
            System.err.println(e.getMessage());
        }
        */
    }
}
