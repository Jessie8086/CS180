import java.util.Scanner;

/**
 * A program that prints the holiday associated with the selected month in the 2021-2022 academic year.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 04 -- Walkthrough
 *
 * @author Purdue CS
 * @version January 10, 2021
 */

public class AcademicHoliday {
    public static void main(String[] args) {
        String holiday = "";

        System.out.println("Pick a number between 1-6 to select a holiday!");
        System.out.println("1. July");
        System.out.println("2. September");
        System.out.println("3. October");
        System.out.println("4. November");
        System.out.println("5. January");
        System.out.println("6. March");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                holiday = "Independence Day Holiday";
                break;
            case 2:
                holiday = "Labor Day";
                break;
            case 3:
                holiday = "October Break";
                break;
            case 4:
                holiday = "Thanksgiving Vacation";
                break;
            case 5:
                holiday = "Martin Luther King Jr. Day";
                break;
            case 6:
                holiday = "Spring Vacation";
                break;

        }
        if (option == 1|option == 2|option == 3|option == 4|option == 5|option == 6) {
            System.out.printf("The holiday is: %s!\n", holiday);
        }else {
            System.out.println("That's not a valid number!");
        }
    }
}
