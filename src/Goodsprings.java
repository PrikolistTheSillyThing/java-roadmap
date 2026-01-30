import java.util.Random;

abstract class NPC {
    private final String name;
    private final float maxHp;
    private final float currentHp;
    private final String weapon;
    private final String affiliation;

    protected NPC(String name, int maxHp, String weapon, String affiliation){
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.weapon = weapon;
        this.affiliation = affiliation;
        System.out.println(name + " arrives to town.");
        if (affiliation.equalsIgnoreCase("Goodsprings")) {
            System.out.println("That is a well-known resident of Goodsprings.");
        } else System.out.println("That is no local...");
    }

    public abstract void idle();
    public abstract void attack(NPC npc);
    public abstract void takeDamage();

    public String getName() {
        return name;
    }

    public float getCurrentHp() {
        return currentHp;
    }
}

class EasyPete extends NPC {
    public EasyPete() {
        super("Easy Pete", 135, "dynamite", "Goodsprings");
    }
    @Override
    public void idle(){
        System.out.println(getName() + " is taking it easy outside the Prospector Saloon.");
    }

    @Override
    public void attack(NPC npc){
        System.out.println(getName() + " is throwing dynamite at " + npc.getName() + "!");
        npc.takeDamage();
    }

    @Override
    public void takeDamage() {
        Random random = new Random();
        int num;

        if (random.nextBoolean()) {
           num = 1;
        } else {
            num = 2;
        }

        // maaaaaybe return to protected...?
        float hp = getCurrentHp();
        if (num == 1) {
            System.out.println(getName() + " has taken damage.");
            hp -= 20;
        }

    }
}

public class Goodsprings {
    public static void main(String[] args) {

    }
}