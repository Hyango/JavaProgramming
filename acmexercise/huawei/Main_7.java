package acmexercise.huawei;

import java.util.Scanner;

public class Main_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            double n = in.nextDouble();
            //方法1
            System.out.println((int) (n + 0.5));
//            //方法2
//            long round = Math.round(n);
//            System.out.println(round);
        }
    }
}
