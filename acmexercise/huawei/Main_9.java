package acmexercise.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Set<Integer> set = new HashSet<>();
            while (n != 0) {
                int ge = n % 10;
                n /= 10;
                if (set.contains(ge))
                    continue;
                else {
                    set.add(ge);
                    System.out.print(ge);
                }
            }
            System.out.println();
            
        }
    }
}
