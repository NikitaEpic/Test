package Printer;

import java.io.*;

public class Printer {

    private static FileWriter myWriter;
    public static boolean writeToFile = false;

    public Printer(String fileName) {
        try {
            myWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(String st) {
        System.out.println(st);
        if (writeToFile) {
            try {
                myWriter.write(st + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printInputValue(String value) {
        if (writeToFile) {
            try {
                myWriter.write(value + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFromFile(String fileName) {

        try {
            FileInputStream fstream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
            }
            fstream.close();
        } catch (IOException e) {
            System.out.println("Невірний шлях");
            e.printStackTrace();
        }
    }

    public void closePrinter() {
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
