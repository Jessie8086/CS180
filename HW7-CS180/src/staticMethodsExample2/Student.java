package staticMethodsExample2;

public class Student {
    //这个类是JavaBean类
    private String name;
    private int age;
    private String gender;

    public Student(){
    }
    public Student(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
}
