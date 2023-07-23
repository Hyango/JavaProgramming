package leetcode.hot100;

import java.util.Arrays;

public class Solution_48 {
    public void rotate(int[][] matrix) {
        // 根据模拟: m[j][n,n-1-i]=m[i][j]
        // 那么可以把matrix分成左上,右上,右下,左下四部分, 具体划分可以看官方题解的图
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix={
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};
        new Solution_48().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
