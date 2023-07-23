package acmexercise.huawei;

import java.util.Scanner;

public class Main_35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100 - i; j++) {
                if (j == 0)
                    if (i > 0)
                        matrix[i][j] = matrix[i - 1][j] + i;
                    else
                        matrix[i][j] = 1;
                else
                    matrix[i][j] = matrix[i][j - 1] + i + j + 1;
            }
        }
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
