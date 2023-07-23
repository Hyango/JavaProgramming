package leetcode.hot100;

import java.util.Arrays;

public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftProduct = new int[length];
        int[] rightProduct = new int[length];
        leftProduct[0] = nums[0];
        rightProduct[length - 1] = nums[length - 1];
        //前缀积和后缀积
        for (int i = 1; i <= length - 1; i++)
            leftProduct[i] = nums[i] * leftProduct[i - 1];
        for (int i = length - 2; i >= 0; i--)
            rightProduct[i] = nums[i] * rightProduct[i + 1];
        //计算积
        nums[0] = rightProduct[1];
        nums[length - 1] = leftProduct[length - 2];
        for (int i = 1; i < length - 1; i++)
            nums[i] = leftProduct[i - 1] * rightProduct[i + 1];
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new Solution_238().productExceptSelf(nums);
        System.out.println(Arrays.toString(nums));
    }
}
