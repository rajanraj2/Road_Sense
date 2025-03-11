package src.net.codejava;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FileOpener extends JFrame {

    private JCheckBox checkBox;
    private JButton openButton;

    public FileOpener() {
        // Create GUI components
        checkBox = new JCheckBox("I have read the file");
        openButton = new JButton("Open next file");
        openButton.setEnabled(true); // Disable button until conditions are met

        // Add event listener to button
        openButton.addActionListener(e -> {
            if (checkBox.isSelected()) {
                openFile("Hj.txt");
            }
        });

        // Add components to panel and frame
        JPanel panel = new JPanel();
        panel.add(checkBox);
        panel.add(openButton);
        add(panel);

        setTitle("File Opener");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private boolean isFileRead() {
        // Check if file is read completely
        try (BufferedReader br = new BufferedReader(new FileReader("Hj.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String content = sb.toString();
            return content.equals("Expected content");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void openFile(String filename) {
        // Open file using Desktop class
        try {
            File file = new File(filename);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileOpener();
    }
}
