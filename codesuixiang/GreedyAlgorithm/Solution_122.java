package codesuixiang.GreedyAlgorithm;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        //只要 后一天 - 前一天 > 0,那么就可以累加进利润中
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(new Solution_122().maxProfit(prices));
    }
    
}
