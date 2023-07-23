package leetcode.hot100;

import java.util.Arrays;

public class Solution_283 {
	public void moveZeroes(int[] nums) {
		// 1.遍历数组,如果nums[i]!=0,将nums[i]拷贝到nums[curIndex].
		int curIndex = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] != 0) {
				nums[curIndex] = nums[i];
				curIndex++;
			}
		}
		for (int i = curIndex; i < length; i++) {
			nums[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[] nums={0,1,0,3,12};
		new Solution_283().moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
	}
}
