package acmexercise.huawei;

import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int length = str.length();
            for (int i = 0; i < length; ) {
                if (length - i >= 8) {
                    System.out.println(str.substring(i, i + 8));
                    i += 8;
                } else {
                    int appendNum = 8 - (length - i);
                    StringBuilder appendStr = new StringBuilder();
                    for (int k = 0; k < appendNum; k++) {
                        appendStr.append("0");
                    }
                    System.out.println(str.substring(i) + appendStr);
                    i = length;
                }
            }
        }
    }
}
