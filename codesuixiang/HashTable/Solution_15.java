package codesuixiang.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
	// 三数之和
	// 双指针法
	// 使用三个指针(i<L<R)。固定最小的i在左边，L=i+1,R=_size-1 移动两个指针包夹求解。
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		// 排序
		Arrays.sort(nums);
		// 双指针法
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] > 0)
				return res;
			// 此时已经将nums[i-1]作为三元组首元素的情况全都加入res中,所以跳过重复元素,确保nums[i]改变了.
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			
			int Left = i + 1, Right = length - 1;
			while (Left < Right) {
				int sum = nums[i] + nums[Left] + nums[Right];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[Left], nums[Right])); // 与下面效果等同
					//                    List<Integer> list = new ArrayList<>();
					//                    list.add(nums[i]);
					//                    list.add(nums[Left]);
					//                    list.add(nums[Right]);
					//                    res.add(list);
					while (Left < Right && nums[Left] == nums[Left + 1]) Left++;
					while (Left < Right && nums[Right] == nums[Right - 1]) Right--;
					Left++;
					Right--;
				} else if (sum > 0) {
					Right--;
				} else {
					Left++;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(nums);
		System.out.println("-----输出方式1-----");
		System.out.println(res.toString());
		System.out.println("-----输出方式2-----");
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}
