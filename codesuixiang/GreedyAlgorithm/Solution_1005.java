package codesuixiang.GreedyAlgorithm;

import java.util.*;

public class Solution_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //从小到大排序,依次修改所有负数.若所有负数都为正,则反复修改此时的最小值
        if (nums.length == 1) return k % 2 == 0 ? nums[0] : -nums[0];
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[i] < 0) {
                nums[index] = -nums[index]; //当前数为负,则将其转为正数
                if (nums[index + 1] < 0) { //若下一个数也为负,则下标后移
                    index++;
                } else if (Math.abs(nums[index]) >= nums[index + 1]) {//下一个数非负,且当前值的绝对值更大
                    index++; //此时找到绝对值最小的数
                }
            } else nums[index] = -nums[index];
        }
        return Arrays.stream(nums).sum();
    }
    
    public static void main(String[] args) {
        int[] nums = {-2,9,9,8,4};
        int k = 5;
        System.out.println(new Solution_1005().largestSumAfterKNegations(nums, k));
    }
    
    
}
