package codesuixiang.DynamicProgramming;

public class Solution_416 {
    public boolean canPartition1(int[] nums) {
        //那么只要找到集合里能够出现 sum / 2 的子集总和，就算是可以分割成两个相同元素和子集了
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
    
    
    public boolean canPartition(int[] nums) {
        //那么只要找到集合里能够出现 sum / 2 的子集总和，就算是可以分割成两个相同元素和子集了
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[][] dp=new int[n][target+1];
        //初始化
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j]=nums[0];
        }
        //迭代
        for (int i = 1; i < n; i++) { //遍历物品,即nums数组每一个元素
            for (int j = 0; j <= target; j++) {//遍历背包容量,即数组的元素值
                if(j<nums[i]) dp[i][j]=dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
            }
        }
        //查找背包容量为target时,能不能找到总价值为target的情况
        for (int i = 0; i < n; i++) {
            if(dp[i][target]==target)
                return true;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(new Solution_416().canPartition1(nums));
    }
}
