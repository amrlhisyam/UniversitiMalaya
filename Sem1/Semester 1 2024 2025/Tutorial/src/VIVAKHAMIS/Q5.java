package VIVAKHAMIS;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String remix;

        System.out.print("Input: ");
        remix = input.nextLine();

        // Check for invalid conditions
        for (int i = 0; i < remix.length(); i++) {
            if (Character.isLowerCase(remix.charAt(i))) {
                System.out.println("invalid");
                return;
            }
        }

        if (remix.length() > 200 || remix.contains(" ")) {
            System.out.println("invalid");
            return;
        }

        // If input is valid, replace "REMIX" with a space
        String replace = "REMIX";
        String output = remix.replaceAll(replace, " ");
        System.out.println(output.trim());

    }
}