
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizQuestion {

    public List<Question> quizQuestions;

    private final String FILENAME = "quiz.txt";


    public QuizQuestion() {


        BufferedReader br = null;
        FileReader fr = null;
        String question="";
        String[] options = new String[4];
        int correctAnswerIndex = 0;




        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine = br.readLine();
            Question test = new Question(question,options,correctAnswerIndex);

            while(sCurrentLine != null){

                //Find Question
                if (sCurrentLine.contains("?")) {
                    question = sCurrentLine;
                }

                else if(sCurrentLine.contains("."))
                {
                     options[4] = sCurrentLine;

                }

                else
                    correctAnswerIndex = Integer.valueOf(sCurrentLine);


                System.out.println(sCurrentLine);
                sCurrentLine = br.readLine();


            }


        } catch (IOException e) {

          System.out.println("Error" + e);

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

              System.out.println("Error" + ex);

            } //End of finally


        }
    }//End of class

    public List<Question> getQuizQuestions() {
        return quizQuestions;
    }}





/*
    public void addQuestions(){

       quizQuestions = new ArrayList<Question>();


       }
}
*/



