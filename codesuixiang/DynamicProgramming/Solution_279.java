package codesuixiang.DynamicProgramming;

import java.util.Arrays;

public class Solution_279 {
    public int numSquares(int n) {
        //完全背包问题
        //其中nums=[1^2, 2^2, 3^2, 4^2, 5^2, 6^2,...],每个元素都是完全平方数, target=n
        //dp[j]表示和为j的完全平方数的最小数量
        //由于是求最小数量,故初始为Integer.MAX_VALUE. 递推公式:dp[j]=min(dp[j], dp[j-num[i]]+1)
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;//通过手动模拟找到dp[0]的初始值
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] != Integer.MAX_VALUE) //for循环中已经限制了i >= j * j,故此处不用再写
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution_279().numSquares(13));
    }
}
