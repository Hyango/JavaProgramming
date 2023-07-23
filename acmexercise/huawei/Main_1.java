package acmexercise.huawei;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        System.out.println(s[s.length - 1].length());
    }
}
