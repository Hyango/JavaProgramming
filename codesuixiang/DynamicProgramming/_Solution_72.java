package codesuixiang.DynamicProgramming;

public class _Solution_72 {
    public int minDistance(String word1, String word2) {
        //CodeSuiXiang/DynamicProgramming/LeetCode-72_编辑距离_详细图解.md
        // ↑ 详细图解
        //初始化: dp[0][0]=0, 空字符串,无需操作;
        //dp[0][j]=j, word1为空串,变成长度为j的串,需要j次添加操作.
        //dp[i][0]=0, word1为长度i的串,变成空串,需要i次删除操作.
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i < length1 + 1; i++) dp[i][0] = i;
        for (int j = 1; j < length2 + 1; j++) dp[0][j] = j;
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[length1][length2];
    }
    
    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        System.out.println(new _Solution_72().minDistance(word1, word2));
    
    }
    
}
