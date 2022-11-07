package Battle;

import Colors.ConsoleColors;
import Droids.Droid;
import Team.Team;
import Printer.Printer;
import java.util.Random;

public class Battle {
    Team myTeam;
    Team enemyTeam;
    int turnNumber = 1;
    private Random random;
    public Battle (Team _myTeam, Team _enemyTeam)
    {
        random=new Random();
        myTeam=_myTeam;
        enemyTeam=_enemyTeam;
    }

    public void Start()
    {
        battle();
    }
    private void turn(Team team, Team eTeam, int myDroidIndex, int enemyDroidIndex, String color)
    {
        if(!team.getDroidList().isEmpty())
        {
            int index= random.nextInt((eTeam.getDroidList().size()))+1;
            Droid droid=team.getDroidList().get(myDroidIndex);
            Droid enemyDroid=eTeam.getDroidList().get(index-1);
            int damage = droid.attack();
            boolean isDamaged=enemyDroid.getHit(damage);

            if(isDamaged) {
                Printer.print(color + "Droid-" + team.getDroidList().get(myDroidIndex).getName() + " give damage-" + damage + " to " + enemyDroid.getName());
            }

            if(eTeam.getDroidList().get(index-1).getHealth()<=0)
            {
                eTeam.getDroidList().remove(index-1);
            }
        }
        else{
            Printer.print(ConsoleColors.YELLOW+"Team is empty\n");
        }
    }
    private void battle()
    {
        int myDroidIndex=0;
        int enemyDroidIndex=0;
        while (!myTeam.getDroidList().isEmpty() && !enemyTeam.getDroidList().isEmpty()) {
            Printer.print(ConsoleColors.RESET+"\n----------------------------Turn number:" + turnNumber++ +"----------------------------");

            Printer.print("Your turn:");
            turn(myTeam,enemyTeam,myDroidIndex,enemyDroidIndex, ConsoleColors.GREEN_BOLD);
            Printer.print(ConsoleColors.RESET+"Enemy turn:");
            turn(enemyTeam,myTeam,enemyDroidIndex,myDroidIndex, ConsoleColors.PURPLE_BOLD);
            showInfo();

            myDroidIndex++;

            if(myDroidIndex>=myTeam.getDroidList().size()-1){
                myDroidIndex=0;
            }

            enemyDroidIndex++;

            if(enemyDroidIndex>=enemyTeam.getDroidList().size()-1)
            {
                enemyDroidIndex=0;
            }

        }
        if(myTeam.getDroidList().isEmpty())
        {
            Printer.print(ConsoleColors.RED_BOLD_BRIGHT+"Enemy team win");
        }else{
            Printer.print(ConsoleColors.GREEN_BOLD_BRIGHT+"You win");
        }
    }
    private void showInfo()
    {
        Printer.print(ConsoleColors.BLUE+"\nYour team:");
        printList(myTeam);

        Printer.print(ConsoleColors.RED+"\nEnemy team:");
        printList(enemyTeam);
    }
    private void printList(Team team)
    {
        if(team.getDroidList().isEmpty())
        {
            Printer.print(ConsoleColors.YELLOW+"Empty");
        }
        for (int i =0;i<team.getDroidList().size();i++)
        {
            Printer.print(team.getDroidList().get(i).toString());
        }
    }
}
