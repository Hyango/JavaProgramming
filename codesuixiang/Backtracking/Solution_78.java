package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> tmp= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null) return list;
        backtracking(nums,0);
        return list;
    }

    public void backtracking(int[] nums,int startIndex){ //确定参数
        //由于是获取子集,所以递归树上每一次的结果都需要保存. 而不仅仅是到达叶子节点时保存
        list.add(new ArrayList<>(tmp));
        //确定终止条件. 终止条件可不加,因为此时的for语句因不满足条件而无法执行
        if(startIndex>=nums.length) return;
        //单层搜索方式
        for (int i = startIndex; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Solution_78().subsets(nums));
    }
}
