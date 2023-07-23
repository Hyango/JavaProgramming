package acmexercise.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            in.nextLine(); // 处理空格?
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = in.nextLine();
            }
            Arrays.sort(strings);
            for (String string : strings) {
                System.out.println(string);
            }
        }
    }
}
