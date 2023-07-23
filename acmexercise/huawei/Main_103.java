package acmexercise.huawei;

import java.util.Scanner;

public class Main_103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            // String[] input1 = in.nextLine().split(" ");
            // int[] intArr = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
            double pow = Math.pow(in.nextDouble(), 1.0/3);
            System.out.printf("%.1f",pow);
        }
    }
}
