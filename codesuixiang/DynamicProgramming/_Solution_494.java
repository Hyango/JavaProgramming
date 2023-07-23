package codesuixiang.DynamicProgramming;

public class _Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        //01背包问题
        //和为target,可以把这些数分为两堆. 一堆数的符号为﹢,他们的和记为Pos;另一堆为﹣,他们绝对值之和记为Neg.
        //则有 Pos - Neg = target. Pos + Neg = sum.  => pos = (target + sum)/2
        //所以dp[j]定义为: 从nums[0..i]中选择,和为j = (target + sum)/2的方法数.
        //递推公式为dp[j] = dp[j] + dp[j-nums[i]]
        //等号右边解释: dp[j]:不加上num[i]时,和为j的方法数.
        //            dp[j-nums[i]]:没有加nums[i]时,和为j-nums[i]的方法数,当加上nums[i]时,和变为j.
        //故本体所需要的结果是dp[(target + sum)/2] 的值.
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if ((target + sum) % 2 == 1) return 0; //无解情况
        if (target + sum < 0) return 0;
        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1; //背包容量为0时,有1种解法.
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
    
    
    public static void main(String[] args) {
        int[] nums = {100,1,1,2};
        int target = -98;
        System.out.println(new _Solution_494().findTargetSumWays(nums, target));
        
    }
}
