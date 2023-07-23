package leetcode.hot100;

public class Solution_121 {
    //买卖股票的最佳时机
    public static int maxProfit(int[] prices) {
        //遍历一次数组,记录下访问过的元素的最小值minprice,之后如果股价大于minprice则记录最大利益maxprofit.
        //如果遇到更低的股价,则更新minprice,继续往后找更大的maxprofit,如果有,则更新.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    
}
