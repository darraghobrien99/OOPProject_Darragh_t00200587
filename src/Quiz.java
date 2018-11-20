import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    static public List<Question> quizQuestions;
    //public List<Quiz> allQuizzes;

    public static void main(String args[]) {

        MainMenuGUI mainGUI = new MainMenuGUI();
        mainGUI.setVisible(true);
        mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        QuizQuestion quizQuestion = new QuizQuestion();


    }

    public static ArrayList<Question> getQuizQuestions() {

        return (ArrayList<Question>) quizQuestions;
    }

//AddQuizQuestion Method

    public static void addQuizQuestion(){

        String question;
        String[] answers = new String[4];
        int CorrectAnswer;

            Question addQ = new Question();

            addQ.setQuestion(JOptionPane.showInputDialog("Enter Question:"));

            for(int j=0; j < answers.length;j++) {

            answers[j] = JOptionPane.showInputDialog("Enter answer:");
            addQ.setAnswers(new String[]{answers[j]});
            }

            addQ.setCorrectAnswerIndex(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Answer Index:")));

        quizQuestions.add(addQ);
    }//End Method
}//End Class


