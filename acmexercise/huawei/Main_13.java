package acmexercise.huawei;

import java.util.Scanner;

public class Main_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] sArrays = s.split(" ");
            for (int i = sArrays.length - 1; i >= 0; i--) {
                System.out.print(sArrays[i] + " ");
            }
            System.out.println();
        }
    }
}
