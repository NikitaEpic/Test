package Droids;

import Colors.ConsoleColors;
import Printer.Printer;
import java.util.Random;

public class Droid {
    String name;
    int health;
    int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int attack()
    {
        Random random=new Random();
        return random.nextInt(damage-5+1)+5;
    }

    public boolean getHit(int _damage)
    {
        this.health-= _damage;
        if (health < 0) {
            health = 0;
            Printer.print(ConsoleColors.RED_BOLD_BRIGHT+"Killed droid");
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "(HP: " + health + "  Av Dmg: " + damage+")";
    }
}
