import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;


    public MainMenuGUI() {

        super("10 Question Quiz");
        FlowLayout flowLayout = new FlowLayout();

        setLayout(flowLayout);

        playButton = new JButton("Play");
        add(playButton);

        scoresButton = new JButton("Leaderboard");
        add(scoresButton);

        exitButton = new JButton("Exit");
        add(exitButton);

        playButton.addActionListener(this);
        scoresButton.addActionListener(this);
        exitButton.addActionListener(this);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==playButton)
            MainMenuGUI.startQuiz();

        else if(e.getSource()==scoresButton)
            MainMenuGUI.showLeaderboard();
        else
            MainMenuGUI.exitQuiz();

    }

    private static void startQuiz() {
        JFrame frame = new JFrame("Play Quiz");
        frame.setSize(500,500);
        JPanel contentPane =  new JPanel(null);
        contentPane.setBounds(100,100,100,100);
        contentPane.setBackground(Color.GRAY);
        frame.add(contentPane);



        frame.setVisible(true);

    }

    private static void showLeaderboard(){

    }

    private static void exitQuiz(){

        JOptionPane.showMessageDialog(null,"Thank you for playing! Goodbye!");
        System.exit(0);


    }

}