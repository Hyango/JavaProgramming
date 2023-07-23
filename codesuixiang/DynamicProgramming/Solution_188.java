package codesuixiang.DynamicProgramming;

public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        //模仿买卖III,只需改成迭代方式即可;
        int length = prices.length;
        int[][] dp = new int[length][2 * k + 1];
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[length - 1][2 * k];
    }
    
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(new Solution_188().maxProfit(k, prices));
    }
}
