package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_51 {
    List<List<String>> list = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtarcking(chessboard, 0);
        return list;
    }
    
    public void backtarcking(char[][] chessboard, int row) {//确定参数
        //确定结束条件.在棋盘最后一行保存结果并返回
        if (row == chessboard.length) {  //chessboard.length返回棋盘的行数
            List<String> tmp = new ArrayList<>();
            for (char[] chars : chessboard) {
                tmp.add(String.copyValueOf(chars));
            }
            list.add(tmp);
            return;
        }
        //单层搜索方式
        for (int col = 0; col < chessboard.length; col++) {
            if (isValid(chessboard, row, col)) {
                chessboard[row][col] = 'Q';
                backtarcking(chessboard, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }
    
    public boolean isValid(char[][] chessboard, int row, int col) {
        //检查列,45度,135度即可.因为按行递归,故不用检查行.
        //检查对应列是否出现Q
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q')
                return false;
        }
        //检查45度(左下到右上)
        for (int i = row - 1, j = col + 1; i >= 0 && j <= chessboard.length-1; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        //检查135度(右下到左上)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Solution_51().solveNQueens(4));
    }
    
}
