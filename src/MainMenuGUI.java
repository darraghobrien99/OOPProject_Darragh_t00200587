import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame implements ActionListener {

    JButton playButton;
    JButton scoresButton;
    JButton exitButton;

    public static void main(String[] args) {

        MainMenuGUI mainMenu = new MainMenuGUI();
    }

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

        ImageIcon image = new ImageIcon("C:\\Users\\User\\images\\quizImage.png"); //https://stackoverflow.com/questions/20098124/displaying-an-image-in-a-jframe
        JLabel imageLabel = new JLabel(image);
        add(imageLabel);
        //imageLabel.setBounds(10, 10, 150, 150);
        imageLabel.setVisible(true);


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
        frame.setSize(800,800);
        JPanel questionPanel =  new JPanel();
        questionPanel.setBounds(100,100,100,100);
        questionPanel.setBackground(Color.GRAY);
        frame.add(questionPanel);

        frame.setVisible(true);




        //questionLabel.setText();



    }

    private static void showLeaderboard(){

    }

    private static void exitQuiz(){

        JOptionPane.showMessageDialog(null,"Thank you for playing! Goodbye!");
        System.exit(0);


    }

}