public class Question {

    private String question;
    private String[] answers;
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
        return answers;
    }

    public String getCorrectAnswerIndex() {
        return answers[correctAnswerIndex];
    }

    public Question(String question, int correctAnswerIndex, String[] answers){

        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;

    }

    public String toString(){
        return "Question: " + getQuestion() + "\nAnswers: " + getAnswers() +
                "\nCorrect Answer Index: " + getCorrectAnswerIndex();
    }



}
