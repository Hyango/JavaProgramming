package leetcode.topinterviewquestions;

public class Solution_26 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 1) return 1;
		int cur = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[cur] != nums[i]) {
				cur++;
				nums[cur] = nums[i];
			}
		}
		return cur + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println(new Solution_26().removeDuplicates(nums));
	}
}
