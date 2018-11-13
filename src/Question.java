import java.util.ArrayList;

public class Question {

    private String question;
    ArrayList<String> answerList= new ArrayList<String>();


    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }


    public Question(String question, ArrayList<String> answerList){

        this.question = question;
        this.answerList = answerList;

    }

    public Question() {

        this("unknown");
    }

}
