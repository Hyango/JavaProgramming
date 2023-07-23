package codesuixiang.DynamicProgramming;

import java.util.Arrays;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        //1. 定义dp[i]: 以nums[i]结尾的最长子序列长度.
        //2. 更新方式: if(nums[i]>nums[j]) dp[i]=max(dp[i],dp[j]+1)
        //3. 初始化:注意,数组的初始化应为1.
        int length = nums.length;
        int maxLength = 0;
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};//
        System.out.println(new Solution_300().lengthOfLIS(nums));
    }
}
