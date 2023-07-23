package leetcode.hot100;

public class Solution_152 {
	public int maxProduct(int[] nums) {
		// 以0作为分隔,计算每一段的乘积
		
		//  1.若负数个数为奇数个,则组成最大乘积的数来自 最右侧的负数 的左边所有数.
		//  						     或者来自 最左侧的负数 的右边所有数.
		//  2.如负数个数为偶数个,则最大乘积的来自所有数
		// 针对以上1. 2. 问题,分别从左和右遍历数组即可.
		int res = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			res *= nums[i];
			if (res > max) max = res;
			if (nums[i] == 0) res = 1;
		}
		
		res = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res *= nums[i];
			if (res > max) max = res;
			if (nums[i] == 0) res = 1;
		}
		return max;
	}
	
	public int maxProduct1(int[] nums) {
		// DP解法
		// 记录两个数值:每次相乘后的最大值和最小值,因为最小值在下一次碰到负数时,会成为最大值.
		int max = Integer.MIN_VALUE;
		int maxCurrent = 1;
		int minCurrent = 1;
		for (int num : nums) {
			int maxPre = maxCurrent;
			// 注意: 需要和num进行比较, 当上一个元素为0时,maxCurrent和minCurrent将变为0;
			maxCurrent = Math.max(Math.max(maxPre * num, minCurrent * num), num);
			minCurrent = Math.min(Math.min(maxPre * num, minCurrent * num), num);
			max = Math.max(maxCurrent, max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, -2, 4};
		System.out.println(new Solution_152().maxProduct1(nums));
		
	}
}
