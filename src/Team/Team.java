package Team;

import Droids.StormTrooper;
import Droids.BasicDroid;
import Droids.Guard;
import Droids.Droid;
import Printer.Printer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Droid> droidList=new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Team(int size)
    {

        fillTeam(size);
    }
    public List<Droid> getDroidList() {

        return droidList;
    }
    public void fillTeam(int size)
    {
        for (int i = 0; i < size; i++) {
            Printer.print("Choose droid №" + (i + 1));
            try {
                droidList.add(chooseDroid());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Droid chooseDroid() throws IOException {
        Printer.print("1. Basic Droid (Stantard attack and health)\n2. Storm trooper Droid(More damage, less health, critical attack)" +
                "\n3. Guard Droid (More health, less damage, attack blocking");
        Droid droid = null;
        String enter = reader.readLine();

        while (!enter.equals("1") && !enter.equals("2")&& !enter.equals("3")) {
            Printer.print("Invalid request");
            enter = reader.readLine();
        }
        if (enter.equals("1")) droid = new BasicDroid();
        if (enter.equals("2")) droid = new StormTrooper();
        if (enter.equals("3")) droid = new Guard();
        Printer.printInputValue(enter);
        return droid;
    }

}
