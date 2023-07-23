package codesuixiang.DynamicProgramming;

public class Solution_123 {
    public int maxProfit(int[] prices) {
        /*
         * 定义 5 种状态:
         * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
         *
         * dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
         * dp[i][3]是第i天时第2次持有股票:
         *      若i-1天未持有,则资金为dp[i-1][2].第i天是需要买入,则dp[i][3] = dp[i - 1][2] - prices[i].
         *      若i-1天持有,则资金为dp[i-1][3]
         *      综上,dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i])
         * dp[i][4]是第i天时第2次未持有股票:
         *      若i-1天持有,则资金为dp[i-1][3].第i天是需要卖出,则dp[i][4] = dp[i - 1][3] + prices[i].
         *      若i-1天未持有,则资金为dp[i-1][4]
         *      综上,dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i])
         */
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];
    
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
    
    
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        System.out.println(new Solution_123().maxProfit(prices));
    }
}
