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

       // number = Integer.parseInt(JOptionPane.showInputDialog("How many questions would you like to add?"));

        ArrayList<Question> QuizQs =new ArrayList<>();
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
        //Creating Questions
        question1 = new Question("What is the most spoken language in the world?", "Modern Chinese", "Spanish", "English", "French");

        QuizQs.add(question1);

        question1 = new Question("Where would you find the Sea of Tranquility?", "The Moon", "Iceland", "Germany", "Mars");

        QuizQs.add(question1);

        question1 = new Question("What is cynophobia?", "Fear of Dogs", "Fear of Open Spaces", "Fear of the unknown", "Fear of Holes");

        QuizQs.add(question1);

        question1 = new Question("What do you call a small river that joins a large river? ", "Tributary", "Source", "Floodplain", "River mouth");

        QuizQs.add(question1);

        question1 = new Question("How many matches did Muhammmad Ali lose in his career?","1", "0", "2", "3");

        QuizQs.add(question1);

        question1 = new Question("In which country is the Interlagos F1-circuit ?","Brazil","Italy","Greece","Spain");
         QuizQs.add(question1);

       // System.out.println(QuizQs.get(0));






    }


    }
