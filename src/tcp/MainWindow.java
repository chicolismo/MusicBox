package tcp;

import org.jfugue.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by chico on 14/06/16.
 */
public class MainWindow {
    private static int[] bpmOptions = new int[] {60, 120, 180, 240, 300, 360, 420};
    private JFileChooser chooser;
    private JButton chooseFileButton;
    private JPanel panel;
    private JComboBox<Integer> bpmCombo;
    private JLabel bpmLabel;

    public MainWindow() {
        chooser = new JFileChooser();

        for (int option : bpmOptions) {
            bpmCombo.addItem(option);
        }

        bpmCombo.setSelectedItem(240);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto", "txt");
        chooser.setFileFilter(filter);

        chooseFileButton.addActionListener(e -> {
            int initialBPM = (int) bpmCombo.getSelectedItem();

            int returnVal = chooser.showOpenDialog(panel);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                parseFile(chooser.getSelectedFile().getAbsolutePath(), initialBPM);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    private void parseFile(String filename, int initialBPM) {
        try {
            StringParser parser = new StringParser(initialBPM);
            Player player = new Player();
            FileReader reader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(reader);
            String output = parser.parse(buffer);
            reader.close();
            buffer.close();
            //System.out.println(output);
            player.play(output);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.panel,
                                          String.format("Ocorreu um erro ao tentar ler o arquivo %s", filename));
        }
    }
}
