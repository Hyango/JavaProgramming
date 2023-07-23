package TestDemo.ArrayTest;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysToList {
    public static void main(String[] args) {
        System.out.println("----- List->Map -----");
        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack","18163138123"));
        bookList.add(new Person("martin","1111111"));
        // 若value为null,则会抛出空指针异常
        //collect是stream流的终结方法
        Map<String, String> collect = bookList.stream().collect(Collectors.toMap(Person::getName, Person::getPhoneNumber));
        System.out.println(collect.toString());
    
        System.out.println("----- List -> Arrays -----");
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错,即需要传入一个String类型
        System.out.println(Arrays.toString(s));
    
        System.out.println("----- Arrays -> List -----");
        //1、Arrays.asList()是泛型方法，传递的数组必须是对象数组，而不是基本类型。
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
//        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
        
        //2、使用集合的修改方法: add()、remove()、clear()会抛出异常,
        // Arrays.asList() 方法返回的并不是 java.util.ArrayList ，
        // 而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
//        myList.add(4);//运行时报错：UnsupportedOperationException
//        myList.remove(1);//运行时报错：UnsupportedOperationException
//        myList.clear();//运行时报错：UnsupportedOperationException
        
        System.out.println("----- 如何正确的将数组转换为 ArrayList? -----");
        //1.最简单的方法
        List<String> list11 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        
        //2.使用 Java8 的 Stream(推荐)
        Integer [] myArray12 = { 1, 2, 3 };
        List<Integer> myList12 = Arrays.stream(myArray12).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray13 = { 1, 2, 3 };
        List<Integer> myList13 = Arrays.stream(myArray13).boxed().collect(Collectors.toList());
        
        //3. 使用 Java9 的 List.of()方法, 本项目版本设置为Java8,因此下面代码进行了注释
        Integer[] array14 = {1, 2, 3};
//        List<Integer> list14 = List.of(array14);
    
    
    
    }
}
class Person {
    private String name;
    private String phoneNumber;
    
    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}