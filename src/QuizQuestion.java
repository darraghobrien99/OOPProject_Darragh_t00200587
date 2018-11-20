
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
            quizQuestions.add(test);

            while(sCurrentLine != null){


                    //Find Question
                    if (sCurrentLine.contains("?")) {
                        question = sCurrentLine;
                        test.setQuestion(question);

                    }


                    //Find Answers
                    else if (sCurrentLine.contains(".")) {
                        options[0] = sCurrentLine;
                        options[1] = sCurrentLine;
                        options[2] = sCurrentLine;
                        options[3] = sCurrentLine;
                        test.setAnswers(options);
                    }

                    //Find correct Answer index

                    else
                        correctAnswerIndex = Integer.valueOf(sCurrentLine);
                    test.setCorrectAnswerIndex(correctAnswerIndex);


                    System.out.println(sCurrentLine);
                    sCurrentLine = br.readLine();


            }//End of while


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

            }  //End of Catch


        } //End of finally
    }//End of QuizQuestion

    public List<Question> getQuizQuestions() {
        return quizQuestions;
    }//End get

}//End class





/*
    public void addQuestions(){

       quizQuestions = new ArrayList<Question>();


       }
}
*/



