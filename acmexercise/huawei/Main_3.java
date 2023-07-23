package acmexercise.huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class Main_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            integers.add(in.nextInt());
        }
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
