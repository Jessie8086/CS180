package static方法;

public class ArrUtil {
//工具类，用于帮助我们完成事情。不使用工具类调用对象，因此将构造器设置为private。里面的方法设置为static，方便调用。
    //在测试类中对工具类中的方法进行测试。
    private ArrUtil(){}

    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1){
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static double printAvg(double[] arr){
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        double avg = sum / arr.length;
        return avg;
    }
}
