package acmexercise.huawei;

import java.util.Scanner;

public class Main_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                int ge = n % 10;
                sb.append(ge);
                n /= 10;
            }
            System.out.println(sb.toString());
        }
    }
}
