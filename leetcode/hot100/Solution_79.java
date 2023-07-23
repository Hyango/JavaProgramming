package leetcode.hot100;

public class Solution_79 {
	boolean isExist = false;
	boolean[][] visited;
	
	public boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				traverse(board, i, j, word, 0);
			}
		}
		return isExist;
	}
	
	/**
	 * DFS回溯查找
	 *
	 * @param board 字符网格
	 * @param i     当前坐标
	 * @param j     当前坐标
	 * @param word  字符串单词
	 * @param k     字符串单词的第k个字符
	 */
	private void traverse(char[][] board, int i, int j, String word, int k) {
		// 坐标越界, 找到字符串, 当前字符不匹配时,返回(结束当前分支)
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1
				|| isExist || visited[i][j] || board[i][j] != word.charAt(k))
			return;
		// 在board中找到了word
		if (k == word.length() - 1) {
			isExist = true;
			return;
		}
		// 遍历子节点
		visited[i][j] = true;
		traverse(board, i - 1, j, word, k + 1);
		traverse(board, i + 1, j, word, k + 1);
		traverse(board, i, j - 1, word, k + 1);
		traverse(board, i, j + 1, word, k + 1);
		visited[i][j] = false;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		String word = "ABCCED";
		System.out.println(new Solution_79().exist(board, word));
		
	}
}
