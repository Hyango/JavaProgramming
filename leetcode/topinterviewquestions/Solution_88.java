package leetcode.topinterviewquestions;

import java.util.Arrays;

public class Solution_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) return;
		if (m == 0) System.arraycopy(nums2, 0, nums1, 0, n);
		int cur = m + n - 1;
		
		while (m > 0 && n > 0) {
			if (nums1[m - 1] < nums2[n - 1]) {
				nums1[cur] = nums2[n - 1];
				cur--;
				n--;
			} else {
				nums1[cur] = nums1[m - 1];
				cur--;
				m--;
			}
		}
		if (m == 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
		}
		// 	n==0时,不需要处理
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
		int m = 3, n = 3;
		new Solution_88().merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
}
