package codesuixiang.ArraysPractice;

import java.util.Arrays;

public class Solution_977 {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int leftIndex = 0, rightIndex = length - 1;
        for (int index = length - 1; index >= 0; index--) {
            if (nums[leftIndex] * nums[leftIndex] > nums[rightIndex] * nums[rightIndex])
            {
                result[index]=nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            }
            else {
                result[index]=nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] result = new Solution_977().sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
