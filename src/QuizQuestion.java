

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
            test.toString();
           // quizQuestions.add(test);





            //reading file

            while(sc.hasNextLine()){

                String sCurrentLine = sc.nextLine();

                //Find Question

                if (sCurrentLine.contains("?")) {

                    question = sCurrentLine;

                    test.setQuestion(question);

                  //  System.out.println(test.getQuestion());

                }


                //Find Answers

                else if (sCurrentLine.contains(".")) {

                    options[0] = sCurrentLine;

                    options[1] = sCurrentLine;

                    options[2] = sCurrentLine;

                    options[3] = sCurrentLine;

                    test.setAnswers(options);

                  for(int i=0;i<options.length;i++){
                  }

                }
                //Find correct Answer index
                else

                    correctAnswerIndex = Integer.valueOf(sCurrentLine);

                    test.setCorrectAnswerIndex(correctAnswerIndex);


                  // System.out.println(sCurrentLine);

                    //sCurrentLine = br.readLine();
                }

            writeToFile();

            }

            catch (IOException ex) {

            ex.printStackTrace();

            //End of catch

        }  finally {

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

    }

}//End class







