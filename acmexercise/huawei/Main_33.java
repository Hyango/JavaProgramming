package acmexercise.huawei;

import java.util.Scanner;

public class Main_33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String ip = in.nextLine();
            String[] split = ip.split("\\.");
            long sum = 0;
            sum += Long.parseLong(split[0]) << 24;
            sum += Long.parseLong(split[1]) << 16;
            sum += Long.parseLong(split[2]) << 8;
            sum += Long.parseLong(split[3]);
            System.out.println(sum);
            
            String ipSum = in.nextLine();
            long total = Long.parseLong(ipSum);
            long[] num = new long[4];
            for (int i = num.length - 1; i >= 0; i--) {
                num[i] = total & ((1 << 8) - 1); // 或者 total % (1 << 8);
                total = total >> 8;
            }
            System.out.println(num[0] + "." + num[1] + "." + num[2] + "." + num[3]);
        }
    }
}
