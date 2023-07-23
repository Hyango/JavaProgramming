package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 递归.
        // left表示加入的左括号的数量, right表示加入的右括号的数量
        // 不论何时, 应该满足left>=right,否则可以剪枝
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, n, "");
        return list;
    }
    
    private void dfs(int left, int right, int n, String curStr) {
        //递归终止条件: 加入的左括号 和 右括号的数量等于n
        if (left > n || right > n || left < right) return;
        if (left == n && right == n) {
            list.add(curStr);
            return;
        }
        dfs(left + 1, right, n, curStr+"(");
        dfs(left, right + 1, n, curStr+")");
    }
    
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution_22().generateParenthesis(n));
    }
}
