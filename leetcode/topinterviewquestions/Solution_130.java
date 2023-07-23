package leetcode.topinterviewquestions;

import java.util.Arrays;

public class Solution_130 {
	public void solve(char[][] board) {
		// 遍历board最外围区域,将"O"及其所有相连的"O"置为"R", 最后遍历board,将"0"替换为"X","R"替换为"O".
		int m = board.length;
		int n = board[0].length;
		// 处理最外围
		for (int i = 0; i < m; i++) {
			if (i == 0 || i == m - 1) { // 首行,尾行
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'O')
						traverse(board, i, j);
				}
			} else { // 首列,尾列
				if (board[i][0] == 'O')
					traverse(board, i, 0);
				if (board[i][n - 1] == 'O')
					traverse(board, i, n - 1);
			}
		}
		
		// 还原:遍历board,将"0"替换为"X","R"替换为"O".
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'R')
					board[i][j] = 'O';
			}
		}
	}
	
	private void traverse(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i > m - 1 || j < 0 || j > n - 1)
			return;
		
		if (board[i][j] != 'O')
			return;
		
		board[i][j] = 'R';
		traverse(board, i - 1, j);
		traverse(board, i + 1, j);
		traverse(board, i, j - 1);
		traverse(board, i, j + 1);
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'X', 'O', 'X'},
				{'O', 'X', 'O'},
				{'X', 'O', 'X'},
		};
		new Solution_130().solve(board);
		for (char[] chars : board) {
			System.out.println(Arrays.toString(chars));
		}
	}
}
