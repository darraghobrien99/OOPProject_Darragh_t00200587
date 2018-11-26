import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;


public class MainMenuGUI extends JFrame implements ActionListener {

    private JButton playButton;
    private JButton scoresButton;
    private JButton exitButton;
    private  JButton addQButton;
    private JButton EnterButton;
    private JButton backButton;
    private JButton nxtButton;
    private JPanel change = new JPanel(null);
    private Container contain;
    private JLabel heading;
    private JLabel question = new JLabel();
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel scoreLabel = new JLabel("Score: 0");
    private JButton[] buttons = new JButton[4];
    private static String username = "admin";
    private static String password = "master";
    private ArrayList<Question> quizQuestions = QuestionFile.read();
    private Question newQ = new Question();
    private Question q = new Question();
    private int score = 0;
    int num = 0;
    private String correctAnswer;




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
    }//End MainMenuGUI

//Action Performed
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

    //Start Quiz Method

    private void startQuiz() {

         playerDetails(); //Asks for player Details

        change = new JPanel(null);
        change.setBounds(0, 0, 800, 800);
        change.setBackground(Color.GRAY);


        //Added by JB - the call to the read() here will read the questions, answers and correct index from the file on disk
        //and put them into an arraylist of Question objects. Then the contents of this arraylist is just displayed to the screen
        //via a loop for test purposes

        quizQuestions = QuestionFile.read(); //read file
        //QuestionFile.write(quizQuestions); //JB added test code to try to write arraylist of Question objects to file

        
            //Assign question to label
            q = quizQuestions.get(randomQuestion());
            question.setText(q.getQuestion());
            question.setBounds(-60, -20, 800, 200);
            question.setHorizontalAlignment(0);
            question.setFont(new Font("Tahoma", Font.BOLD, 14));
            question.setForeground(new Color(59, 89, 182));

            //Assign answers to buttons
            String[] answers = new String[]{q.getAnswers()[0], q.getAnswers()[1], q.getAnswers()[2], q.getAnswers()[3]};
            buttons[0] = new JButton(answers[0]);
            buttons[0].setBounds(200, 100, 200, 100);
            buttons[1] = new JButton(answers[1]);
            buttons[1].setBounds(400, 100, 200, 100);
            buttons[2] = new JButton(answers[2]);
            buttons[2].setBounds(200, 300, 200, 100);
            buttons[3] = new JButton(answers[3]);
            buttons[3].setBounds(400, 300, 200, 100);

            //Score Label
            scoreLabel.setBounds(700, -30, 100, 100);
            change.add(scoreLabel);

            //get Correct Answer from question
            correctAnswer = q.getCorrectAnswerIndex();


            //Message displayed showing if correct or wrong
            for (int x = 0; x < buttons.length; x++) {
                buttons[x].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(e.getActionCommand());
                        if (e.getActionCommand() == correctAnswer) {
                            youScoredRight();
                            JOptionPane.showMessageDialog(null, "Correct \n+1 has been added to your score\n Please Hit next");

                        } else {
                            youScoredWrong();
                            JOptionPane.showMessageDialog(null, "Incorrect \n-1 has been subtracted from your score\n Please Hit next");
                        } //end Else

                    } //End of AE
                });
            }//End of for


            //Next Question Button
            nxtButton = new JButton("Next");
            nxtButton.setFocusPainted(false);
            nxtButton.setForeground(Color.WHITE);
            nxtButton.setBackground(new Color(59, 89, 182));
            nxtButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            nxtButton.setBounds(550, 470, 200, 40);
            nxtButton.addActionListener(e -> {
                if (e.getSource() == nxtButton) {

                    contain = getContentPane();
                    contain.removeAll();
                    num++;
                    nextQuestion();
                }
            });

            //Add buttons to jpanel
            change.add(nxtButton);
            change.add(buttons[0]);
            change.add(buttons[1]);
            change.add(buttons[2]);
            change.add(buttons[3]);


            change.add(question);



            //Repaint panel
            contain.add(change);
            change.invalidate();
            change.repaint();


    }

    //show Leader board method
    private void showLeaderboard() {

    }

    //Add Question Method
    private void addQuestion() {


        change = new JPanel(null);
        change.setBounds(0, 0, 800, 800);
        change.setBackground(Color.GRAY);

        contain.add(change);
        change.invalidate();
        change.repaint();

        //heading label
        heading = new JLabel("Enter Username & Password, Quiz Master");
        heading.setForeground(new Color(59, 89, 182));
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(150, -50, 900, 200);
        change.add(heading);

        //Enter Button
        EnterButton = new JButton("Enter");
        EnterButton.setFocusPainted(false);
        EnterButton.setForeground(Color.WHITE);
        EnterButton.setBackground(new Color(59, 89, 182));
        EnterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        EnterButton.setBounds(400, 200, 100, 50);
        change.add(EnterButton);

        //Back Button
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

        //username label
        usernameLabel = new JLabel("Enter Username:");
        usernameLabel.setBounds(250, 50, 100, 100);
        JTextField admin = new JTextField(10);
        admin.setBounds(350, 85, 150, 25);

        change.add(usernameLabel);
        change.add(admin);

        //password Label
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


    //Exit Quiz
    private static void exitQuiz() {

        JOptionPane.showMessageDialog(null, "Thank you for playing! Goodbye!");
        System.exit(0);
    }

    //Add Quiz Question Method

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
        //QuestionFile.write(quizQuestions);


    }//End Method

    //Provides random question
    private int randomQuestion() {
        Random random = new Random();
        int value = random.nextInt(quizQuestions.size());
        return value;
    }//End Method

        //player details
    private void playerDetails() {

        Player player = new Player();
        player.setName(JOptionPane.showInputDialog("Please enter your name:"));
        player.setUsername(JOptionPane.showInputDialog("Please enter your username"));
        player.setAge(Integer.parseInt(JOptionPane.showInputDialog("Please enter your age:")));

        JOptionPane.showMessageDialog(null, "Lets Play " + player.getUsername());

    }

    //score increases
    private void youScoredRight() {
        score++;
        scoreLabel.setText("Score: " + score);
    }

    //score decreases
    private void youScoredWrong() {
        score--;
        scoreLabel.setText("Score " + score);
    }


    //next question panel
    private void nextQuestion() {

        change = new JPanel(null);
        change.setBounds(0, 0, 800, 800);
        change.setBackground(Color.GRAY);

        contain.add(change);
        change.invalidate();
        change.repaint();

        q = quizQuestions.get(randomQuestion());
        question.setText(q.getQuestion());
        question.setBounds(-30, -20, 800, 200);
        question.setFont(new Font("Tahoma", Font.BOLD, 14));
        question.setForeground(new Color(59, 89, 182));

        change.add(question);


        String[] answers = new String[]{q.getAnswers()[0], q.getAnswers()[1], q.getAnswers()[2], q.getAnswers()[3]};
        buttons[0] = new JButton(answers[0]);
        buttons[0].setBounds(200, 100, 200, 100);
        buttons[1] = new JButton(answers[1]);
        buttons[1].setBounds(400, 100, 200, 100);
        buttons[2] = new JButton(answers[2]);
        buttons[2].setBounds(200, 300, 200, 100);
        buttons[3] = new JButton(answers[3]);
        buttons[3].setBounds(400, 300, 200, 100);

        change.add(nxtButton);
        change.add(buttons[0]);
        change.add(buttons[1]);
        change.add(buttons[2]);
        change.add(buttons[3]);



        scoreLabel.setBounds(700, -30, 100, 100);
        change.add(scoreLabel);


        correctAnswer = q.getCorrectAnswerIndex();


        for (int x = 0; x < buttons.length; x++) {
            buttons[x].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand());
                    if (e.getActionCommand() == correctAnswer) {
                        youScoredRight();
                        JOptionPane.showMessageDialog(null, "Correct \n+1 has been added to your score\n Please Hit next");

                    } else {
                        youScoredWrong();
                        JOptionPane.showMessageDialog(null, "Incorrect \n-1 has been subtracted from your score\n Please Hit next");
                    }

                }
            });
        }


    }//End method
}//End of class





