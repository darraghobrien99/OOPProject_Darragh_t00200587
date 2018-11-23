public class Person {

    private String name;
    private int age;


    //mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //accessor methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    //constructors
    public Person(String name,int age) {
        //setting attributes values directly)
        this.name = name;
        this.age = age;
    }

    public Person(){

        setName("unknown");
        setAge(0);
    }


    public String toString() {
        return "Name: " +getName() +
                "\nAge: " + getAge();

    }





}