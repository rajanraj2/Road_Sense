package src.net.codejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizGame extends JFrame implements ActionListener {
    // Declare variables
    JLabel question;
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;
    ButtonGroup options;
    JButton nextButton;
    String[][] questions;
    String[] answers;
    int currentQuestion = 0;
    int score = 0;

    public QuizGame() {
        // Set up the frame
        setTitle("Quiz Game");
        setSize(800, 650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize questions and answers
        questions = new String[][] {
                { "When out at night, what should you wear to be seen easily by traffic?", "dark coloured clothes",
                        "bright flourescent clothes", "pale coloured clothes", "trendy Clothes" },
                { "When is it safe to cross at a zebra crossing?", "when the traffic on both sides has slowed down",
                        "when the traffic on one side has stopped", "when the traffic on both sides has stopped",
                        "when the traffic on one side has slowed down " },
                { "If you are travelling in a lane that has a left-turn arrow marked on the road,can you drive straight ahead?",
                        "Yes", "No", "Maybe", "it's driver's choice" }
        };
        answers = new String[] { "bright flourescent clothes", "when the traffic on both sides has stopped", "No" };

        // Initialize components
        question = new JLabel();
        question.setBounds(50, 80, 600, 20);
        add(question);

        option1 = new JRadioButton();
        option1.setBounds(50, 120, 300, 20);
        option1.setSelected(false);
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(50, 160, 300, 20);
        option2.setSelected(false);
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(50, 200, 300, 20);
        option3.setSelected(false);
        add(option3);

        option4 = new JRadioButton();
        option4.setBounds(50, 240, 300, 20);
        option4.setSelected(false);
        add(option4);

        options = new ButtonGroup();
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);

        nextButton = new JButton("Next");
        nextButton.setBounds(150, 280, 100, 30);
        nextButton.addActionListener(this);
        add(nextButton);

        // Set the first question
        setQuestion();

        // Show the frame
        setVisible(true);
    }

    public void setQuestion() {
        // Set the question and options
        question.setText(questions[currentQuestion][0]);
        option1.setText(questions[currentQuestion][1]);
        option2.setText(questions[currentQuestion][2]);
        option3.setText(questions[currentQuestion][3]);
        option4.setText(questions[currentQuestion][4]);
    }

    public void actionPerformed(ActionEvent e) {
        // Check if the selected answer is correct
        if (option1.isSelected() && answers[currentQuestion].equals(option1.getText())) {
            score++;
        } else if (option2.isSelected() && answers[currentQuestion].equals(option2.getText())) {
            score++;
        } else if (option3.isSelected() && answers[currentQuestion].equals(option3.getText())) {
            score++;
        } else if (option4.isSelected() && answers[currentQuestion].equals(option4.getText())) {
            score++;
        }

        // Move to the next question or show the final score
        currentQuestion++;
        if (currentQuestion < questions.length) {
            setQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Your score: " + score + "/" + questions.length);
            // System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizGame();
    }
}