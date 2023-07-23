package codesuixiang.DynamicProgramming;

public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        //完全背包的排列问题: 先遍历背包target,再遍历物品nums
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new Solution_377().combinationSum4(nums, target));
    }
}
