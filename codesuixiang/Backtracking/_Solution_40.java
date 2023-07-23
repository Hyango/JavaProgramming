package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Solution_40 {
    /* 组合问题II: candidate中选数据,使得和为target */
    List<List<Integer>> result;
    List<Integer> path;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }
    
    private void backtracking(int[] candidates, int target, int startIndex) {
        //1. 回溯结束条件
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //2. 单层逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i - 1] == candidates[i])
                //去重,注意条件不可以是i > 0,否则会出现无法选择同数值的元素
                continue;
            path.add(candidates[i]);
            //相比于Solution_39:组合总和, 由于本题不可重复选取自己,
            //所以可以不用考虑target - candidates[i]<0时,递归无法结束的情况
            //由于i+1的存在,递归总会结束,只是运行时间会长一些
            backtracking(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
        return;
    }
    
    
    public static void main(String[] args) {
        int[] candidate = {10, 1, 2, 7, 6, 1, 5,3,8};
        int target = 8;
        System.out.println(new _Solution_40().combinationSum2(candidate, target));
    }
    
}
