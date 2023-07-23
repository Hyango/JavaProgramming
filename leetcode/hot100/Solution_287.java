package leetcode.hot100;

public class Solution_287 {
	public int findDuplicate(int[] nums) {
		// 与 LeetCode-142:环形链表II 类似.
		int slow = 0;
		int fast = 0;
		slow = nums[slow];
		fast = nums[nums[fast]];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		int pre1 = 0;
		int pre2 = slow;
		while(pre1 != pre2){
			pre1 = nums[pre1];
			pre2 = nums[pre2];
		}
		return pre1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 2, 2};
		System.out.println(new Solution_287().findDuplicate(nums));
		
	}
}
