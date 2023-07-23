package codesuixiang.DynamicProgramming;

public class Solution_309 {
    //随想录上分为四个状态的解法也很好理解!!
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) return 0;
        int[][] dp = new int[length][2];
        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
        //迭代
        for (int i = 2; i < length; i++) {
            //今天持有,考虑前一天未持有:
            // 若前一天是冷冻期,则dp[i][0]=dp[i-2][1]-price[i]
            // 若前一天不是冷冻期, 则dp[i][0]=dp[i-1][1]-price[i].
            //    由于前一天不是冷冻期,那么前两天(i-2天)必然不持有股票, 所以dp[i-1][1]=dp[i-2][1]
            //综上,若前一天未持有股票,那么:dp[i][0]=dp[i-2][1]-price[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Solution_309().maxProfit(prices));
    }
}
