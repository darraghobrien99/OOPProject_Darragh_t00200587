import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {

    private List<Question> quizQuestions;

    public QuizQuestion(){

        this.quizQuestions = addQuestions();
    }


    public List<Question> getQuizQuestions(){
        return quizQuestions;
    }

    private List<Question> addQuestions(){
        List<Question> quizQuestion = new ArrayList<>();

        //Adding Quiz Questions

        String question = "What is the most spoken language in the world?";
        String[] answers1 = {"Modern Chinese", "Spanish", "English", "French"};
        Question quizQ = new Question(question,0,answers1);
        this.quizQuestions.add(quizQ);

        question = "Where would you find the Sea of Tranquility?";
        String[] answers2 = {"Mars", "Kenya", "The Moon", "Brazil"};
        quizQ = new Question(question,2,answers2);
        this.quizQuestions.add(quizQ);

        question = "What is cynophobia?";
        String[] answers3 = {"Fear of Holes", "Fear of birds", "Fear of Dogs", "Fear of people"};
        quizQ = new Question(question,2,answers3);
        this.quizQuestions.add(quizQ);

        question = "What do you call a small river that joins a large river? ";
        String[] answers4 = {"Tributary", "Source", "Floodplain", "River Mouth"};
        quizQ = new Question(question,0,answers4);
        this.quizQuestions.add(quizQ);

        question = "How many matches did Muhammmad Ali lose in his career?";
        String[] answers5 = {"0", "1", "2", "3"};
        quizQ = new Question(question,1,answers5);
        this.quizQuestions.add(quizQ);

        question = "In which country is the Interlagos F1-circuit ?";
        String[] answers6 = {"Italy", "Argentina", "Spain", "Brazil"};
        quizQ = new Question(question,3,answers6);
        this.quizQuestions.add(quizQ);

        question = "In which country is the Interlagos F1-circuit ?";
        String[] answers7 = {"Italy", "Argentina", "Spain", "Brazil"};
        quizQ = new Question(question,3,answers7);
        this.quizQuestions.add(quizQ);

        question = "What is Graphology?";
        String[] answers8 = {"Study of Graphs", "Study of Maps", "Study of Handwriting", "Study of Earth"};
        quizQ = new Question(question,2,answers8);
        this.quizQuestions.add(quizQ);

        question = "What is the world's biggest spider?";
        String[] answers9 = {"Giant Huntsman Spider", "Goliath Bird eater", "Colombian Giant Tarantula", "Brazilian Salmon Pink Bird eater"};
        quizQ = new Question(question,1,answers9);
        this.quizQuestions.add(quizQ);

        question = "What did A.E. Frick invent in 1887, which are now worn by thousands if not millions of people?";
        String[] answers10 = {"Baseball Caps", "Glasses", "Contact Lenses", "Wigs"};
        quizQ = new Question(question,2,answers10);
        this.quizQuestions.add(quizQ);





         //System.out.println(quizQuestion.get(0));




return quizQuestion;



    }
}
