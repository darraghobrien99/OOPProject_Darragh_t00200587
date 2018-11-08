import javax.swing.*;

public class Quiz {
    public static void main(String args[]) {

        Question[] questions = new Question[10];
        String[] answers = {"B", "C","C","A","C","B","A","A","C","A"};
        int correct=0;
        int wrong=0;
        String userAnswer = "";

        for(int i=0;i<questions.length;i++)
        {
            Question Question1 = new Question();
            Question Question2 = new Question();

            Question1.setQuestions(JOptionPane.showInputDialog("What is the capital of USA?\n" +
                    "\nA. Washington DC " +
                    "\nB. Chicago " +
                    "\nC. New York"));

            Question2.setQuestions(JOptionPane.showInputDialog("What Color is Cobalt?\n" +
                    "\nA.Red" +
                    "\nB.Silver" +
                    "\nC.Blue"));

            questions[i] = Question1;
            questions[i] = Question2;

            break;
        }

        for(int i=0; i<answers.length;i++)
        {
            if (answers[i].equals(userAnswer)) {

                correct++;
            }

            else
                wrong++;
        }

        JOptionPane.showMessageDialog(null,"You got " + correct + " correct");
    }


}
