package leetcode.hot100;

import java.util.Arrays;

public class Solution_31 {
	public void nextPermutation(int[] nums) {
		// 例如 2, 6, 3, 5, 4, 1 这个排列， 想要找到下一个刚好比他大的排列，于是可以从后往前看
		// 我们先看后两位 4, 1 能否组成更大的排列，答案是不可以，同理 5, 4, 1也不可以
		// 直到3, 5, 4, 1这个排列，因为 3 < 5，
		// 可以通过重新排列这一段数字，来得到下一个排列
		// 因为需要使得新的排列尽量小，所以从后往前找第一个比3更大的数字，发现是4
		// 然后，调换3和4的位置，得到4, 5, 3, 1这个数列
		// 因为需要使得新生成的数列尽量小，于是可以对5, 3, 1进行排序，可以发现在这个算法中，得到的末尾数字一定是倒序排列的，
		// 于是只需要把它反转即可最终，得到了4, 1, 3, 5这个数列. 完整的数列则是2, 6, 4, 1, 3, 5
		int len = nums.length;
		for (int i = len - 1; i > 0; i--) {
			// 从后往前找到第一个满足nums[i - 1]< nums[i]的数
			if (nums[i - 1] < nums[i]) {
				// 从后往前找第一个比nums[i - 1]更大的数,并交换
				for (int j = len - 1; j >= i; j--) {
					if (nums[j] > nums[i - 1]) {
						int temp = nums[i - 1];
						nums[i - 1] = nums[j];
						nums[j] = temp;
						break;
					}
				}
				// 对之后的数排序
				Arrays.sort(nums, i, len);
				return;
			}
		}
		// 所给数组nums为降序排列,直接返回升序排列的数组
		Arrays.sort(nums);
		return;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 6, 3, 5, 4, 1};
		new Solution_31().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
	}
}
