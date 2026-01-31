import java.util.Random;

abstract class NPC {
    private final String name;
    private final float maxHp;
    private float currentHp;
    private final String weapon;
    private final String affiliation;
    private boolean isAlive;

    protected NPC(String name, int maxHp, String weapon, String affiliation) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.weapon = weapon;
        this.affiliation = affiliation;
        this.isAlive = true;
        System.out.println(name + " arrives to town.");
        if (affiliation.equalsIgnoreCase("Goodsprings")) {
            System.out.println("That is a well-known resident of Goodsprings.");
        } else System.out.println("That is no local...");
    }

    public abstract void idle();

    public abstract void attack(NPC npc);

    public void takeDamage(float damage) {
        Random random = new Random();
        int num;

        if (random.nextBoolean()) {
            num = 1;
        } else {
            num = 2;
        }

        // maybe return to protected...?
        if (num == 1) {
            System.out.println(name + " has taken " + damage + " damage.");
            currentHp -= damage;
            if (currentHp <= 0) {
                System.out.println(name + " was slain.");
                isAlive = false;
            }
        } else {
            System.out.println(name + " narrowly avoided that attack.");
        }
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public boolean isAlive() {
        return isAlive;
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
    public void idle() {
        System.out.println(getName() + " is taking it easy outside the Prospector Saloon.");
    }

    @Override
    public void attack(NPC npc) {
        if (isAlive()) {
            System.out.println(getName() + " is throwing " + getWeapon() + " at " + npc.getName() + "!");
            npc.takeDamage(30);
        }
    }

}

class JoeCobb extends NPC {
    public JoeCobb() {
        super("Joe Cobb", 120, ".357 Magnum", "Powder Ganger");
    }
    @Override
    public void idle() {
        System.out.println(getName() + " is about to cause some trouble in the Wasteland.");
    }
    @Override
    public void attack(NPC npc) {
        if (isAlive()) {
            System.out.println(getName() + " is firing his " + getWeapon() + " at " + npc.getName() + "!");
            npc.takeDamage(20);
        }
    }
}

public class Goodsprings {
    public static void main(String[] args) {
        EasyPete ep = new EasyPete();
        ep.idle();
        System.out.println();
        JoeCobb jc = new JoeCobb();
        jc.idle();
        System.out.println();
        System.out.println(jc.getName() + " spots " + ep.getName() + "!");
        jc.attack(ep);

        while (ep.isAlive() && jc.isAlive()) {
            ep.attack(jc);
            jc.attack(ep);
            System.out.println();
            System.out.println(ep.getName() + " has " + ep.getCurrentHp());
            System.out.println(jc.getName() + " has " + jc.getCurrentHp());
            System.out.println();
        }
    }
}