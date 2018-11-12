import javax.swing.*;
import java.util.ArrayList;

public class Quiz {
    public static void main(String args[]) {

        String question;
        String correctAnswer;
        String wrongAnswer1;
        String wrongAnswer2;
        String wrongAnswer3;
        int number;

        number = Integer.parseInt(JOptionPane.showInputDialog("How many questions would you like to add?"));

        ArrayList<Question> QuizQs =new ArrayList<>();
        Question[] questions =new Question[number];
        Question question1;

        /**
        for(int i=0; i<number;i++){

            question = JOptionPane.showInputDialog("Enter Question:");
            correctAnswer = JOptionPane.showInputDialog("Enter correct Answer:");
            wrongAnswer1 = JOptionPane.showInputDialog("Enter wrong answer 1:");
            wrongAnswer2 = JOptionPane.showInputDialog("Enter wrong answer 2:");
            wrongAnswer3 = JOptionPane.showInputDialog("Enter wrong answer 3:");

            question1 = new Question(question, correctAnswer, wrongAnswer1, wrongAnswer2,wrongAnswer3);

           questions[i] = question1;
        }

*/

        question1 = new Question("What is the most spoken language in the world?", "Modern Chinese", "Spanish", "English", "French");

        QuizQs.add(question1);
        questions[0] = question1;

        question1 = new Question("Where would you find the Sea of Tranquility?", "The Moon", "Iceland", "Germany", "Mars");

        QuizQs.add(question1);
        questions[1] = question1;





    }


    }
