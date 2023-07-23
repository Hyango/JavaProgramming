package leetcode.hot100;

public class Solution_5 {
    public String longestPalindrome(String s) {
        //dp解法:dp[i][j]代表s[s-j]是否为回文串, 参考Solution_647
        int length = s.length();
        if (length == 1) return s;
        boolean[][] dp = new boolean[length][length];
        int subLength = 0;
        int start = 0, end = 0;//记录最长回文子串的起始位置
        //初始化dp
        for (int i = 0; i < length; i++) {
            dp[i][i] = true; //dp[i][i]表示单个元素,一定属于回文串
            if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true; //相邻两个元素相同,一定属于回文串
                subLength = 1;
                start = i;
                end = i + 1;
            }
        }
        //状态转移方程,从初始化可知,dp更新时i从length-3开始, j从i+2开始.
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1]) {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (subLength < (j - i + 1)) {
                            subLength = j - i + 1;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    
    
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution_5().longestPalindrome(s));
    }
    
}
