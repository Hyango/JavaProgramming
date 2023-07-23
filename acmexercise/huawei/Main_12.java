package acmexercise.huawei;

import java.util.Scanner;

public class Main_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String string = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = string.length() - 1; i >= 0; i--) {
                sb.append(string.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
