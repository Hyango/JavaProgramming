package acmexercise.honor;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_00 {
	// BFS
	public int minSteps(int[] arr) {
		int n = arr.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = true;
		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int curr = queue.poll();
				if (curr == n - 1) {
					return steps;
				}
				for (int j = 1; j <= arr[curr] && curr + j < n; j++) {
					int next = curr + j;
					if (!visited[next]) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
			steps++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums={7, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9};
		System.out.println(new Solution_00().minSteps(nums));
		
	}
}
