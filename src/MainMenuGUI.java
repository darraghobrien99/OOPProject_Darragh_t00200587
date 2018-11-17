import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;
    JPanel change;
    Container contain;
    JLabel heading;
    JLabel question;
    JButton[] buttons;


    public MainMenuGUI() {

        //JFrame

        super("10 Question Quiz");
        getContentPane().setLayout(null);
        setSize(400,400);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //panel

        change = new JPanel(null);
        FlowLayout flow = new FlowLayout();
        getContentPane().setLayout(flow);
        change.setBackground(Color.GRAY);
        getContentPane().add(change);

        // Heading

        heading = new JLabel("Test Your Knowledge");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(heading);

        //play button

        playButton = new JButton("Play");
        playButton.setFocusPainted(false);
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(59, 89, 182));
        playButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(playButton);

        //score button

        scoresButton = new JButton("Leaderboard");
        scoresButton .setFocusPainted(false);
        scoresButton .setForeground(Color.WHITE);
        scoresButton .setBackground(new Color(59, 89, 182));
        scoresButton .setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(scoresButton);

        //exit Button

        exitButton = new JButton("Exit");
        exitButton.setFocusPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(59, 89, 182));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(exitButton);

        playButton.addActionListener(this);
        scoresButton.addActionListener(this);
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

        else if(e.getSource()==scoresButton)
            MainMenuGUI.showLeaderboard();
        else
            MainMenuGUI.exitQuiz();

    }

   public void startQuiz() {
        GridLayout grid = new GridLayout();
        change = new JPanel(grid);
        change.setBounds(0,0,400,400);
        change.setBackground(Color.GRAY);

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
       buttons[(index + i) %  answers.length] = new JButton(answers[i-1])



       //adding buttons to JPanel
       contain.add(change);
       change.add(buttons[4]);

       invalidate();
       repaint();




       }


    private static void showLeaderboard(){

    }

    private static void exitQuiz(){

        JOptionPane.showMessageDialog(null,"Thank you for playing! Goodbye!");
        System.exit(0);


    }

}