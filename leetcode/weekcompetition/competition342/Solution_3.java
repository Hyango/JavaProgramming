package leetcode.weekcompetition.competition342;

import java.util.*;

public class Solution_3 {
	public int[] getSubarrayBeauty(int[] nums, int k, int x) {
		int length = nums.length;
		int[] res = new int[length - k + 1];
		// 使用set记录滑动窗口中的数字的下标,并按数字的大小排序
		Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (nums[o1] == nums[o2])
					return o1-o2;
				else return nums[o1] - nums[o2];
			}
		});
		for (int i = 0; i < k; i++) {
			set.add(i);
		}
		// 迭代器找到首个窗口中第x小的数
		Iterator<Integer> iterator = set.iterator();
		int count = x;
		Integer next = 0;
		while (count-- > 0) {
			next = iterator.next();
		}
		res[0] = Math.min(nums[next], 0);
		// 移动窗口,并计算
		for (int i = 1; i < length - k + 1; i++) {
			set.remove(i - 1);
			set.add(i + k - 1);
			
			Iterator<Integer> iterator1 = set.iterator();
			count = x;
			next = 0;
			while (count-- > 0) {
				next = iterator1.next();
			}
			res[i] = Math.min(nums[next], 0);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {-46,-34,-46};
		int k = 3, x = 3;
		int[] res = new Solution_3().getSubarrayBeauty(nums, k, x);
		System.out.println(Arrays.toString(res));
	}
}
