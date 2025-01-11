import java.util.Locale;
import java.util.Scanner;

/**
 * HW-03 -- CreateNewUser
 * <p>
 * This program takes in input from System.in
 * performs string manipulation and returns a user String
 * <p>
 *
 * @author Jiaxun Li, Section L20
 * <p>
 * @version Jan 9, 2024
 */

public class CreateNewUser {
    //List of public static final strings provided to prevent typos
    public static final String PROMPT_ONE = "Enter Customer First Name:";
    public static final String PROMPT_TWO = "Enter Customer Last Name:";
    public static final String PROMPT_THREE = "Enter Customer Age:";
    public static final String PROMPT_FOUR = "Enter Customer Street Address:";
    public static final String PROMPT_FIVE = "Enter Customer City:";
    public static final String PROMPT_SIX = "Enter Customer State:";
    public static final String PROMPT_SEVEN = "Enter Customer Zip Code:";
    public static final String PROMPT_EIGHT = "Enter Customer Phone Number:";
    public static final String OUTPUT = "The Assigned User String is ";


    public static void main(String[] args) {

        // Receive input from keyboard
        Scanner scanner = new Scanner(System.in);

        System.out.println(PROMPT_ONE);
        String firstName = scanner.nextLine();

        System.out.println(PROMPT_TWO);
        String lastName = scanner.nextLine();

        System.out.println(PROMPT_THREE);
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println(PROMPT_FOUR);
        String streetAddress = scanner.nextLine();

        System.out.println(PROMPT_FIVE);
        String city = scanner.nextLine();

        System.out.println(PROMPT_SIX);
        String state = scanner.nextLine();

        System.out.println(PROMPT_SEVEN);
        String zipCode = scanner.nextLine();

        System.out.println(PROMPT_EIGHT);
        String phoneNumber = scanner.nextLine();

        // define a new string
        String userString = "";

        //1: first name
        String a = Character.toString(firstName.charAt(0))
                + Character.toString(firstName.charAt(firstName.length() - 1));
        a = a.toLowerCase();
        userString += a;

        //2: last name
        userString = lastName.substring(0, 2).toUpperCase() + userString;

        //3: age
        String age2 = Integer.toString(age);
        String binaryAge = Integer.toBinaryString(Character.getNumericValue(age2.charAt(1)));
        binaryAge = String.format("%04d", Integer.parseInt(binaryAge));

        userString = Character.toString(age2.charAt(0)) + userString + binaryAge;

        //4: street address
        String streetAddress2 = streetAddress.replace(" ", "").toUpperCase();
        userString += streetAddress2;

        //5: city
        String city2 = " " + city.toUpperCase().substring(0, 2);
        userString += city2;

        //6: state
        String state2 = state.toUpperCase();
        int ascii1 = (int) state2.charAt(0);
        int ascii2 = (int) state2.charAt(1);
        String ascii = Integer.toString(ascii1 + ascii2);
        userString += ascii;

        //7: zip code
        int firstDigit = Character.getNumericValue(zipCode.charAt(0));
        int thirdDigit = Character.getNumericValue(zipCode.charAt(2));
        String sumOfDigits = Integer.toString(firstDigit + thirdDigit);
        userString += sumOfDigits;

        //8: phone number
        String lastFour = phoneNumber.substring(phoneNumber.length() - 4);
        userString += lastFour;

        //9: add the quantity of input length
        int quantityOfInput = firstName.length() + lastName.length() + age2.length()
                + streetAddress.length() + city.length() + state.length() + zipCode.length()
                + phoneNumber.length();
        String quantity = Integer.toString(quantityOfInput);
        userString = quantity + userString;

        //10: remove 'O's and 'I's
        userString = userString.replace("O", "").replace("I", "");

        //print out
        System.out.println(OUTPUT + userString);


    } //End Main method


} //End CreateNewUser.class
