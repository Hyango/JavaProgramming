package leetcode.topinterviewquestions;

import java.util.Arrays;

public class Solution_189 {
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		k = k % length;
		if (k == 0) return;
		int[] res = new int[length];
		System.arraycopy(nums, length - k, res, 0, k);
		System.arraycopy(nums, 0, res, k, length - k);
		System.arraycopy(res, 0, nums, 0, length);
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		new Solution_189().rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}
}
