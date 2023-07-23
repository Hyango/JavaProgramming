package leetcode.topinterviewquestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _Solution_73 {
	public void setZeroes(int[][] matrix) {
		// 遍历数组,记录下需要置零的行和列,存在Set中
		int rows = matrix.length;
		int cols = matrix[0].length;
		Set<Integer> rowsSetZero = new HashSet<>();
		Set<Integer> colsSetZero = new HashSet<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					rowsSetZero.add(i);
					colsSetZero.add(j);
				}
			}
		}
		// forEach的使用
		rowsSetZero.forEach(o1 -> matrix[o1] = new int[cols]); // 经过测试,forEach方法比较耗时
		// 增强for的使用
		// for (Integer row : rowsSetZero) {
		// 	matrix[row] = new int[cols];
		// }
		
		// 迭代器的使用
		Iterator<Integer> iterator = colsSetZero.iterator();
		while (iterator.hasNext()) {
			Integer col = iterator.next();
			for (int i = 0; i < rows; i++) {
				matrix[i][col] = 0;
			}
		}
		// 	增强for的使用
		// for (Integer col : colsSetZero) {
		// 	for (int i = 0; i < rows; i++) {
		// 		matrix[i][col] = 0;
		// 	}
		// }
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{0, 1, 2, 0},
				{3, 0, 5, 2},
				{1, 3, 1, 5}
		};
		new _Solution_73().setZeroes(matrix);
		for (int[] ints : matrix) {
			System.out.println(Arrays.toString(ints));
		}
	}
}
