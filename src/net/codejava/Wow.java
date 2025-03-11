package src.net.codejava;
import java.io.File;


import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.rendering.PDFRenderer;


public class Wow extends JPanel {

    public Wow() {
        setLayout(new BorderLayout());

        try {
            PDDocument document = Loader.loadPDF(new File("Kin.pdf"));
            PDFRenderer renderer = new PDFRenderer(document);
            JScrollPane scrollPane = new JScrollPane(new PDFPanel(renderer));
            add(scrollPane, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Wow");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Wow());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
