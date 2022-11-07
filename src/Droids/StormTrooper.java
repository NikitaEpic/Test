package Droids;

import Colors.ConsoleColors;
import Printer.Printer;

import java.util.Random;

public class StormTrooper extends Droid {
    private int criticalAttack;
    private int chanceCriticalAttack;
    public StormTrooper()
    {
        super("StormTrooper",60,30);
        criticalAttack=50;
        chanceCriticalAttack=25;
    }
    @Override
    public int attack()
    {
        Random r = new Random();
        int value = r.nextInt(4) + 1;
        if (value == 1 ) {
            Printer.print(ConsoleColors.GREEN_BRIGHT+"Critical attack");
            return criticalAttack;

        }else{
            return r.nextInt(damage-10+1)+10;
        }

    }

}
