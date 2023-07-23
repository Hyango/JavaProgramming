package acmexercise.huawei;

import java.util.Scanner;

public class Main_75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            // 1. 输入2个字符串
            String str1 = in.nextLine();
            String str2 = in.nextLine();
        
            // 2. 转换为字符数组
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
        
            // 3. 构建dp数组
            int[][] dp = new int[c1.length + 1][c2.length + 1];
        
            // 4. 处理边界问题和初始值
            for (int i = 0; i <= c1.length; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j <= c2.length; j++) {
                dp[0][j] = 0;
            }
            int res = 0;
            for (int i = 1; i <= c1.length; i++) {
                for (int j = 1; j <= c2.length; j++) {
                    if (c1[i - 1] == c2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            System.out.println(res);
        }
    }
}
