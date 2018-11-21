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

    public String[] getAnswers() {

        for(int i=0; i<answers.length;i++) {

            return new String[]{answers[i]};
        }

        return answers;

    }



    public int getCorrectAnswerIndex() {

        return correctAnswerIndex;

    }



    public Question(String question,String[] answers, int correctAnswerIndex){



        this.question = question;

        for (int i=0; i < answers.length; i++) {
            this.answers = answers;

        }



        this.correctAnswerIndex = correctAnswerIndex;



    }



    public Question(){

        this.question = "unknown";

        this.answers = null;

        this.correctAnswerIndex = 0;

    }




    public String toString(){
//print out Array of correctAnswers
        return "Question: " + getQuestion() + "\nAnswers: " + getAnswers() +

                "\nCorrect Answer Index: " + getCorrectAnswerIndex();

    }







}