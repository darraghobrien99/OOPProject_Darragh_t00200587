public class Player extends Person {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Player(String name, int age, String gender, String username){

        super(name,age,gender);
        this.username = username;
    }

    public Player(){
        setUsername("unknown");
    }
}
