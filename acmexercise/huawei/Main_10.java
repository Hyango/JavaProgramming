package acmexercise.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count=0;
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                count++;
            }
            else continue;
        }
        System.out.println(count);
    }
}
