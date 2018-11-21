
import java.io.*;

import java.nio.file.Paths;

import java.nio.file.StandardOpenOption;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;
public class QuizQuestion {

    public ArrayList<Question> quizQuestions = new ArrayList<>();
    private final String FILENAME = "quiz.txt";

    public QuizQuestion() {


        Scanner sc = null;

        File fr = null;

        String question="";

        String[] options = new String[4];

        int correctAnswerIndex = 0;


        try { //http://javatutorialhq.com/java/util/scanner-class-tutorial/hasnextline-method-example/

            fr = new File(FILENAME);
            sc = new Scanner(fr);

            quizQuestions = Quiz.getQuizQuestions();    //need to access arraylist of questions from some Quiz object

            Question test = new Question(question,options,correctAnswerIndex);
            quizQuestions.add(test);


            //reading file
            while(sc.hasNextLine()){

                String sCurrentLine = sc.nextLine();

                //Find Question

                if (sCurrentLine.contains("?")) {

                    question = sCurrentLine;

                    test.setQuestion(question);

                    //System.out.println(test.getQuestion());

                }


                //Find Answers

                else if (sCurrentLine.contains(".")) {

                    for(int i=0; i<options.length;i++){

                        options[i] = sCurrentLine;
                    }

                    test.setAnswers(options);

                   // System.out.println(test.getAnswers());

                }
                //Find correct Answer index
                else if (Character.isDigit(sCurrentLine.charAt(0)))


                    correctAnswerIndex = Integer.parseInt(sCurrentLine);

                   // System.out.println(test.getCorrectAnswerIndex());

                   //System.out.println(sCurrentLine);


                }

            //writeToFile();
            }

            catch (IOException ex) {

            ex.printStackTrace();



        } //End of catch
         finally {

            try {
                if (sc != null)

                    sc.close();

            } catch (Exception ex) {
                System.out.println("Error" + ex);

            }  //End of Catch
        } //End of finally

    }//End of QuizQuestion



    public void writeToFile() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(

                new FileOutputStream("quiz.txt"), "utf-8"))) {

            writer.write(String.valueOf(quizQuestions));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//End Method


}//End class







