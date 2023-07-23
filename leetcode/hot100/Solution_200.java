package leetcode.hot100;

public class Solution_200 {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		
		return count;
	}
	
	private void dfs(char[][] grid, int i, int j) {
		// 递归返回条件
		// 1.坐标超出边界
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
			return;
		// 2.当前坐标为水
		if (grid[i][j] == '0')
			return;
		
		grid[i][j] = '0'; // 将访问过的陆地变为水
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
	
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		System.out.println(new Solution_200().numIslands(grid));
	}
}
