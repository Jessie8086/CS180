package staticMethodsExample2;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        //创建一个集合，用来存储学生对象
        ArrayList<Student> list = new ArrayList<>();

        //创建三个学生对象
        Student a = new Student("Jessie", 18, "F");
        Student b = new Student("Jiaxun", 29, "F");
        Student c = new Student("Erin", 20, "F");

        //把这三个学生对象存储到集合中
        list.add(a);
        list.add(b);
        list.add(c);
        //定义一个工具类，用于获取学生的最大年龄。在此测试类中进行测试
        int max = StudentUtil.getMaxAge(list);
        System.out.println(max);

    }
}
