package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution_560 {
	public int subarraySum(int[] nums, int k) {
		// 前缀和 + hashmap优化
		// nums[i..j]之和: preSum[j] - preSum[i-1] == k <===> preSum[j] - k == preSum[i-1]
		// 1.利用一个hashmap,一边遍历数组,一边保存相同的前缀和出现的次数
		// 2.当遍历到第j个元素时,只需要判断其之前的前缀和中 preSum[j] - k 出现的次数,即可得到以j元素结尾的,和为k的次数
		int length = nums.length;
		int count = 0;
		int[] preSum = new int[length];
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) preSum[i] = nums[i];
			else preSum[i] = preSum[i - 1] + nums[i];
			if (map.containsKey(preSum[i] - k))
				count += map.get(preSum[i] - k);
			map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
		}
		return count;
	}
	
	public int subarraySum1(int[] nums, int k) {
		// 前缀和
		int length = nums.length;
		int count = 0;
		int[] preSum = new int[length];
		preSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if (i == 0) {
					if (preSum[j] == k) // nums[0..j]的和
						count++;
				} else {
					if (preSum[j] - preSum[i - 1] == k) // nums[i..j]的和
						count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1};
		int k = 2;
		System.out.println(new Solution_560().subarraySum(nums, k));
		
	}
}