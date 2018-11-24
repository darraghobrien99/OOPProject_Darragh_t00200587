import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.Timer;


public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;
    JButton addQButton;
    JButton EnterButton;
    JButton backButton;
    JButton nxtButton;
    JPanel change = new JPanel(null);
    Container contain;
    JLabel heading;
    JLabel question = new JLabel();
    JLabel usernameLabel;
    JLabel passwordLabel;
    JButton[] buttons = new JButton[4];
    Timer timer = null;
    int seconds = 60;
    private static String username = "admin";
    private static String password = "master";
    ArrayList<Question> quizQuestions = QuestionFile.read();
    Question newQ = new Question();
    private int maxQuestions = 10;
    private int correct;
    private String choice;
    private int score=0;
    JRadioButton[] rButtons = new JRadioButton[4];
    Scanner scanner = new Scanner(System.in);


    public MainMenuGUI() {

        //JFrame

        super("10 Question Quiz");
        getContentPane().setLayout(null);
        setSize(800, 550);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //panel


        change.setBackground(Color.GRAY);
        change.setBounds(0, 0, 800, 800);
        getContentPane().add(change);

        // Heading

        heading = new JLabel("Test Your Knowledge");
        heading.setForeground(new Color(59, 89, 182));
        heading.setFont(new Font("Tahoma", Font.BOLD, 40));
        heading.setBounds(160, 0, 700, 200);
        change.add(heading);

        //play button

        playButton = new JButton("Play");
        playButton.setFocusPainted(false);
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(59, 89, 182));
        playButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        playButton.setBounds(100, 350, 100, 100);
        change.add(playButton);

        //score button

        scoresButton = new JButton("Leaderboard");
        scoresButton.setFocusPainted(false);
        scoresButton.setForeground(Color.WHITE);
        scoresButton.setBackground(new Color(59, 89, 182));
        scoresButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        scoresButton.setBounds(170, 350, 200, 100);
        change.add(scoresButton);

        //add Question Button
        addQButton = new JButton("Add Question");
        addQButton.setFocusPainted(false);
        addQButton.setForeground(Color.WHITE);
        addQButton.setBackground(new Color(59, 89, 182));
        addQButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addQButton.setBounds(350, 350, 200, 100);
        change.add(addQButton);


        //exit Button

        exitButton = new JButton("Exit");
        exitButton.setFocusPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(59, 89, 182));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        exitButton.setBounds(550, 350, 100, 100);
        change.add(exitButton);

        playButton.addActionListener(this);
        scoresButton.addActionListener(this);
        addQButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            contain = getContentPane();
            contain.removeAll();
            startQuiz();
        } else if (e.getSource() == scoresButton) {
           showLeaderboard();
        } else if (e.getSource() == addQButton) {
            contain = getContentPane();
            contain.removeAll();
            addQuestion();
        } else
            MainMenuGUI.exitQuiz();

    } //end of action Performed

    private void startQuiz() {

        // playerDetails();
        randomQuestion();
        change = new JPanel(null);
        change.setBounds(0, 0, 800, 800);
        change.setBackground(Color.GRAY);


        //Added by JB - the call to the read() here will read the questions, answers and correct index from the file on disk
        //and put them into an arraylist of Question objects. Then the contents of this arraylist is just displayed to the screen
        //via a loop for test purposes

        quizQuestions = QuestionFile.read();
        //QuestionFile.write(quizQuestions); //JB added test code to try to write arraylist of Question objects to file

        for (Question q : quizQuestions) {


/*
            System.out.println(q.getQuestion());
            System.out.println("A. " + q.getAnswers()[0]);
            System.out.println("B. " + q.getAnswers()[1]);
            System.out.println("C. " + q.getAnswers()[2]);
            System.out.println("D. " + q.getAnswers()[3]);

            choice = scanner.nextLine();

            if(choice == q.getCorrectAnswerIndex()){
                score++;
            }

*/


            double currentQ = Math.random() * 10;
            q = quizQuestions.get((int)currentQ);
            question.setText(q.getQuestion());
            question.setBounds(160, -20, 800, 200);
            question.setFont(new Font("Tahoma", Font.BOLD, 18));
            question.setForeground(new Color(59, 89, 182));

                for(int x=0; x<buttons.length;x++) {
                    double z = Math.random() * 4;
                    buttons[0] = new JButton(q.getAnswers()[(int) z]);    // Initialize method 1
                    buttons[0].setBounds(100, 100, 300, 100);
                    buttons[1] = new JButton(q.getAnswers()[(int) z]);
                    buttons[1].setBounds(400, 100, 300, 100);
                    buttons[2] = new JButton(q.getAnswers()[(int) z]);    // Initialize method 1
                    buttons[2].setBounds(100, 300, 300, 100);
                    buttons[3] = new JButton(q.getAnswers()[(int) z]);
                    buttons[3].setBounds(400, 300, 300, 100);
                }
            change.add(buttons[0]);
            change.add(buttons[1]);
            change.add(buttons[2]);
            change.add(buttons[3]);


            nxtButton = new JButton("Next");
            nxtButton.setFocusPainted(false);
            nxtButton.setForeground(Color.WHITE);
            nxtButton.setBackground(new Color(59, 89, 182));
            nxtButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            nxtButton.setBounds(550, 470, 200, 40);
            nxtButton.addActionListener(e -> {
                if(e.getSource() == nxtButton){

                change.removeAll();
                change.invalidate();
                change.validate();
                }
            });
            change.add(nxtButton);





            // System.out.println(q);



            /*

            for (int j = 0; j < buttons.length - 1; j++) {
                for(int x = 0; x<q.getAnswers().length;x++) {



                    buttons[j].setText(q.getAnswers()[x]);
                    //generate a random number to determine where correct goes
                    j = (int) Math.random() * 4;
                    //put the correct answer to the random button
                     for(int i=1; i<= q.getAnswers().length; i++)
                     buttons[(j + i) %  q.getAnswers().length] = new JButton(q.getAnswers()[i-1]);

                }

                //  questionsOnPanel(q);
                change.add(buttons[j]);
            }*/

            // System.out.println(q);
        }
        change.add(question);




        contain.add(change);
        change.invalidate();
        change.repaint();


    }


    private  void showLeaderboard() {

    }

    //Add Question Method
    private void addQuestion() {


        change = new JPanel(null);
        change.setBounds(0, 0, 800, 800);
        change.setBackground(Color.GRAY);

        contain.add(change);
        change.invalidate();
        change.repaint();

        heading = new JLabel("Enter Username & Password, Quiz Master");
        heading.setForeground(new Color(59, 89, 182));
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(150, -50, 900, 200);
        change.add(heading);


        EnterButton = new JButton("Enter");
        EnterButton.setFocusPainted(false);
        EnterButton.setForeground(Color.WHITE);
        EnterButton.setBackground(new Color(59, 89, 182));
        EnterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        EnterButton.setBounds(400, 200, 100, 50);
        change.add(EnterButton);

        backButton = new JButton("Go Back");
        backButton.setFocusPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(59, 89, 182));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        backButton.setBounds(270, 200, 100, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    dispose();  //https://stackoverflow.com/questions/30861139/how-to-go-back-to-the-previous-gui-when-a-button-is-clicked-in-java
                    new MainMenuGUI().setVisible(true);
                }
            }
        });
        change.add(backButton);


        usernameLabel = new JLabel("Enter Username:");
        usernameLabel.setBounds(250, 50, 100, 100);
        JTextField admin = new JTextField(10);
        admin.setBounds(350, 85, 150, 25);

        change.add(usernameLabel);
        change.add(admin);

        passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(250, 100, 100, 100);
        JPasswordField pass = new JPasswordField(10);
        pass.setBounds(350, 140, 150, 25);
        pass.setEchoChar('*');
        change.add(passwordLabel);
        change.add(pass);
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField input = (JPasswordField) e.getSource();
                char[] passy = input.getPassword();
                String p = new String(passy);

                if (p.equals(password)) {
                    addQuizQuestion();
                } else
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                addQuestion();


            }//End of AP
        });//End AL


    }//End Method


    private static void exitQuiz() {

        JOptionPane.showMessageDialog(null, "Thank you for playing! Goodbye!");
        System.exit(0);
    }

    //AddQuizQuestion Method

    private void addQuizQuestion() {

        String question;

        String[] answers = new String[4];

        int correctAnswer;
        Question addQ = new Question();

        addQ.setQuestion(JOptionPane.showInputDialog("Enter Question:"));

        for (int j = 0; j < answers.length; j++) {

            answers[j] = JOptionPane.showInputDialog("Enter answer:");

            addQ.setAnswers(new String[]{answers[j]});

        }

        addQ.setCorrectAnswerIndex(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Answer Index:")));
        quizQuestions.add(addQ);
        // QuestionFile.write(quizQuestions);


    }//End Method


    private void randomQuestion() {

        Collections.shuffle(quizQuestions);

    }//End Method

    private void playerDetails() {

        Player player = new Player();
        player.setName(JOptionPane.showInputDialog("Please enter your name:"));
        player.setUsername(JOptionPane.showInputDialog("Please enter your username"));
        player.setAge(Integer.parseInt(JOptionPane.showInputDialog("Please enter your age:")));
        JOptionPane.showMessageDialog(null, "Lets Play " + player.getUsername());

    }


    private void questionsOnPanel(Question q) {
        /*
            question.setText(q.getQuestion());
           change.add(question);

            //assign answer to buttons
            for (int j = 0; j < buttons.length - 1; j++) {
                buttons[j].setBounds(0, 300, 400, 100);

                buttons[j].setText(q.getAnswers());
                //generate a random number to determine where correct goes
                j = (int) Math.random() * 4;
                //put the correct answer to the random button
                buttons[j] = new JButton(q.getCorrectAnswerIndex());
               change.add(buttons[j]);

            }


        }
        */

        /*

        question.setBounds(0, 100, 800, 100);
        question.setText(q.getQuestion());
        change.add(question);

        //create buttons for answers
        buttons = new JButton[4];


        //assign answer to buttons
        for (int i = 0; i < buttons.length - 1; i++) {
            buttons[i].setBounds(0, 300, 400, 100);

            buttons[i].setText(q.getAnswers());
            //generate a random number to determine where correct goes
            i = (int) Math.random() * 4;
            //put the correct answer to the random button
            buttons[i] = new JButton(q.getCorrectAnswerIndex());
            change.add(buttons[i]);

        }


        }






*/


    }

}



