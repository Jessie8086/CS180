import java.util.Scanner;
public class Whatever {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder primeFactors = new StringBuilder();


        int number4 = scanner.nextInt();

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
        System.out.println(primeFactors);
    }

}
