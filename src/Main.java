import Battle.Battle;
import Colors.ConsoleColors;
import Printer.Printer;
import Team.Team;

import java.io.Console;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String value;
        do {
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Гра «БИТВА ДРОЇДІВ» by Nikita Homaniuk");
            System.out.println(ConsoleColors.RESET+"1.Бій 1 на 1");
            System.out.println("2.Бій команда на команду");
            System.out.println("3.Зчитати бій з файлу");
            System.out.println("4.Вихід");
            System.out.print("Вибір:");
            value = scanner.nextLine();
            switch (value) {
                case "1": {
                    startBattle(1);
                    break;
                }
                case "2": {
                    System.out.println("Введіть розмір команди:");
                    int size = scanner.nextInt();
                    startBattle(size);
                    break;
                }
                case "3": {
                    System.out.println("Введіть шлях до файлу:");
                    String fileName = scanner.nextLine();
                    Printer.readFromFile(fileName);
                    break;
                }
                case "4": {
                    System.out.println("Завершення програми");
                    break;
                }
            }

        } while (!value.equals("4"));

    }

    private static void startBattle(int size) {
        String writeToFile;
        Printer pr = null;
        scanner.nextLine();
        System.out.println("Записати бій у файл? Так/Ні:");
        writeToFile = scanner.nextLine();
        if (writeToFile.equals("Так")) {
            pr = new Printer("DBfile.txt");
            Printer.writeToFile = true;
        } else {
            Printer.writeToFile = false;
        }
        Printer.print("Формування першої команди");
        Team myTeam = new Team(size);
        Printer.print("\nФормування другої команди");
        Team enemyTeam = new Team(size);

        Battle battle = new Battle(myTeam, enemyTeam);
        battle.Start();
        if (Printer.writeToFile && pr != null) {
            pr.closePrinter();
        }
    }
}