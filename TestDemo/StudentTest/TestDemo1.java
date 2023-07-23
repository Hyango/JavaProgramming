package TestDemo.StudentTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class TestDemo1 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",20);
        Collection<Student> coll = new ArrayList<>();
        coll.add(s1);
        
        Student s2 = new Student("wangwu",21);
        System.out.println(coll.contains(s1));
        
        Teacher t1 = new Teacher("wanger",35,s1);
        System.out.println(t1); //会默认调用toString方法
        System.out.println(t1.toString());
    
    
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal x = a.subtract(a);
    }
}
