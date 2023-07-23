package codesuixiang.DynamicProgramming;

public class _Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        //DP
        //1. 定义dp[i][j]:以下标i - 1为结尾的nums1，和以下标j - 1为结尾的nums2，最长重复子数组长度为dp[i][j]
        //  说明: 定义为i-1而不是i的原因是为了方便之后的初始化
        //2. 递推公式:if(nums1[i-1] == nums2[j-1]) dp[i][j]=dp[i-1][j-1]+1
        //3. 初始化:手动模拟,dp[i][0]和dp[0][j]应该初始化为0
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        int maxLength = 0;
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(new _Solution_718().findLength(nums1, nums2));
        
    }
    
    
}
