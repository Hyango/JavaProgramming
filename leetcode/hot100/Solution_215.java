package leetcode.hot100;

import java.util.PriorityQueue;

public class Solution_215 {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
		for (int num : nums) {
			priorityQueue.offer(num);
			if (priorityQueue.size()>k){
				priorityQueue.poll();
			}
		}
		return priorityQueue.peek();
	}
	
	
	public static void main(String[] args) {
		int[] nums={3,2,1,5,6,4};
		int k=2;
		System.out.println(new Solution_215().findKthLargest(nums, k));
	}
}
