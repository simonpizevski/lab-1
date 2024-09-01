package assignment_one;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        int[] prices = new int[24];
        String[] menuItems = new String[]{
                "1. Inmatning",
                "2. Min, Max och Medel",
                "3. Sortera",
                "4. Bästa Laddningstid (4h)",
                "e. Avsluta"
        };
        System.out.println(Arrays.toString(menuItems));

        while (active) {
            System.out.println("Elpriser");
            System.out.println("========");
            for (String menuItem : menuItems) {
                System.out.println(menuItem);
            }
            System.out.println("Välj ett alternativ: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    prices = priceInput(scanner);
                    break;
                case "2":
                    minMaxAverage(prices);
                    break;
                case "3":
                    sortPrices(prices);
                    break;
                case "4":
                    cheapestHours(prices);
                    break;
                case "e":
                case "E":
                    System.out.println("Välkommen åter!");
                    active = false;
                    break;
            }
        }
    }

    public static int[] priceInput(Scanner scanner) {
        int[] prices = new int[24];
        System.out.println("Ange elpris för varje timme");
        System.out.println("============================");

        for (int i = 0; i < 24; i++) {
            while (true) {
                String startTime = String.format("%02d", i);
                String endTime = String.format("%02d", (i + 1) % 24);
                System.out.println("Ange pris för " + startTime + "-" + endTime + " i öre (heltal): ");
                try {
                    prices[i] = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ange ett heltal");
                }
            }


        }
        return prices;
    }

    private static void minMaxAverage(int[] prices) {
        if (prices.length == 0) {
            System.out.println("Inga priser finns");
            return;
        }

        int min = prices[0];
        int max = prices[0];
        int sum = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
            sum += prices[i];
        }
        double avg = (double) sum / prices.length;

        System.out.println("Lägsta pris: " + min + " öre");
        System.out.println("Högsta pris: " + max + " öre");
        System.out.println("Medelpris: " + avg + " öre");
    }

    private static void sortPrices(int[] prices) {
        int[] hours = new int[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = i;
        }

        Arrays.sort(prices);
        System.out.println("Billigast till dyrast: ");
        for (int i = 0; i < prices.length; i++) {
            System.out.println(String.format("%02d", hours[i]) + "-" + String.format("%02d", (hours[i] + 1) % 24) + "  " + prices[i] + " öre");
        }
    }

    private static void cheapestHours(int[] prices) {
        if (prices.length < 4) {
            System.out.println("Vänligen ange priser först");
            return;
        }

        int min = Integer.MAX_VALUE;
        int hour = 0;

        for (int i = 0; i < prices.length - 3; i++) {
            int sum = prices[i] + prices[i + 1] + prices[i + 2] + prices[i + 3];
            if (sum < min) {
                min = sum;
                hour = i;
            }
        }

        double avg = (double) min / 4;

        System.out.println("Bästa tiden att ladda är mellan " + String.format("%02d", hour) + ":00 och " + String.format("%02d", (hour +4) % 24) + ":00");
        System.out.println("Medelpriset är: " + avg + " öre");
    }


}
