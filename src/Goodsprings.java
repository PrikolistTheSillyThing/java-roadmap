abstract class Resident {
    protected String name;
    protected int age;
    protected String gender;
    protected String profession;
    protected String weapon;

    protected Resident(String name, int age, String gender, String profession, String weapon){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.weapon = weapon;
    }

    public abstract void relax();
    public abstract void work();
}

class EasyPete extends Resident {
    public EasyPete(String name, int age, String gender, String profession, String weapon) {
        super("Easy Pete",68, "Male", "Former prospector", "Dynamite");
    }
    @Override
    public void relax(){
        System.out.println(name + " is taking it easy outside the Prospector Saloon.");
    }
    @Override
    public void work(){
        System.out.println(name + " is helping with Brahmins and Bighorners.");
    }
}

public class Goodsprings {
    public static void main(String[] args) {

    }
}