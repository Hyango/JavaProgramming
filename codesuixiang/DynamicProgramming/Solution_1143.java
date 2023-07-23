package codesuixiang.DynamicProgramming;

public class Solution_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //1. 定义dp:dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        //2. 状态转移公式:
        //    如果text1[i - 1] == text2[j - 1]相同:
        //      那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
        //    如果text1[i - 1] != text2[j - 1]不相同:
        //      dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[length1][length2];
    }
    
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new Solution_1143().longestCommonSubsequence(text1, text2));
    }
}
