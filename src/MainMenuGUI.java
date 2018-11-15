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
        change.setBounds(50,50,400,400);
        getContentPane().add(change);

        playButton = new JButton("Play");
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
        FlowLayout layout = new FlowLayout();
        change = new JPanel(layout);
        change.setBounds(0,0,400,400);
        change.setBackground(Color.GRAY);

        //button1
        JButton answer1 = new JButton("Answer1");
        answer1.setBounds(100,100,100,100);
       answer1.setLocation(100,100);
       answer1.setFont(new Font("Sans-serif", Font.BOLD, 18));



       JButton answer2 = new JButton("Answer2");
       answer1.setBounds(150,150,20,20);
       JButton answer3 = new JButton("Answer3");
       JButton answer4 = new JButton("Answer4");
        contain.add(change);
        change.add(answer1);
        change.add(answer2);
       contain.add(answer3);
       contain.add(answer4);
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