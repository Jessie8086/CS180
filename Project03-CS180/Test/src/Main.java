import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*String hhh = "name,age,number,,,,";
        String[] parts = hhh.split(",");
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
        System.out.println(parts.length);*/

       /* if (classificationStr.length() != 1 || !Character.isLetter(classificationStr.charAt(0))
                || (classificationStr.charAt(0)) < 'A' || (classificationStr.charAt(0)) > 'Z') {
            throw new BadDataException("Bad Researcher Data");
        } else {
            this.classification = classificationStr.charAt(0);
            if(classificationStr.equals("E") && activeStr.equals("true")){
                throw new BadDataException("Bad Researcher Data");
            }
        }*/

    /*    String data = "name,123,fwef";
        String[] parts = data.split(",");
        int[] clearanceScales = {1, 2, 3, 4, 5};

        for (int clearanceScale : clearanceScales) {
            if (Integer.parseInt(parts[2]) == clearanceScale) {
                System.out.println("执行了");
            }
        }*/
        // 定义一个数组
        /*String[] array = {"apple", "banana", "cherry"};

        // 将数组转换成 ArrayList
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("转换后的 ArrayList：" + arrayList);

        // 从 ArrayList 中删除一个元素
        arrayList.remove("cherry");

        System.out.println("删除元素后的 ArrayList：" + arrayList);
        System.out.println("原始数组：" + Arrays.toString(array));*/

        // TODO Auto-generated method stub
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        int size=list.size();
        String[] array = (String[])list.toArray(new String[size]);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }



    }
}