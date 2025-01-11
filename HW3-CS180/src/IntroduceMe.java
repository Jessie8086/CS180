import java.util.Scanner;
public class IntroduceMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //name input
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        //major input
        System.out.println("Enter your major: ");
        String major = scanner.nextLine();
        //credits input
        System.out.println("Enter the number of credits you are taking: ");
        int credits = scanner.nextInt();
        //GPA input
        System.out.println("Enter your GPA: ");
        double GPA = scanner.nextDouble();
        scanner.nextLine();
        //Previous Experience
        System.out.println("Enter your previous experience: ");
        String experience = scanner.nextLine();
        //hobby
        System.out.println("Enter your hobby: ");
        String hobby = scanner.nextLine();

        System.out.printf("Hello! My name is %s.\n" +
                "I am majoring in %s.\n" +
                "I am currently taking %s credits.\n" +
                "My GPA is %.2f.\n" +
                "Before coming to Purdue, I was %s.\n" +
                "I like to spend my free time %s.\n", name, major, credits, GPA, experience, hobby);

    }
}