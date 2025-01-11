public class Main2 {
    public static void main(String[] args) {
        try {
            testMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in main method: " + e.getMessage());
        }
    }

    public static void testMethod() {
        try {
            // 可能抛出异常的代码
            int result = 10 / 0;
            System.out.println("Result: " + result); // 这行代码不会执行
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught in testMethod: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed in testMethod."); // 最终块始终执行
        }
    }
}
