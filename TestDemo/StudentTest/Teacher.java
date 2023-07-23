package TestDemo.StudentTest;

public class Teacher{
    String name;
    int age;
    Student stu;
    
    
    public Teacher() {
    }
    
    public Teacher(String name, int age, Student stu) {
        this.name = name;
        this.age = age;
        this.stu = stu;
    }
    
    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * 获取
     * @return stu
     */
    public Student getStu() {
        return stu;
    }
    
    /**
     * 设置
     * @param stu
     */
    public void setStu(Student stu) {
        this.stu = stu;
    }
    
    public String toString() {
        return "Teacher{name = " + name + ", age = " + age + ", stu = " + stu + "}";
    }
    
}
