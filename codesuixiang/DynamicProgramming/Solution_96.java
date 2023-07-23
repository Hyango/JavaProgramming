package codesuixiang.DynamicProgramming;

public class Solution_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - 1 - j];
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution_96().numTrees(n));
    }
}
