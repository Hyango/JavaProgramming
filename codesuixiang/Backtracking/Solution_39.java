package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_39 {
    List<List<Integer>> result;
    List<Integer> path;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(candidates, target, 0);
        return result;
    }
    
    private void backtracking(int[] candidates, int target, int startIndex) {
    /*startIndex用于递归至下一层时,只能重复选择自己,或者选择比自己更大的数*/
        //1. 回溯结束条件
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //2. 单层逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            if (target - candidates[i] >= 0) // 防止target - candidates[i]<0时,递归无法结束的情况出现
                backtracking(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
        return;
    }
    
    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution_39().combinationSum(candidate, target));
    }
}
