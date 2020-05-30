import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {

        fileContentToArray("pl.coderslab/tasks.csv");
        menu();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            switch (input) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    break;
                case "list":
                    seeFile();
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }

    public static String[][] fileContentToArray(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            System.out.println("File not exist.");
            System.exit(0);
        }

        String[][] array = null;
        try {
            List<String> strings = Files.readAllLines(path);
            array = new String[strings.size()][strings.get(0).split(",").length];

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    array[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void menu() {  //wyswietlanie menu
        String[] arrayMenu = {"add", "remove", "list", "exit"};
        System.out.println(ConsoleColors.BLUE + "Please select an option" + ConsoleColors.RESET);
        for (int i = 0; i < arrayMenu.length; i++) {
            System.out.println(arrayMenu[i]);
        }
    }

    public static void seeFile() {  //czytanie z pliku

        Path path = Paths.get("pl.coderslab/tasks.csv");
        try {
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        System.out.println("Please add task due date");
        String dueDate = scanner.nextLine();
        System.out.println("Is your task is important: true/false");
        String isImportant = scanner.nextLine();

        Path path = Paths.get("pl.coderslab/tasks.csv");
        List<String> outList = new ArrayList<>();
        outList.add(description + "," + dueDate + "," + isImportant);
        try {
            Files.write(path, outList);
        } catch (IOException ex) {
        }
    }
}
