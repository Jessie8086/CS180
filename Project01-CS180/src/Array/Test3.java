package Array;

public class Test3 {
    public static void main(String[] args){

        int[] arr1 = {1,2,3,4,5};
        for (int i = 0, j = arr1.length - 1; i < j; i++, j--) {
            int temp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = temp;

        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");

        }
    }

}
