package leetcode.topinterviewquestions;

public class Solution_162 {
	public int findPeakElement(int[] nums) {
		// 二分查找处理非有序的数组,有种脑筋急转弯的感觉
		// 由于题目假设nums[-1]=nums[n]=-∞。
		// 所以，我们从0开始往后遍历元素，如果某个元素大于其后面的元素，则该元素就是峰值元素。（但是它时O(n)，不符合题意）
		// O(logN)一般考虑二分搜索。有如下规律：
		// 规律一：如果nums[i] > nums[i+1], [i, i+1]减函数, 则在i之前一定存在峰值元素(极限情况向左递增到首元素)
		// 规律二：如果nums[i] < nums[i+1], [i, i+1]增函数, 则在i+1之后一定存在峰值元素(极限情况向右递增值尾元素)
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		System.out.println(new Solution_162().findPeakElement(nums));
	}
}
