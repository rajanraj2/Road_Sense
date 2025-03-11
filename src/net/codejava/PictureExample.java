package src.net.codejava;

import javax.swing.*;

import javax.swing.*;

public class PictureExample {
   public static void main(String[] args) {
      // Create a JFrame with a title
      JFrame frame = new JFrame("Picture Example");

      // Create an ImageIcon with the filename of the image
      ImageIcon icon = new ImageIcon("Background.jpeg");

      // Create a JLabel with the ImageIcon
      JLabel label = new JLabel(icon);

      // Add the JLabel to the JFrame
      frame.add(label);

      // Set the size and visibility of the frame
      frame.setSize(300, 200);
      frame.setVisible(true);
   }
}
