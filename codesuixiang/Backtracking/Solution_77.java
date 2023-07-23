package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> tmp = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
    
    public void backtracking(int n, int k, int startIndex) {//确定参数表
        //回溯终止条件
        if (tmp.size() == k) {
            //必须新创建一个list保存tmp,然后加入result中.
            // 否则会因为每次添加的都是tmp的地址值,最后result中所有元素都相同
            result.add(new ArrayList<>(tmp));
            return;
        }
        //单层搜索过程
        for (int i = startIndex; i <= n; i++) {
            tmp.add(i);
            backtracking(n, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution_77().combine(4, 2));
    }
}
