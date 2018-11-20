import javax.swing.*;
import java.util.ArrayList;

public class Quiz {
    public static void main(String args[]) {

        MainMenuGUI mainGUI = new MainMenuGUI();
        mainGUI.setVisible(true);
        mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        QuizQuestion quizQuestion = new QuizQuestion();


    }

    public static void addQuizQuestion(){

        String question;
        String[] answers = new String[4];
        int CorrectAnswer;
        int number;
        String numAsString;

        numAsString = JOptionPane.showInputDialog("How many questions would you like to store:");

        number = Integer.parseInt(numAsString);

        Question[] newQuestions = new Question[number];

        for(int i=0; i<newQuestions.length; i++)
        {

            Question addQ = new Question();

            addQ.setQuestion(JOptionPane.showInputDialog("Enter Question:"));

            for(int j=0; j < answers.length;i++) {

            answers[j] = JOptionPane.showInputDialog("Enter answer:");
            j++;
            addQ.setAnswers(new String[]{answers[j]});
            }

            addQ.setCorrectAnswerIndex(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Answer Index:")));

            newQuestions[i] = addQ;



        }


    }
}


