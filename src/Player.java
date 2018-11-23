public class Player extends Person {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Player(String name, int age,String username){

        super(name,age);
        this.username = username;
    }

    public Player(){
        setUsername("unknown");
    }
}
