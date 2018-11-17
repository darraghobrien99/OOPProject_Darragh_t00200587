import sun.misc.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizQuestion {

    public List<Question> quizQuestions;

   public QuizQuestion(){

       try {
           FileReader file = new FileReader("quiz.txt");
           BufferedReader reader = new BufferedReader(file);
           Scanner scanner = new Scanner(reader);

           String line;
           String question = "";
           String[] answers = null;
           int correctAnswerIndex = 0;
           int counter = 0;

           do {
               do {
                   line = scanner.nextLine();

                   if(scanner.hasNextLine()){
                       question = scanner.nextLine();
                   }

                   if (line.contains("?")) {
                       question = line;
                   } else if (line.contains(".")) {
                       answers = new String[3];
                       answers[counter++] = line;
                   } else if (Character.isDigit(line.indexOf(0))) {
                       correctAnswerIndex = Integer.valueOf(line);
                   }
               } while (counter == 0);

               quizQuestions.add(new Question(question, correctAnswerIndex, answers));
               counter = 0;
           } while (scanner.hasNext());

           file.close();
           reader.close();
           scanner.close();

       } catch (IOException e){
           e.printStackTrace();


       //addQuestions();
   }
       }


      public List<Question> getQuizQuestions(){
       return quizQuestions;
    }


    public void addQuestions(){

       quizQuestions = new ArrayList<Question>();


       }
}




