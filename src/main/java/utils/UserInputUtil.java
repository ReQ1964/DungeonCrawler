package utils;

import java.util.Scanner;

public class UserInputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean getYesNoInput(String prompt) {
        while (true) {
            System.out.println(prompt + " (yes/no)");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input! Please type 'yes' or 'no'.");
            }
        }
    }
}
