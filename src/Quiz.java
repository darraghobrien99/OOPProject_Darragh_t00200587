import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz {

     public static ArrayList<Question> quizQuestions = new ArrayList<>();
    //public List<Quiz> allQuizzes;

    public static void main(String args[]) {

        MainMenuGUI mainGUI = new MainMenuGUI();
        mainGUI.setVisible(true);
        mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        QuizQuestion question1 = new QuizQuestion();




        for(int i =0; i < quizQuestions.size(); i++){
            System.out.println((quizQuestions.get(i)).toString());
        }

    }

    public static ArrayList<Question> getQuizQuestions() {

        return quizQuestions;
    }

//AddQuizQuestion Method

    public static void addQuizQuestion(){



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

    public void randomQuestion() {
        Collections.shuffle(quizQuestions);
    }//End Method

}//End Class


