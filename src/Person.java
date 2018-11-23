public class Person {

    private String name;
    private int age;
    private String gender;

    //mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //accessor methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    //constructors
    public Person(String name,int age,String gender){
        //setting attributes values directly)
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public Person(){

        setName("unknown");
        setAge(0);
        setGender("undetermined");
    }


    public String toString() {
        return "Name: " +getName() +
                "\nAge: " + getAge() +
                "\nGender: " + getGender();

    }





}