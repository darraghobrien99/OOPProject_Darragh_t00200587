public class Player extends Person {

    private String username;

    //Setters

    public void setUsername(String username) {
        this.username = username;
    }

    //Getters

    public String getUsername() {
        return username;
    }

    //Constructors

    public Player(String name, int age,String username){

        super(name,age);
        this.username = username;
    }

    public Player(){
        setUsername("unknown");
    }
}
