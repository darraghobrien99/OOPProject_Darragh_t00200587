
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

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    public void parseQuestions(String line) {

        String question = "";
        String[] answers = null;
        int correctAnswerIndex = 0;



        for (int i = 0; i < 6; i++) {
            if (line.contains("?")) {
                question = line;
            } else if (line.contains(".")) {
                answers = new String[4];
                answers[i] = line;
            } /*else if (Character.isDigit(line.indexOf(0))) {
                    correctAnswerIndex = Integer.valueOf(line);
                }*/ else {
                correctAnswerIndex = Integer.valueOf(line);
            }
        }
    }






        //file.close();
        //reader.close();




        }//addQuestions();





//End Class



    /*


      public List<Question> getQuizQuestions(){
       return quizQuestions;
    }


    public void addQuestions(){

       quizQuestions = new ArrayList<Question>();


       }
}




*/