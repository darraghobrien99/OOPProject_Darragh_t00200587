
import java.io.*;

import java.nio.file.Paths;

import java.nio.file.StandardOpenOption;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;


public class QuestionFile {



    //Modified by JB to make the class more readable and functional

    public static ArrayList<Question> read() {

        ArrayList<Question> quizQuestions = new ArrayList<>();
        final String FILENAME = "quiz.txt";


        Scanner sc = null;

        File fr = null;

        String question="";

        String[] options;

        int correctAnswerIndex = 0;

        int count = 0; //added by JB to keep account of lines read from the text file "quiz.txt"


        try { //http://javatutorialhq.com/java/util/scanner-class-tutorial/hasnextline-method-example/

            fr = new File(FILENAME);
            sc = new Scanner(fr);

            //quizQuestions = QuizApp.getQuizQuestions();    //need to access array list of questions from some QuizApp object

            Question test;
            //quizQuestions.add(test);

            test = new Question();
            options = new String[4];
            //reading file
            while(sc.hasNextLine()){



                String sCurrentLine = sc.nextLine();

                //Find Question

                /*if (sCurrentLine.contains("?")) {

                    question = sCurrentLine;

                    test.setQuestion(question);

                   // System.out.println(test.getQuestion());

                }*/
                //System.out.println(sCurrentLine);

                /*If-else structure added by JB to ensure Question objects can be populated
                 *successfully with their question, 4 possible answers and correct answer index*/

                if(count%6==0)
                {
                    test = new Question();
                    options = new String[4];
                    question = sCurrentLine;
                    test.setQuestion(question);
                }
                else if(count%6==5)
                {
                    correctAnswerIndex = Integer.parseInt(sCurrentLine);
                    test.setCorrectAnswerIndex(correctAnswerIndex);
                    test.setAnswers(options);
                    quizQuestions.add(test);
                }
                else
                {
                    options[count%6-1] = sCurrentLine;
                }

                count++;


            }


            //Find Answers

            //else if (sCurrentLine.contains(".")) {

            //    for(int i=0; i<options.length;i++){

            //options[i] = sCurrentLine;
            // }

            // test.setAnswers(options);

            //    System.out.println(test.getAnswers());

        }
        //Find correct Answer index
        // else
        // correctAnswerIndex = Integer.parseInt(sCurrentLine);

        //System.out.println(test.getCorrectAnswerIndex());

        //System.out.println(sCurrentLine);


        //}

        //writeToFile();
        //}

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


        //test code added by JB to ensure that Question objects have been created successfully
        //and that the array list of questions is now poulated with these Question objects
       // for(Question q : quizQuestions)
       // System.out.println(q);

        return quizQuestions;

    }//End of QuizQuestion


    //Modified by JB to make the class more readable and functional
    //Also needed to make changes to send data to the file line by line
    //so that it matches exactly the way in which it will be retrieved

    public static void write(ArrayList<Question> quizQuestions) {

        try{

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("quiz.txt"), "utf-8"));


            for(Question q : quizQuestions)
            {
                writer.write(q.getQuestion());
                writer.newLine();

                for(int i=0;i<4;i++)
                {
                    writer.write(q.getAnswers()[i]);
                    writer.newLine();
                }
                writer.write(String.valueOf(q.getCorrectAnswerIndex()));
                writer.newLine();
            }

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//End Method


}//End class


