import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;
    JPanel change;
    Container contain;


    public MainMenuGUI() {

        super("10 Question Quiz");
        getContentPane().setLayout(null);
        setSize(400,400);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        change = new JPanel(null);
        FlowLayout flow = new FlowLayout();
        getContentPane().setLayout(flow);
        change.setBackground(Color.GRAY);
        getContentPane().add(change);

        playButton = new JButton("Play");
        playButton.setFocusPainted(false);
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(59, 89, 182));
        playButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(playButton);

        scoresButton = new JButton("Leaderboard");
        getContentPane().add(scoresButton);

        exitButton = new JButton("Exit");
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

        //button1
        JButton answer1 = new JButton("Answer1");
       answer1.setBounds(100,100,20,20);
       answer1.setFocusPainted(false);
       answer1.setForeground(Color.WHITE);
       answer1.setBackground(new Color(59, 89, 182));
       answer1.setFont(new Font("Tahoma", Font.BOLD, 12));
       add(answer1, BorderLayout.SOUTH);



        //button2
       JButton answer2 = new JButton("Answer2");
       answer2.setBounds(100,100,20,20);
       answer2.setFocusPainted(false);
       answer2.setForeground(Color.WHITE);
       answer2.setBackground(new Color(59, 89, 182));
       add(answer2, BorderLayout.SOUTH);
       answer2.setFont(new Font("Tahoma", Font.BOLD, 12));
       add(answer2, BorderLayout.SOUTH);


       //button3
       JButton answer3 = new JButton("Answer3");
       answer3.setBounds(100,100,20,20);
       answer3.setFocusPainted(false);
       answer3.setForeground(Color.WHITE);
       answer3.setBackground(new Color(59, 89, 182));
       add(answer3, BorderLayout.SOUTH);
       answer3.setFont(new Font("Tahoma", Font.BOLD, 12));
       add(answer3, BorderLayout.SOUTH);



       //button4
       JButton answer4 = new JButton("Answer4");
       answer4.setBounds(100,100,20,20);
       answer4.setFocusPainted(false);
       answer4.setForeground(Color.WHITE);
       answer4.setBackground(new Color(59, 89, 182));
       add(answer1, BorderLayout.SOUTH);
       answer4.setFont(new Font("Tahoma", Font.BOLD, 12));
       add(answer4, BorderLayout.SOUTH);
       answer4.setFont(new Font("Sans-serif", Font.BOLD, 15));

       //adding buttons to JPanel
       contain.add(change);
       change.add(answer1);
       change.add(answer2);
       change.add(answer3);
       change.add(answer4);
       invalidate();
       repaint();

       answer1.addActionListener(this);
       answer2.addActionListener(this);
       answer3.addActionListener(this);
       answer4.addActionListener(this);


       }


    private static void showLeaderboard(){

    }

    private static void exitQuiz(){

        JOptionPane.showMessageDialog(null,"Thank you for playing! Goodbye!");
        System.exit(0);


    }

}