package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return result;
    }
    
    private void backtracking(int k, int sum, int start) { //sum值剩余值
        //1. 回溯结束条件
        if (path.size() == k) {
            if (sum == 0) {
                List<Integer> temp = new ArrayList<>(path);
                result.add(temp);
            }
            return;
        }
        //2. 单层逻辑
        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum -= i;
            backtracking(k, sum, i + 1);
            sum += i;
            path.remove(path.size() - 1);
        }
        return;
    }
    
    
    public static void main(String[] args) {
        int k = 9, n = 45;
        System.out.println(new Solution_216().combinationSum3(k, n));
    }
}
