import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {

        menu();

    }
    private static void menu() {
        String[] menuArray = {"add", "remove", "list", "exit"};
        System.out.println(ConsoleColors.BLUE + "Please select an option");
        for (int i = 0; i < menuArray.length; i++) {
            System.out.println(ConsoleColors.WHITE + menuArray[i]);
        }
    }
}
