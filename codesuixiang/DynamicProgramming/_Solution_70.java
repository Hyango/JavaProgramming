package codesuixiang.DynamicProgramming;

public class _Solution_70 {
    //package LeetCodeHot.Solution_70斐波拉契解法
    public int climbStairs(int n) {
        //可以看做完全背包问题的排列
        //互相转换理解,把完全背包的排列问题转换为爬楼梯问题,理解更直观
        //楼顶 n 即为背包target
        //每一步的大小即为nums,此题中每一步大小为1或2,则nums={1,2}
        int[] nums = {1, 2};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 45;
        System.out.println(new _Solution_70().climbStairs(n));
    }
}
