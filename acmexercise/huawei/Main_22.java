package acmexercise.huawei;

import java.util.Scanner;

public class Main_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if (n == 0) break;
            int count = 0; // 记录喝到的总数
            while (n >= 3) {
                // n/3得到兑换的饮料瓶数
                count += n / 3;
                // 兑换并再次喝完后剩余空瓶数
                n = n / 3 + n % 3;
            }
            if (n==2) //剩余两瓶,则还可以借空瓶来兑换一瓶新的
                count++;
            System.out.println(count);
        }
    }
}
