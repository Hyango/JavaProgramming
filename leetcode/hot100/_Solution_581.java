package leetcode.hot100;

public class _Solution_581 {
	public int findUnsortedSubarray(int[] nums) {
		// 1.从左往右 找 右边界:
		//  如果i位置上的数比它左边部分最大值小，则这个数肯定要排序， 就这样找到右端不用排序的部分
		// 	1.1.从左往右遍历,记录所遍历到的元素的最大值max, 当遇到max小的元素时,记录下标
		// 2.从右往左 找 右边界 同理.
		int minLength = 0;
		int length = nums.length;
		int left = -1, right = -1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) { // 从左往右 找 右边界
			if (max > nums[i])
				right = i;
			max = Math.max(max, nums[i]);
		}
		for (int i = right; i >= 0; i--) { // 从右往左 找 右边界
			if (min < nums[i]) {
				left = i;
			}
			min = Math.min(min, nums[i]);
		}
		return right == left ? 0 : right - left + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4}; // 易错用例:{1, 1, 1, 1, 3, 3, 2, 2, 2}
		System.out.println(new _Solution_581().findUnsortedSubarray(nums));
		
	}
}
