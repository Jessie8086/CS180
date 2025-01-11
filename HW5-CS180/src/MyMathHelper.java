import java.util.Scanner;

/**
 * A Math Helper Program
 * <p>
 * Purdue University -- CS18000 -- Spring 2024 -- Homework 05 -- Challenge
 *
 * @author Jiaxun Li
 * @version February 2024
 */

public class MyMathHelper {

    public static final String WELCOME_MESSAGE = "Welcome to My Math Helper!";
    public static final String MAIN_MENU_ONE = "Please Select an Operation";
    public static final String MAIN_MENU_TWO = "1 - Calculate Greatest Common Denominator";
    public static final String MAIN_MENU_THREE = "2 - Perform Prime Factorization";
    public static final String MAIN_MENU_FOUR = "3 - Exit";
    public static final String GCD_NOTIFICATION = "Ready to Calculate Greatest Common Denominator";
    public static final String PF_NOTIFICATION = "Ready to Perform Prime Factorization";
    public static final String INPUT_ONE = "Please Enter an Integer";
    public static final String INPUT_TWO = "Please Enter a Second Integer";
    public static final String GCD_OUTPUT = "The Greatest Common Denominator is ";
    public static final String PF_OUTPUT = "The Prime Factorization is ";
    public static final String EXIT_MESSAGE = "Thank you for using My Math Helper!";
    public static final String INVALID_MENU_SELECTION = "Invalid selection!";
    public static final String INVALID_INPUT = "Invalid Input - Returning to Main Menu";

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String option = null;

        System.out.println(WELCOME_MESSAGE);

        do {
            boolean x;

            do {
                System.out.println(MAIN_MENU_ONE);
                System.out.println(MAIN_MENU_TWO);
                System.out.println(MAIN_MENU_THREE);
                System.out.println(MAIN_MENU_FOUR);

                option = scanner.nextLine();

                if (option.equals("1") || option.equals("2") || option.equals("3")) {
                    x = false;
                } else {
                    x = true;
                    System.out.println(INVALID_MENU_SELECTION);
                }
            } while (x);

            if (option.equals("1")) {
                int number1;
                int number2;
                int num3;

                System.out.println(GCD_NOTIFICATION);
                System.out.println(INPUT_ONE);
                number1 = scanner.nextInt();
                scanner.nextLine();

                if (number1 <= 0) {
                    System.out.println(INVALID_INPUT);

                } else {
                    System.out.println(INPUT_TWO);
                    number2 = scanner.nextInt();
                    scanner.nextLine();

                    if (number2 <= 0) {
                        System.out.println(INVALID_INPUT);
                    } else {
                        while (number2 != 0) {
                            num3 = number2;
                            number2 = number1 % number2;
                            number1 = num3;
                        }
                        System.out.printf(GCD_OUTPUT + "%d\n", number1);
                    }
                }

            } else if (option.equals("2")) {
                int number4;

                System.out.println(PF_NOTIFICATION);
                System.out.println(INPUT_ONE);
                StringBuilder primeFactors = new StringBuilder();
                number4 = scanner.nextInt();
                scanner.nextLine();

                if (number4 >= 2) {
                    for (int divisor = 2; divisor <= number4; divisor++) {
                        int count = 0;

                        while (number4 % divisor == 0) {
                            count++;
                            number4 /= divisor;
                        }
                        if (count > 0) {
                            for (int i = 0; i < count; i++) {
                                primeFactors.append(divisor);
                                // If it's not the last prime factor, append " x "
                                if (i < count - 1 || number4 != 1) {
                                    primeFactors.append(" x ");
                                }
                            }
                        }
                    }
                    System.out.printf(PF_OUTPUT + "%s\n", primeFactors);

                } else {
                    System.out.println(INVALID_INPUT);
                }
            } else {
                System.out.println(EXIT_MESSAGE);
            }

        } while (!option.equals("3"));

    } // End main
} // End class
