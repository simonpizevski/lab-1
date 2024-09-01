package assignment_one;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] menuItems = new String[]{
                "1. Inmatning",
                "2. Min, Max och Medel",
                "3. Sortera",
                "4. Bästa Laddningstid (4h)",
                "e. Avsluta"};
        System.out.println(Arrays.toString(menuItems));

        boolean active = true;

        while (active) {
            System.out.println("Elpriser");
            System.out.println("========");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println(menuItems[i]);
            }
            System.out.println("Välj ett alternativ: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    break;
                case "e":
                case "E":
                    active = false;
                    break;
            }
        }
    }


}
