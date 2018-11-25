import java.util.Arrays;

/**
 * The Question  Class models a Quiz Question where each question has a
 * question, 4 answers and the correct Answer
 *
 * @author Darragh O'Brien
 */

public class Question {



    private String question;

    private String[] answers;

    private int correctAnswerIndex;


    /**
     *
     * @param question sets the question
     */

    public void setQuestion(String question) {

        this.question = question;

    }


    /**
     *
     * @param answers sets the 4 answers for the question
     */
    public void setAnswers(String[] answers) {

        this.answers = answers;

    }


    /**
     *
     * @param correctAnswerIndex sets the Index of the correct answer
     */
    public void setCorrectAnswerIndex(int correctAnswerIndex) {

        this.correctAnswerIndex = correctAnswerIndex;

    }

    /**
     *
     * @return the question
     */

    public String getQuestion() {

        return question;

    }

    /**
     *
     * @return the answers for the question
     */

    public String[] getAnswers() {

        return answers;

    }

    /**
     *
     * @return the correct answer index in the answer array
     */

    public String getCorrectAnswerIndex() {

        return answers[correctAnswerIndex];

    }

    public Question(String question,String[] answers, int correctAnswerIndex){



        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;

    }



    public Question(){

        this.question = "unknown";

        this.answers = null;

        this.correctAnswerIndex = 0;

    }



    public String toString(){

            return "Question: " + getQuestion() + "\nAnswers: " + Arrays.toString(getAnswers()) +

                    "\nCorrect Answer Index: " + getCorrectAnswerIndex();
        }

    }







