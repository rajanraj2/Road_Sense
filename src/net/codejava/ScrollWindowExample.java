package src.net.codejava;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class ScrollWindowExample {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Create a JTextArea to hold the content of the window
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setText("This is some sample text.\n".repeat(30));

        // hackathon2
        JLabel codathon2 = new JLabel("1) Pedestrian on the Road");
        codathon2.setFont(new Font("Arial", Font.BOLD, 20));
        codathon2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
        codathon2.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // code to execute when the label is clicked
                codathon2.setText("<html><body><h2><font color = 'red'><br>"
                        + "1. PEDESTRIAN ON THE ROAD</h2></font>"
                        + "<h3> Pedestrian is called the primary road user. He enjoys the right of way on any road. Road safety begins with the pedestrian.<br>"
                        + "</h3></body></html>");
                // code to change the text back after a delay
                codathon2.addMouseListener((MouseListener) new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        codathon2.setText("1) Pedestrian on the Road ");
                    }
                });

            }

        });
        Container pdfPanel;
        // pdfPanel.add(codathon2);

        // Create a JScrollPane to hold the JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a JFrame to hold the scroll pane
        JFrame frame = new JFrame("Scroll Window Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the scroll pane to the JFrame
        frame.getContentPane().add(scrollPane);

        // Set the size of the JFrame
        frame.pack();

        // Display the JFrame
        frame.setVisible(true);
    }
}
