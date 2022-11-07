package Droids;

import Colors.ConsoleColors;
import Printer.Printer;

import java.util.Random;

public class Guard extends Droid {


    private int chanceBlock;
    public Guard() {
        super("Guard", 150, 10);
        this.chanceBlock=35;
    }
    public int getChanceBlock() {
        return chanceBlock;
    }

    public void setChanceBlock(int chanceBlock) {
        this.chanceBlock = chanceBlock;
    }
    @Override
    public boolean getHit(int _damage) {
        Random r = new Random();
        int value = r.nextInt(100 - 0) + 0;
        if (value > chanceBlock) {
            this.health -= _damage;
            if (health < 0) {
                health = 0;
                Printer.print(ConsoleColors.RED_BOLD_BRIGHT + "Killed droid");
            }
            return true;
        }else{
            Printer.print(ConsoleColors.RED_BOLD_BRIGHT+"Attack was blocked");
            return false;
        }
    }
}
