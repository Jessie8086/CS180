package staticMethodsExample2;

import java.util.ArrayList;

public class StudentUtil {
    //这个类是工具类
    private StudentUtil(){}
    public static int getMaxAge(ArrayList<Student> list){
        int max = list.get(0).getAge();

        for(int i = 1; i < list.size(); i++) {
            int tempAge = list.get(i).getAge();
            if(tempAge > max){
                max = tempAge;
            }
        }
        return max;
    }
}
