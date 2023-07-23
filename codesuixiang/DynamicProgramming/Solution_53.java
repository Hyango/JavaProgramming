package codesuixiang.DynamicProgramming;

public class Solution_53 {
    //package CodeSuiXiang.GreedyAlgorithm; 中贪心算法做过
    public int maxSubArray(int[] nums) {
        //DP
        //定义dp[i]:以nums[i]结尾的最大和
        //递推公式:dp[i]=max(dp[i-1]+nums[i],nums[i])
        int length = nums.length;
        if(length==1) return nums[0];
        int[] dp = new int[length];
        dp[0]=nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(new Solution_53().maxSubArray(nums));
    }
    
}
