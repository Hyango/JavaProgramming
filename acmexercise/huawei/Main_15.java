package acmexercise.huawei;

import java.util.Scanner;

public class Main_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            // 调用函数解决
            // int i = Integer.bitCount(n);
            // System.out.println(i);
            int count = 0;
            while (n != 0) {
                if (n % 2 == 1)
                    count++;
                n /= 2;
            }
            System.out.println(count);
        }
    }
}
