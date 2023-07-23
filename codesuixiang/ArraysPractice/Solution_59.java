package codesuixiang.ArraysPractice;

import java.util.Arrays;

public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int total = (int) Math.pow(n, 2);
        int count = 1;
        int left = 0, right = n - 1;
        int up = 0, down = n - 1;
        while (count <= total) {
            //填充result[up][]
            for (int j = left; j <= right; j++) {
                result[up][j] = count++;
            }
            up++;
            
            //填充result[][right]
            for (int i = up; i <= down; i++) {
                result[i][right]=count++;
            }
            right--;
            
            //填充result[down][]
            for (int j = right; j >= left; j--) {
                result[down][j]=count++;
            }
            down--;
            
            //填充result[][left]
            for (int i = down; i >= up; i--) {
                result[i][left]=count++;
            }
            left++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int n=4;
        int[][] result = new Solution_59().generateMatrix(n);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
