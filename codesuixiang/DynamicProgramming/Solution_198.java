package codesuixiang.DynamicProgramming;

public class Solution_198 {
    
    public int rob(int[] nums) {
        //与01背包类似
        //1.确定dp数组及下标含义
        //dp[i]:表示[0,i]房间中,可偷窃的最大总数
        //2.确定递推公式
        //  ①若偷了第i-1间房,则第i间不能偷: dp[i]=dp[i-1]
        //  ②若不偷第i-1间房,则第i间能偷:   dp[i]=dp[i-2]+nums[i]
        //  故:dp[i]=max(dp[i-1], dp[i-2]+nums[i])
        //3.初始化从递推公式可知,dp[0],dp[1]需要初始化. dp[0]=nums[0], dp[1]=max(nums[0],nums[1])
        int length = nums.length;
        if (length==1) return nums[0];
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length-1];
    }
    
    
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(new Solution_198().rob(nums));
    }
    
}
