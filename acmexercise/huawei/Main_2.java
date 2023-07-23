package acmexercise.huawei;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String singleStr = in.nextLine();
            str = str.toLowerCase();
            singleStr = singleStr.toLowerCase();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                String temp = String.valueOf(str.charAt(i));
                if (temp.equals(singleStr))
                    count++;
            }
            System.out.println(count);
        }
    }
}
