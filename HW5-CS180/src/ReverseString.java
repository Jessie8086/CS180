import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String option;

        do {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();

            for (int i = 0; i < input.length(); i++) {
                System.out.print(input.charAt(input.length() - 1 - i));
            }

            System.out.println("\nAgain?");
            option = scanner.nextLine();

        } while (option.equals("Y"));

    }
}
