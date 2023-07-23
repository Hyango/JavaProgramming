package codesuixiang.GreedyAlgorithm;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        //如果第一个数为负,那么我们一定会从第二个数开始累计
        //基于此思想,当我们不断累加,当和为负数时,应该立刻放弃累加,从下一个整数重新开始累加
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0)//应该重新计数了
                sum = 0;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums={-1};
        System.out.println(new Solution_53().maxSubArray(nums));
    }
    
}
