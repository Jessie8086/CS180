import java.util.Scanner;
public class Debug {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String firstName = scanner.next();
        String lastName = scanner.next();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your job: ");
        String job = scanner.nextLine();

        System.out.println(firstName + " " + lastName + "\nAge: " + age + "\nOccupation: " + job);

    }
}
