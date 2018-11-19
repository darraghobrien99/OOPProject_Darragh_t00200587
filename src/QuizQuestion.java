
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
                parseQuestions(sCurrentLine);
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

            } //End of finally


        }
    }//End of class

    public void parseQuestions(String line) {

        String question = "";
        String[] options;
        int correctAnswerIndex;



        for (int i = 0; i < 6; i++) {

            if (line.contains("?")) {
                question = line;
            }
            else if (line.contains(".")) {

                    options = new String[4];
                    options[0] = line;
                    options[1] = line;
                    options[2] = line;
                    options[3] = line;

            }
            else {
                correctAnswerIndex = Integer.valueOf(line);
            }

            quizQuestions.add(question,options,correctAnswerIndex);

        }//End of For loop

    }//End of method



    public List<Question> getQuizQuestions(){
        return quizQuestions;
    }

}//End Class






/*
    public void addQuestions(){

       quizQuestions = new ArrayList<Question>();


       }
}
*/



