import java.util.Arrays;

public class Question {



    private String question;

    private String[] answers = new String[4];

    private int correctAnswerIndex;





    public void setQuestion(String question) {

        this.question = question;

    }



    public void setAnswers(String[] answers) {

        this.answers = answers;

    }



    public void setCorrectAnswerIndex(int correctAnswerIndex) {

        this.correctAnswerIndex = correctAnswerIndex;

    }

    public String getQuestion() {

        return question;

    }

    public String getAnswers() {

        return Arrays.toString(answers); //https://stackoverflow.com/questions/8410294/why-does-printlnarray-have-strange-output-ljava-lang-string3e25a5

    }



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

            return "Question: " + getQuestion() + "\nAnswers: " + getAnswers() +

                    "\nCorrect Answer Index: " + getCorrectAnswerIndex();
        }

    }







