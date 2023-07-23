package leetcode.hot100;

public class Solution_33 {
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target) return mid;
			// 如果左边有序,右边无序.
			if (nums[left] <= nums[mid]) {
				// target在左边
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else left = mid + 1;
				continue;
			}
			
			// 如果左边无序,右边有序
			if (nums[right] >= nums[mid]) {
				// target在右边
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else right = mid - 1;
				continue;
			}
		}
		return nums[mid] == target ? mid : -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 0;
		System.out.println(new Solution_33().search(nums, target));
	}
}
