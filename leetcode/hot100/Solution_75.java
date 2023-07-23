package leetcode.hot100;

import java.util.Arrays;

public class Solution_75 {
	public void sortColors(int[] nums) {
		// 两个指针:left指向红色0的最大index,right指向蓝色2的最小index
		// 遍历数组,遇到0和left指向的元素交换,遇到2和right指向的元素交换
		int left = 0, right = nums.length - 1;
		for (int i = 0; i <= right; ) {
			if (nums[i] == 0) {
				swap(nums, left, i);
				left++;
				i++;
			} else if (nums[i] == 2) { // 当与right交换后,i处可能得到的是0,因此需要对i处再进行一次处理.
				swap(nums, right, i);
				right--;
			} else {
				i++;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 0};
		new Solution_75().sortColors(nums);
		System.out.println(Arrays.toString(nums));
		
	}
}
