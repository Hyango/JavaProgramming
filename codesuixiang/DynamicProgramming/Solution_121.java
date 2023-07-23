package codesuixiang.DynamicProgramming;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        //1. 确定dp数组（dp table）以及下标的含义: dp[i][0] 表示第i天持有股票所得最多现金
        //2. 确定递推公式:
        //如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来:
        //  第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
        //  第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
        //  那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], -prices[i]);
        //
        //如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
        //  第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
        //  第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
        //  同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        //3. 初始化
        // 根据递推公式可知,需要初始化dp[0][0]和dp[0][1].手动模拟得到:dp[0][0] -= prices[0], dp[0][1] = 0
        int length = prices.length;
        if (length == 1) return 0;
        int[][] dp = new int[length][2];
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }
    
    
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(new Solution_121().maxProfit(prices));
    }
    
    
}
