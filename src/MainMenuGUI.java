import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;
    JButton addQButton;
    JButton EnterButton;
    JPanel change;
    Container contain;
    JLabel heading;
    JLabel question;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JButton[] buttons;
    Timer timer = null;
    int seconds = 60;
    private static String username = "admin";
    private static String password = "masterofthequiz";


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
        change = new JPanel(null);
        change.setBounds(0,0,800,800);
        change.setBackground(Color.GRAY);

        buttons = new JButton[4];


        for(int i=0; i< buttons.length;i++){

            buttons[i] = new JButton(" ");
            buttons[i].setBounds(0,0,200,100);
            buttons[i].setFocusPainted(false);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(new Color(59, 89, 182));
            buttons[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            buttons[i].setBounds(470,350,100,100);

            change.add(buttons[i]);
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



       //adding buttons to JPanel

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

        EnterButton = new JButton("Enter");
        EnterButton.setFocusPainted(false);
        EnterButton.setForeground(Color.WHITE);
        EnterButton.setBackground(new Color(59, 89, 182));
        EnterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        EnterButton.setBounds(330,200,100,50);
        change.add(EnterButton);

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
                   Quiz.addQuizQuestion();
               }

               else
                   JOptionPane.showMessageDialog(null,"Incorrect Password");
                    addQuestion();


           }//End of AP
       });//End AL




    }//End Method


    private static void exitQuiz(){

        JOptionPane.showMessageDialog(null,"Thank you for playing! Goodbye!");
        System.exit(0);


    }

}