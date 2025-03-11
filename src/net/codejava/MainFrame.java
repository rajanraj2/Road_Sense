package src.net.codejava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
    JButton button;
    JTextArea textArea;

    public MainFrame() {
        // Set up the main frame
        super("My App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the button and text area
        button = new JButton("Open Window");
        textArea = new JTextArea();

        // Add action listener to the button
        button.addActionListener(this);

        // Add the components to the frame
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel);

        // Set the size and make the frame visible
        setSize(400, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Create a new window and set the content
        JFrame newFrame = new JFrame("New Window");
        JTextArea newTextArea = new JTextArea();
        newTextArea.setText("This is the main content.");
        newFrame.add(new JScrollPane(newTextArea));
        newFrame.setSize(300, 300);
        newFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the main frame
        MainFrame frame = new MainFrame();
    }
}
