package codesuixiang.DynamicProgramming;

public class Solution_213 {
    public int rob(int[] nums) {
        //分两种情况:
        //1.偷nums[0],则不可偷nums[len-1] => 可以偷[0,len-1)
        //2.不偷nums[0],则可偷nums[len-1] => 则可以偷[1,len)
        int length=nums.length;
        if(length==1)  return nums[0];
        if(length==2)  return Math.max(nums[0],nums[1]);
        return Math.max(robType(nums,0,length-1),
                        robType(nums,1,length));
    }
    
    public int robType(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int length = nums.length;
        int[] dp = new int[length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1];
    }
    
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(new Solution_213().rob(nums));
    }
}
