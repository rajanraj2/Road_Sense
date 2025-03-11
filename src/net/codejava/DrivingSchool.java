package src.net.codejava;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DrivingSchool {

        /**
         * @param args
         */
        public static void main(String[] args) {

                JFrame frame = new JFrame("ROAD SENSE");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1500, 800);

                JTabbedPane tabbedPane = new JTabbedPane();

                // home panel
                JPanel homePanel = new JPanel();
                homePanel.add(new JLabel("One stop solution to learn driving"));
                homePanel.add(new JLabel(""));
                tabbedPane.addTab("Home", homePanel);

                // Must know facts panel
                JPanel factsPanel = new JPanel();
                factsPanel.add(new JLabel("Must know facts:"));
                factsPanel.add(new JLabel("- Fact 1"));
                factsPanel.add(new JLabel("- Fact 2"));
                tabbedPane.addTab("Must Know Facts", factsPanel);

                // Good practices panel
                JPanel practicesPanel = new JPanel();
                String descriptionText = ("<html><br><br>1) Stay alert and actively pay attention to your actions and those of the drivers around you when you are driving.<br><br>"
                                +
                                "2) Avoid making assumptions about what other drivers are going to do.<br><br>" +
                                "3) Always use your turn signals in advance of making a lane change or turning.<br><br>"
                                +
                                "4) Wear your seat belt to increase your chances of staying safe in an accident.<br><br>"
                                +
                                "5) Follow traffic signals and come to a complete stop at stop signs and red lights.<br><br>"
                                +
                                "6) Do not text and drive as it is never acceptable to send text messages when operating a motor vehicle.<br><br>"
                                +
                                "7) Obey speed limits as they are carefully selected to maximize safety for drivers and others.<br><br>"
                                +
                                "8) Make adjustments for weather conditions such as rain, snow, or fog by using extra precautions when driving.<br><br>"
                                +
                                "9) Exercise patience and avoid rushing as many accidents are caused by impatient drivers.</html>");
                JLabel descriptionLabel = new JLabel(descriptionText, null, 0);
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                descriptionLabel.setAlignmentX(10);
                practicesPanel.add(descriptionLabel);
                tabbedPane.addTab("Good Practices", practicesPanel);

                // License instructions panel
                JPanel licensePanel = new JPanel();
                String descriptionText2 = ("""
                                <html><br>1) Visit the website parivahan.gov.in<br><br>\
                                2) Select the Online Services tab and click on the Driving Licence Related Services option.<br><br>\
                                3) Select the state from which you wish to apply.<br><br>\
                                4) Click on the Apply for Driving Licence option.<br><br>\
                                5) Complete the applicant details.<br><br>\
                                6) Upload scanned copies of the necessary documents.<br><br>\
                                7) Pay the application fee.<br><br><br>\
                                You can also apply for a driving license through offline mode by visiting your nearest <br>Regional Transport Office (RTO) and submitting the required documentation.<br><br>\
                                <br>\
                                Click here to apply for <a href=\"https://www.codingninjas.com/codestudio/contests\">Learner's License/Driving License.</h4></body></html>
                                <br><br><br>""");
                JLabel descriptionLabel2 = new JLabel(descriptionText2, null, 0);
                descriptionLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
                descriptionLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
                descriptionLabel2.setAlignmentX(10);
                licensePanel.add(descriptionLabel2);
                tabbedPane.addTab("License Instructions", licensePanel);

                descriptionLabel2.addMouseListener((MouseListener) new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                                try {
                                        Desktop.getDesktop().browse(new URI(
                                                        "https://parivahan.gov.in/parivahan//en"));
                                } catch (IOException | URISyntaxException ex) {
                                        ex.printStackTrace();
                                }
                        }
                });

                // Quizzes and games panel

                // Create a new JButton
                JButton button = new JButton("Start Quiz");

                JPanel quizzesPanel = new JPanel();
                quizzesPanel.add(new JLabel("Quizzes and games:"));
                quizzesPanel.add(button);
                quizzesPanel.add(new JButton("Play Game"));
                tabbedPane.addTab("Quizzes and Games", quizzesPanel);

                // Add an ActionListener to the button
                button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Code to run the package goes here
                                QuizGame qg = new QuizGame();

                        }

                });

                // // Garage manager panel
                JPanel garagePanel = new JPanel();
                garagePanel.setLayout(new BorderLayout());
                // garagePanel.add(new JLabel("Garage Manager:"), BorderLayout.NORTH);
                // String[] columnNames = { "Vehicle", "Make", "Model", "Year" };
                // Object[][] data = {
                // { "Car", "Honda", "Civic", "2020" },
                // { "Motorcycle", "Yamaha", "R1", "2019" }
                // };
                // JTable table = new JTable(data, columnNames);
                // garagePanel.add(new JScrollPane(table), BorderLayout.CENTER);
                // garagePanel.add(new JButton("Add Vehicle"), BorderLayout.SOUTH);
                // tabbedPane.addTab("Garage Manager", garagePanel);

                // image addition
                // JLabel logo = new JLabel(new
                // ImageIcon(ClassLoader.getSystemResource("Background2.jpeg")));
                // logo.setBounds(0, 0, 800, 800);
                // frame.add(logo);
                String[] columnNames = { "Vehicle", "Company", "Model", "Year", "Last Service", "Next Service" };
                Object[][] data = { { "", "", "", "", "", "" } };
                DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
                JTable table = new JTable(tableModel);
                JScrollPane scrollPane = new JScrollPane(table);

                // Create the input fields
                JTextField nameField = new JTextField(20);
                JTextField locationField = new JTextField(20);
                JTextField dateField = new JTextField(20);
                JTextField descriptionField = new JTextField(20);
                JTextField lasField = new JTextField(20);
                JTextField nTextField = new JTextField(20);

                // Create a sub-panel to hold the input fields
                JPanel inputPanel = new JPanel(new GridLayout(7, 2));
                inputPanel.add(new JLabel("Vehicle"));
                inputPanel.add(nameField);
                inputPanel.add(new JLabel("Make"));
                inputPanel.add(locationField);
                inputPanel.add(new JLabel("Model"));
                inputPanel.add(dateField);
                inputPanel.add(new JLabel("Year"));
                inputPanel.add(descriptionField);
                inputPanel.add(new JLabel("Last Service"));
                inputPanel.add(lasField);
                inputPanel.add(new JLabel("Next Service"));
                inputPanel.add(nTextField);

                // Create a button to add the input to the table
                JButton addButton = new JButton("Add");
                addButton.addActionListener(e -> {
                        String name = nameField.getText();
                        String location = locationField.getText();
                        String date = dateField.getText();
                        String description = descriptionField.getText();
                        String laString = lasField.getText();
                        String nteString = nTextField.getText();
                        tableModel.addRow(new Object[] { name, location, date, description, laString, nteString });
                        nameField.setText("");
                        locationField.setText("");
                        dateField.setText("");
                        descriptionField.setText("");
                        lasField.setText("");
                        nTextField.setText("");
                });

                garagePanel.add(scrollPane, BorderLayout.CENTER);
                garagePanel.add(inputPanel, BorderLayout.SOUTH);
                garagePanel.add(addButton, BorderLayout.EAST);
                tabbedPane.addTab("Garage Manager", garagePanel);

                // addButton.addActionListener(e -> {
                // String name = nameField.getText();
                // String location = locationField.getText();
                // String date = dateField.getText();
                // String description = descriptionField.getText();
                // String laString = lasField.getText();
                // String nexString = nTextField.getText();
                // tableModel.addRow(new Object[] { name, location, date, description, laString,
                // nexString });

                // // // Save the data to the database
                // // try {
                // // Connection conn =
                // // DriverManager.getConnection("jdbc:mysql://localhost/my_database",
                // // "root", "");
                // // PreparedStatement stmt = conn.prepareStatement(
                // // "INSERT INTO my_table (name, location, date, description) VALUES (?, ?, ?,
                // // ?)");
                // // stmt.setString(1, name);
                // // stmt.setString(2, location);
                // // stmt.setString(3, date);
                // // stmt.setString(4, description);
                // // stmt.executeUpdate();
                // // conn.close();
                // // } catch (SQLException ex) {
                // // ex.printStackTrace();
                // // }

                // // nameField.setText("");
                // // locationField.setText("");
                // // dateField.setText("");
                // // descriptionField.setText("");
                // });
                // frame.add(garagePanel);

                // Create a JPanel to hold the content for the "Hackathons" menu option
                JPanel pdfPanel = new JPanel();
                pdfPanel.setLayout(new BoxLayout(pdfPanel, BoxLayout.Y_AXIS));
                JLabel pdfLabel = new JLabel("                                       ROAD USER GUIDE COURSE");
                pdfLabel.setForeground(Color.black);
                pdfLabel.setFont(new Font("Arial", Font.BOLD, 40));
                pdfLabel.setBounds(170, 90, 400, 150);
                tabbedPane.addTab("Road User Guide", pdfPanel);
                // String[] hackathons = {"<html>HCLTech - All4YOUth presents Code4YOUth
                // Hackathon<br> (AI and IOT)</html>", "Accenture Hack Diva", "Flipkart <Girls
                // Wanna Code/> 4.0","Tata Crucible Hackathon 2023", "ServiceNow Women Code to
                // Win 2023 - India", "Walmart Sparkplug 2022","BUIDL for Web3 Hackathon
                // (2023)", "Optum Stratethon Season 4"};
                // JList<String> hackathonsList = new JList<>(hackathons);

                // // JScrollPane hackathonsScrollPane = new JScrollPane(hackathonsList);
                pdfPanel.add(pdfLabel);
                // hackathonsPanel.add(hackathonsScrollPane);

                // hackathon1
                JLabel codathon1 = new JLabel("  ROAD USER GUIDE  ");
                codathon1.setFont(new Font("Arial", Font.BOLD, 20));
                codathon1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                codathon1.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                codathon1.setText("<html><body><h4><font color = 'red'><br>"
                                                + "</h4></font>"
                                                + "<h4>Welcome to the road user guide. Here one can go through all the chapters and understand the road conditions better.<br>"
                                                + "Click <a href=\"https://www.codingninjas.com/codestudio/contests\">here to get NCERT Road Safety Book</h4></body></html>");
                                // code to change the text back after a delay
                                codathon1.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                try {
                                                        Desktop.getDesktop().browse(new URI(
                                                                        "https://ncert.nic.in/vocational/pdf/ivas104.pdf"));
                                                } catch (IOException | URISyntaxException ex) {
                                                        ex.printStackTrace();
                                                }
                                        }
                                });
                                Timer timer = new Timer(100000000, new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                codathon1.setText("    ROAD USER GUIDE  ");
                                        }
                                });
                                timer.setRepeats(false);
                                timer.start();
                        }

                });
                pdfPanel.add(codathon1);

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
                pdfPanel.add(codathon2);

                // hackathon3
                JLabel codathon3 = new JLabel("2) Guidelines To Drivers With Respect To Other Road Users");
                codathon3.setFont(new Font("Arial", Font.BOLD, 20));
                codathon3.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                codathon3.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                codathon3.setText("<html><body><h2><font color = 'red'><br>"
                                                + "2. GUIDELINES TO DRIVERS WITH RESPECT TO OTHER ROAD USERS</h2></font>"
                                                + "<h3>n the previous chapter, we have discussed the responsibilities and manoeuvres to be followed by a pedestrian in accordance with the movement of the traffic.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay

                                codathon3.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                codathon3.setText(
                                                                "2) GUIDELINES TO DRIVERS WITH RESPECT TO OTHER ROAD USERS");
                                        }
                                });

                        }

                });
                pdfPanel.add(codathon3);

                // chapter4
                JLabel chapter4 = new JLabel("3) Safe Cycling");
                chapter4.setFont(new Font("Arial", Font.BOLD, 20));
                chapter4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter4.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter4.setText("<html><body><h2><font color = 'red'><br>"
                                                + "3. SAFE CYCLING</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter4.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter4.setText("3) Safe Cycling");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter4);

                // chapter5
                JLabel chapter5 = new JLabel("4) Motor Cyclist");
                chapter5.setFont(new Font("Arial", Font.BOLD, 20));
                chapter5.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter5.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter5.setText("<html><body><h2><font color = 'red'><br>"
                                                + "4. MOTOR CYCLIST</h2></font>"
                                                + "<h3> Motorcycling is an important and popular form of transport. Generally, a driver of a two-wheeler is called as a motor cyclist. A two-wheeler is confined to two passengers; a driver and a pillion rider.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter5.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter5.setText("4) Motor Cyclist");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter5);

                // chapter6
                JLabel chapter6 = new JLabel("5) Auto Drivers");
                chapter6.setFont(new Font("Arial", Font.BOLD, 20));
                chapter6.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter6.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter6.setText("<html><body><h2><font color = 'red'><br>"
                                                + "5. AUTO DRIVERS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter6.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter6.setText("5) Auto Drivers");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter6);

                // chapter7
                JLabel chapter7 = new JLabel("6) Cars");
                chapter7.setFont(new Font("Arial", Font.BOLD, 20));
                chapter7.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter7.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter7.setText("<html><body><h2><font color = 'red'><br>"
                                                + "6. CARS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter7.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter7.setText("6) Cars");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter7);

                // chapter8
                JLabel chapter8 = new JLabel("7) Heavy Vehicles");
                chapter8.setFont(new Font("Arial", Font.BOLD, 20));
                chapter8.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter8.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter8.setText("<html><body><h2><font color = 'red'><br>"
                                                + "7. HEAVY VEHICLES</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter8.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter8.setText("7) Heavy Vehicles");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter8);

                // chapter9
                JLabel chapter9 = new JLabel("8) Vehicle Security");
                chapter9.setFont(new Font("Arial", Font.BOLD, 20));
                chapter9.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter9.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter9.setText("<html><body><h2><font color = 'red'><br>"
                                                + "8. VEHICLE SECURITY</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter9.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter9.setText("8) Vehicle Security");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter9);

                // chapter10
                JLabel chapter10 = new JLabel("9) Stopping Distances");
                chapter10.setFont(new Font("Arial", Font.BOLD, 20));
                chapter10.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter10.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter10.setText("<html><body><h2><font color = 'red'><br>"
                                                + "9. STOPPING DISTANCES</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter10.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter10.setText("9) Stopping Distances");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter10);

                // chapter11
                JLabel chapter11 = new JLabel("10) Use of Mirrors and Indicators");
                chapter11.setFont(new Font("Arial", Font.BOLD, 20));
                chapter11.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter11.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter11.setText("<html><body><h2><font color = 'red'><br>"
                                                + "10. USE OF MIRRORS AND INDICATORS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter11.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter11.setText("10) Use of Mirrors and Indicators");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter11);

                // chapter12
                JLabel chapter12 = new JLabel("11) Reversing");
                chapter12.setFont(new Font("Arial", Font.BOLD, 20));
                chapter12.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter12.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter12.setText("<html><body><h2><font color = 'red'><br>"
                                                + "11. REVERSING</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter12.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter12.setText("11) Reversing");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter12);

                // chapter13
                JLabel chapter13 = new JLabel("12) Turning");
                chapter13.setFont(new Font("Arial", Font.BOLD, 20));
                chapter13.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter13.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter13.setText("<html><body><h2><font color = 'red'><br>"
                                                + "12. TURNING</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter13.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter13.setText("12) Turning");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter13);

                // chapter14
                JLabel chapter14 = new JLabel("13) Waiting and Parking");
                chapter14.setFont(new Font("Arial", Font.BOLD, 20));
                chapter14.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter14.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter14.setText("<html><body><h2><font color = 'red'><br>"
                                                + "13. WAITING AND PARKING</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter14.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter14.setText("13) Waiting and Parking");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter14);

                // chapter15
                JLabel chapter15 = new JLabel("14) Alcohol and Drugs");
                chapter15.setFont(new Font("Arial", Font.BOLD, 20));
                chapter15.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter15.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter15.setText("<html><body><h2><font color = 'red'><br>"
                                                + "14. ALCOHOL AND DRUGS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter15.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter15.setText("14) Alcohol and Drugs");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter15);

                // chapter16
                JLabel chapter16 = new JLabel("15) Pollution");
                chapter16.setFont(new Font("Arial", Font.BOLD, 20));
                chapter16.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter16.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter16.setText("<html><body><h2><font color = 'red'><br>"
                                                + "15. POLLUTION</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter16.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter16.setText("15) Pollution");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter16);

                // chapter17
                JLabel chapter17 = new JLabel("16) Road Junctions");
                chapter17.setFont(new Font("Arial", Font.BOLD, 20));
                chapter17.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter17.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter17.setText("<html><body><h2><font color = 'red'><br>"
                                                + "16. ROAD JUNCTIONS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter17.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter17.setText("16) Road Junctions");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter17);

                // chapter18
                JLabel chapter18 = new JLabel("17) Roundabouts and TrafficIslands");
                chapter18.setFont(new Font("Arial", Font.BOLD, 20));
                chapter18.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter18.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter18.setText("<html><body><h2><font color = 'red'><br>"
                                                + "17. ROUNDABOUTS AND TRAFFICISLANDS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter18.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter18.setText("17) Roundabouts and TrafficIslands");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter18);

                // chapter19
                JLabel chapter19 = new JLabel("18) Road Signs and Road Markings");
                chapter19.setFont(new Font("Arial", Font.BOLD, 20));
                chapter19.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter19.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter19.setText("<html><body><h2><font color = 'red'><br>"
                                                + "18. ROAD SIGNS AND ROAD MARKINGS</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter19.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter19.setText("18) Road Signs and Road Markings");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter19);

                // chapter20
                JLabel chapter20 = new JLabel("19) Traffic Police");
                chapter20.setFont(new Font("Arial", Font.BOLD, 20));
                chapter20.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter20.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter20.setText("<html><body><h2><font color = 'red'><br>"
                                                + "19. TRAFFIC POLICE</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter20.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter20.setText("19) Traffic Police");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter20);

                // chapter21
                JLabel chapter21 = new JLabel("20) Safe Travel");
                chapter21.setFont(new Font("Arial", Font.BOLD, 20));
                chapter21.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter21.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter21.setText("<html><body><h2><font color = 'red'><br>"
                                                + "20. SAFE TRAVEL</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter21.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter21.setText("20) Safe Travel");
                                        }
                                });

                        }

                });
                pdfPanel.add(chapter21);

                // chapter22
                JLabel chapter22 = new JLabel("21) General Do's and Dont's");
                chapter22.setFont(new Font("Arial", Font.BOLD, 20));
                chapter22.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // bottom padding of 10 pixels
                chapter22.addMouseListener((MouseListener) new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                // code to execute when the label is clicked
                                chapter22.setText("<html><body><h2><font color = 'red'><br>"
                                                + "21. GENERAL DO'S AND DONT'S</h2></font>"
                                                + "<h3> Bicycles are almost everybody's first set of wheels. Be a safe cyclist, and you will grow up to be a responsible driver. Learn the art of cycling safely and practise everyday.<br>"
                                                + "</h3></body></html>");
                                // code to change the text back after a delay
                                chapter22.addMouseListener((MouseListener) new MouseAdapter() {
                                        public void mouseClicked(MouseEvent e) {
                                                chapter22.setText("21) General Do's and Dont's");
                                        }
                                });

                        }

                });
                // JScrollPane scrollPane2 = new JScrollPane(pdfPanel);
                // scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                // frame.getContentPane().add(scrollPane2);
                // pdfPanel.add(chapter22);
                // frame.add(pdfPanel);
                frame.add(tabbedPane);
                frame.setVisible(true);
                // frame.setLayout(800, 800);
        }
}
