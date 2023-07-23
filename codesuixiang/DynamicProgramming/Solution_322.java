package codesuixiang.DynamicProgramming;

import java.util.Arrays;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        //dp[j]设为背包容量为j(amount=j)时,最少的硬币数
        //则递推公式为dp[j]=min(dp[j], dp[j-coins[i]]+1)
        //由于是求最小值,且min中会包含dp[j]自身,所以dp数组的初始化值应该为MAX_VALUE
        //根据模拟可得,dp[0]=0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {//遍历背包
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]&&dp[i - coins[j]]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(new Solution_322().coinChange(coins, amount));
    }
}
