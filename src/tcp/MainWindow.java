package tcp;

import org.jfugue.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by chico on 14/06/16.
 */
public class MainWindow {
    private JFileChooser chooser;
    private JButton chooseFileButton;
    private JPanel panel;
    private JComboBox bpmCombo;

    public MainWindow() {
        chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto", "txt");
        chooser.setFileFilter(filter);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = chooser.showOpenDialog(panel);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    parseFile(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void parseFile(String filename) {
        try {
            StringParser parser = new StringParser();
            Player player = new Player();
            FileReader reader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(reader);
            String output = parser.parse(buffer);
            reader.close();
            buffer.close();
            System.out.println(output);
            player.play(output);
        } catch (Exception e) {
            String message = e.getMessage();
            JOptionPane.showMessageDialog(this.panel,
                                          String.format("Ocorreu um erro ao tentar ler o arquivo %s, %s", filename,
                                                        message));
        }
    }
}
