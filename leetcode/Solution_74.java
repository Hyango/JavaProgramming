package leetcode;

public class Solution_74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		// 可以直接套用240:搜索二维矩阵II的解法.
		// 此处使用二分查找:首先判断target在哪一行,然后在对应行二分查找得到结果.
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
				row = i;
				break;
			}
		}
		
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (matrix[row][mid] == target)
				return true;
			else if (matrix[row][mid] > target)
				right = mid - 1;
			else if (matrix[row][mid] < target)
				left = mid + 1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60}
		};
		int target=3;
		System.out.println(new Solution_74().searchMatrix(matrix, target));
		
	}
}
