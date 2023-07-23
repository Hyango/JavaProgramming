package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_46 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length]; //也可以初始化为boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return list;
    }
    
    public void backtracking(int[] nums, int[] used) {//确定参数
        //确定结束条件.在叶子结点出保存结果并返回
        if(tmp.size()==nums.length){
            list.add(new ArrayList<>(tmp));
            return;
        }
        
        //单层搜索方式
        for(int i=0;i<nums.length;i++){
            if(used[i]==1) continue;
            used[i]=1;
            tmp.add(nums[i]);
            backtracking(nums,used);
            tmp.remove(tmp.size()-1);
            used[i]=0;
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums= {1, 2, 3};
        System.out.println(new Solution_46().permute(nums));
    }
}
