package src.net.codejava;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginFrame extends JFrame {
   private JLabel headingLabel, userLabel, passLabel;
   private JTextField userTextField;
   private JPasswordField passPasswordField;
   private JButton loginButton;

   public LoginFrame() {
      super("Roadsense Login");
      setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.insets = new Insets(5, 10, 5, 10);

      headingLabel = new JLabel("Roadsense");
      headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.gridwidth = 2;
      constraints.ipady = 20;
      constraints.anchor = GridBagConstraints.CENTER; // center the label horizontally
      add(headingLabel, constraints);

      userLabel = new JLabel("Username:");
      constraints.gridx = 0;
      constraints.gridy = 1;
      constraints.gridwidth = 1;
      constraints.ipady = 0;
      add(userLabel, constraints);

      userTextField = new JTextField();
      constraints.gridx = 1;
      constraints.gridy = 1;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      constraints.ipady = 0;
      constraints.weightx = 1;
      add(userTextField, constraints);

      passLabel = new JLabel("Password:");
      constraints.gridx = 0;
      constraints.gridy = 2;
      constraints.gridwidth = 1;
      add(passLabel, constraints);

      passPasswordField = new JPasswordField();
      constraints.gridx = 1;
      constraints.gridy = 2;
      constraints.gridwidth = GridBagConstraints.REMAINDER;
      constraints.weightx = 1;
      add(passPasswordField, constraints);

      loginButton = new JButton("Login");
      constraints.gridx = 0;
      constraints.gridy = 3;
      constraints.gridwidth = 2;
      add(loginButton, constraints);
      // implement the action performed method for the login button
      loginButton.addActionListener((ActionListener) new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String username = userTextField.getText();
            String password = new String(passPasswordField.getPassword());

            try {
               // connect to the MySQL database
               String url = "jdbc:mysql://localhost:3306/demo";
               String user = "root";
               String passwordDB = "";
               Connection con = DriverManager.getConnection(url, user, passwordDB);

               // create a statement and execute the query
               Statement stmt = con.createStatement();
               String query = "SELECT * FROM account WHERE username='" + username + "' AND password='" + password + "'";
               ResultSet rs = stmt.executeQuery(query);
               // MenuFrame m = new MenuFrame();

               // check if the user exists in the database
               if (rs.next()) {
                  DrivingSchool mainframe = new DrivingSchool();
               

               } else {
                  JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
               }

               // close the statement and connection
               stmt.close();
               con.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
         }
      });

      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String[] args) {
      new LoginFrame();
   }
}