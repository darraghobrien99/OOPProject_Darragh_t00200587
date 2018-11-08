import javax.swing.*;

public class Quiz {
    public static void main(String args[]) {

        Question[] questions = new Question[10];
        String answers = {}

        for(int i=0;i<questions.length;i++)
        {
            Question Question1 = new Question();

            Question1.setQuestions(JOptionPane.showInputDialog("What is the capital of USA:\n" +
                    "\nA. Washington DC " +
                    "\nB. Chicago " +
                    "\nC. New York"));

            questions[i] = Question1;
        }
    }
}
