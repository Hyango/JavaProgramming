package leetcode.topinterviewquestions;

public class Solution_36 {
	public boolean isValidSudoku(char[][] board) {
		// 记录某行，某位数字是否已经被摆放
		boolean[][] row = new boolean[9][9];
		// 记录某列，某位数字是否已经被摆放
		boolean[][] col = new boolean[9][9];
		// 记录九宫格的某位数字是否已经被摆放
		boolean[][][] block = new boolean[3][3][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '1';
					// 当前数字在当前 行,列,九宫格 中的一个出现过
					if (row[i][num] || col[j][num] || block[i / 3][j / 3][num])
						return false;
					else {
						row[i][num] = true;
						col[j][num] = true;
						block[i / 3][j / 3][num] = true;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
		};
		System.out.println(new Solution_36().isValidSudoku(board));
		
	}
}

