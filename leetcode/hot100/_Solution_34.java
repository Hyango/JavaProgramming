package leetcode.hot100;

import java.util.Arrays;

public class _Solution_34 {
	/*
	搜索左右边界,注意各种情况下是否需要加上"=",以及各种边界的设置.
	https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/wo-xie-le--9c7a4/
	左右边界的二分查找使用左闭右闭
	 */
	public int[] searchRange(int[] nums, int target) {
		// 先找左边界, 再找右边界.
		// 注意:寻找边界时,left和right的更新方式.理解清楚为什么!!!
		int[] res = {-1, -1};
		int length = nums.length;
		if (length == 0) return res;
		if (length == 1) {
			if (nums[0] == target)
				return new int[]{0, 0};
			else return res;
		}
		
		// 找左边界,左闭右闭写法. 查找左边界,同时收缩右边界
		int left = 0, right = length - 1;
		// 搜索区间为[left, right]
		int mid;
		while (left <= right) { // 结束条件为:left==right+1, 此时搜索区间为[right+1,right]
			mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;// 搜索区间变为 [mid+1, right]
			} else if (nums[mid] > target) {
				right = mid - 1;// 搜索区间变为 [left, mid-1]
			} else if (nums[mid] == target) {
				right = mid - 1;// 收缩右侧边界
			}
		}
		// 由结束条件可知,left,right存在越界风险
		// 考虑target小于所有数的情况: 此时left==0,right==-1(越界);
		// 考虑target大于所有数的情况: 此时left==lenght(越界),right==length-1;
		if (left == nums.length)
			res[0] = -1;
		else {
			// 判断一下 nums[left] 是不是 target
			res[0] = nums[left] == target ? left : -1;
		}
		
		// 找右边界,左闭右闭写法. 查找右边界,同时收缩左边界
		left = 0;
		right = length - 1;
		while (left <= right) {// 结束条件为:left==right+1, 此时搜索区间为[right+1,right]
			mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				left = mid + 1;// 收缩左侧边界即可
			}
		}
		// 循环结束时,left位于mid的右侧,因此需要-1
		// 考虑target小于所有数的情况: 此时left==0,right==-1(越界);
		// 考虑target大于所有数的情况: 此时left==lenght(越界),right==length-1;
		if (right < 0) res[1] = -1;
		else res[1] = nums[right] == target ? right : -1;
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] res = new _Solution_34().searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}
}
