public class test {

    public static void main(String[] args){
        // switch
        int month = 2;
        switch (month) {
            case 1: case 2: case 3:
                System.out.println("Spring!");
                break;
            case 4: case 5: case 6:
                System.out.println("Summer!");
                break;
            case 7: case 8: case 9:
                System.out.println("Autumn!");
                break;
            default:
                System.out.println("Winter!");
                break;
        }

        char a = '2';
        int a2 = a;
        System.out.println(a2);

        // Convert between String and char

        String str = "CS180";
        char c1 = str.charAt(0);
        System.out.println(c1);
        char[] c2 = str.toCharArray();
        char c3 = c2[3];
        System.out.println(c2);

        int num2 = 7869;
        char c4 = (char)num2;
        System.out.println(c4);

        char c5 = 'a';
        short b1 = (short)c5;

        char c6 = 'a';
        float f1 = c6;
        System.out.println(f1);

        float f2 = 8.9f;
        char c7 = (char)f2;
        System.out.println(c7);

        float f5 = 3.33f;
        int n1 = 3;
        float n2 = f5/n1;
        System.out.println(n2);

        char c9 = '1';
        char c10 = Character.toLowerCase(c9);
        System.out.println(c10);


    }

}
