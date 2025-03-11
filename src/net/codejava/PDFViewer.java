package src.net.codejava;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PDFViewer {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = new File("C:/Users/rans2/Desktop/Learn Java/Java Project New/Ch7.pdf");
            try {
                Desktop.getDesktop().open(selectedFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error opening file");
            }
        }
    }
}