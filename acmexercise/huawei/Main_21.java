package acmexercise.huawei;

import java.util.Scanner;

public class Main_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] fun = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String secret = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < secret.length(); i++) {
                char ch = secret.charAt(i);
                if (ch >= 'A' && ch < 'Z')
                    sb.append((char) (Character.toLowerCase(ch) + 1));
                else if (ch == 'Z')
                    sb.append('a');
                else if (ch >= 'a' && ch <= 'z') {
                    for (int num = 2; num < fun.length; num++) {
                        if (fun[num].indexOf(ch) >= 0) {
                            sb.append(num);
                            break;
                        }
                    }
                } else
                    sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }
}
