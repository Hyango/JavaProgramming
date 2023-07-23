package leetcode.hot100;

public class Solution_240 {
	public boolean searchMatrix(int[][] matrix, int target) {
		// 从右上角->左下角看,类似一颗二叉搜索树. 左边的元素都比当前元素小,下面的元素都比当前元素大
		int m = matrix.length;
		int n = matrix[0].length;
		
		int i = 0;
		int j = matrix[0].length - 1;
		while (i <= m - 1 && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else if (matrix[i][j] > target)
				j--;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		int target = 5;
		System.out.println(new Solution_240().searchMatrix(matrix, target));
		
	}
}
