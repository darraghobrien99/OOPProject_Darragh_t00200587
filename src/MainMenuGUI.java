import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Timer;

public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;
    JButton addQButton;
    JButton EnterButton;
    JButton backButton;
    JPanel change;
    Container contain;
    JLabel heading;
    JLabel question;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel enterPassword;
    JButton[] buttons;
    Timer timer = null;
    int seconds = 60;
    private static String username = "admin";
    private static String password = "master";
    ArrayList<Question> quizQuestions = QuestionFile.read();


    public MainMenuGUI() {

        //JFrame

        super("10 Question Quiz");
        getContentPane().setLayout(null);
        setSize(800,550);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //panel

        change = new JPanel(null);
        change.setBackground(Color.GRAY);
        change.setBounds(0,0,800,800);
        getContentPane().add(change);

        // Heading

        heading = new JLabel("Test Your Knowledge");
        heading.setForeground(new Color(59, 89, 182));
        heading.setFont(new Font("Tahoma", Font.BOLD, 40));
        heading.setBounds(160,0,700,200);
        change.add(heading);

        //play button

        playButton = new JButton("Play");
        playButton.setFocusPainted(false);
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(59, 89, 182));
        playButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        playButton.setBounds(100,350,100,100);
        change.add(playButton);

        //score button

        scoresButton = new JButton("Leaderboard");
        scoresButton .setFocusPainted(false);
        scoresButton .setForeground(Color.WHITE);
        scoresButton .setBackground(new Color(59, 89, 182));
        scoresButton .setFont(new Font("Tahoma", Font.BOLD, 12));
        scoresButton.setBounds(170,350,200,100);
        change.add(scoresButton);

        //add Question Button
        addQButton = new JButton("Add Question");
        addQButton.setFocusPainted(false);
        addQButton.setForeground(Color.WHITE);
        addQButton.setBackground(new Color(59, 89, 182));
        addQButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        addQButton.setBounds(350,350,200,100);
        change.add(addQButton);


        //exit Button

        exitButton = new JButton("Exit");
        exitButton.setFocusPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(59, 89, 182));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        exitButton.setBounds(550,350,100,100);
        change.add(exitButton);

        playButton.addActionListener(this);
        scoresButton.addActionListener(this);
        addQButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==playButton) {
            contain = getContentPane();
            contain.removeAll();
            startQuiz();
        }

        else if(e.getSource()==scoresButton) {
            MainMenuGUI.showLeaderboard();
        }

        else if(e.getSource() == addQButton){
            contain = getContentPane();
            contain.removeAll();
            addQuestion();
        }

        else
            MainMenuGUI.exitQuiz();

    } //end of action Performed

    public void startQuiz() {

        playerDetails();
        randomQuestion();
        change = new JPanel(null);
        change.setBounds(0,0,800,800);
        change.setBackground(Color.GRAY);


        //Added by JB - the call to the read() here will read the questions, answers and correct index from the file on disk
        //and put them into an arraylist of Question objects. Then the contents of this arraylist is just displayed to the screen
        //via a loop for test purposes





        for(Question q : quizQuestions)
            System.out.println(q);

        QuestionFile.write(quizQuestions); //JB added test code to try to write arraylist of Question objects to file

        quizQuestions = QuestionFile.read();

        for(Question q : quizQuestions)
            System.out.println(q);




        ArrayList<JLabel> questionLabels = new ArrayList<JLabel>(); //https://stackoverflow.com/questions/23369867/display-arraylist-items-as-separate-jlabels


        JLabel holder;

       for (int i = 0; i < quizQuestions.size(); i++){
           heading = new JLabel();
           heading.setText(quizQuestions.toString());
           questionLabels.add(heading); //adds holder to the ArrayList of JLabels
           questionLabels.get(i).setBounds(0,100,800,100);
           questionLabels.get(i).setForeground(Color.WHITE);
           change.add(questionLabels.get(i));
       }



/*
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if()
            }
        });


*/

/*
       QuizQuestion quizQuestion = new QuizQuestion();

       for (Question q : quizQuestion.getQuizQuestions()) {
           System.out.println(quizQuestion);
       }


       //create buttons for answers
        buttons = new JButton[4];

       //assign answer to buttons

       //generate a random number to determine where correct goes
       int index = (int)(Math.random() * 4);

       //put the correct answer to the random button
       buttons[index] = new JButton(correctAnswerIndex);

       //fill other spot with answer
      // for(int i=1; i<= .length; i++)
       buttons[(index + i) %  answers.length] = new JButton(answers[i-1]);

       */
        contain.add(change);

        // change.add(buttons[4]);

        change.invalidate();
        change.repaint();




    }


    private static void showLeaderboard(){

    }

    public void addQuestion(){


        change = new JPanel(null);
        change.setBounds(0,0,800,800);
        change.setBackground(Color.GRAY);

        contain.add(change);
        change.invalidate();
        change.repaint();

        heading = new JLabel("Enter Username & Password, Quiz Master");
        heading.setForeground(new Color(59, 89, 182));
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setBounds(150,-50,900,200);
        change.add(heading);


        EnterButton = new JButton("Enter");
        EnterButton.setFocusPainted(false);
        EnterButton.setForeground(Color.WHITE);
        EnterButton.setBackground(new Color(59, 89, 182));
        EnterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        EnterButton.setBounds(400,200,100,50);
        change.add(EnterButton);

        backButton = new JButton("Go Back");
        backButton.setFocusPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(59, 89, 182));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        backButton.setBounds(270,200,100,50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( e.getSource() == backButton){
                    dispose();  //https://stackoverflow.com/questions/30861139/how-to-go-back-to-the-previous-gui-when-a-button-is-clicked-in-java
                    new MainMenuGUI().setVisible(true);
                }
            }
        });
        change.add(backButton);



        usernameLabel = new JLabel("Enter Username:");
        usernameLabel.setBounds(250,50,100,100);
        JTextField admin = new JTextField(10);
        admin.setBounds(350,85,150,25);

        change.add(usernameLabel);
        change.add(admin);

        passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(250,100,100,100);
        JPasswordField pass = new JPasswordField(10);
        pass.setBounds(350,140,150,25);
        pass.setEchoChar('*');
        change.add(passwordLabel);
        change.add(pass);
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField input = (JPasswordField) e.getSource();
                char[] passy = input.getPassword();
                String p = new String(passy);

                if(p.equals(password)){
                    addQuizQuestion();
                }

                else
                    JOptionPane.showMessageDialog(null,"Incorrect Password");
                addQuestion();


            }//End of AP
        });//End AL




    }//End Method


    private static void exitQuiz() {

        JOptionPane.showMessageDialog(null, "Thank you for playing! Goodbye!");
        System.exit(0);
    }

        //AddQuizQuestion Method

        private void addQuizQuestion(){

            String question;

            String[] answers = new String[4];

            int correctAnswer;

            Question addQ = new Question();

            addQ.setQuestion(JOptionPane.showInputDialog("Enter Question:"));

            for(int j=0; j < answers.length;j++) {

                answers[j] = JOptionPane.showInputDialog("Enter answer:");

                addQ.setAnswers(new String[]{answers[j]});

            }

            addQ.setCorrectAnswerIndex(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Answer Index:")));
            quizQuestions.add(addQ);


        }//End Method


    private void randomQuestion() {

        Collections.shuffle(quizQuestions);

    }//End Method

    private void playerDetails() {

        Player player = new Player();
        player.setName(JOptionPane.showInputDialog("Please enter your name:"));
        player.setUsername(JOptionPane.showInputDialog("Please enter your username"));
        player.setAge(Integer.parseInt(JOptionPane.showInputDialog("Please enter your age:")));
        player.setGender(JOptionPane.showInputDialog("Please enter your gender:"));
        JOptionPane.showMessageDialog(null,"Lets Play " + player.getUsername());

    }

}



