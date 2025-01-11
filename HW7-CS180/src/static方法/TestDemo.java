package static方法;

import static方法.ArrUtil;

public class TestDemo {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 7, 3};
        String a = ArrUtil.printArr(array);
        System.out.println(a);

        double[] arr2 = {0.5, 4.9, 23.4, 2.3, 2.6};
        double average = ArrUtil.printAvg(arr2);
        System.out.println(average);
    }


}
