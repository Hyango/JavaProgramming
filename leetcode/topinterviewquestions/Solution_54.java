package leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		int count = row * col;
		int left = 0, right = col - 1;
		int up = 0, down = row - 1;
		while (true) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
				count--;
			}
			if (count==0) break;
			up++;
			for (int i = up; i <= down; i++) {
				list.add(matrix[i][right]);
				count--;
			}
			if (count==0) break;
			right--;
			for (int i = right; i >= left; i--) {
				list.add(matrix[down][i]);
				count--;
			}
			if (count==0) break;
			down--;
			for (int i = down; i >= up; i--) {
				list.add(matrix[i][left]);
				count--;
			}
			if (count==0) break;
			left++;
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				};
		System.out.println(new Solution_54().spiralOrder(matrix));
		
	}
	
	// {1, 2, 3},
	// {4, 5, 6},
	// {7, 8, 9}
}
