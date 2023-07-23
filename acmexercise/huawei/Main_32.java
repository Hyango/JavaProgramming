package acmexercise.huawei;

import java.util.Scanner;

public class Main_32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            // 方法1: dp[i][j]: str[i]~str[j]是否为回文串.,Solution 647
            // 方法2: 中心发散
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                res = Math.max(res, getBackStr(str, i, i));
                res = Math.max(res, getBackStr(str, i, i + 1));
            }
            System.out.println(res);
        }
    }
    
    private static int getBackStr(String s, int left, int right) {
        String temp = "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            temp = s.substring(left, right + 1);
            left--;
            right++;
        }
        return temp.length();
    }
}
