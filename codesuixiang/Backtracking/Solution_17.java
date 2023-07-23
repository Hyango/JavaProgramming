package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_17 {
    static List<String> list = new ArrayList<>();
    static StringBuilder str=new StringBuilder();
    static final String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return list;
        backtracking(digits,0);
        return list;
    }
    
    public void backtracking(String digits, int index) {//确定参数
        //确定结束条件
        if (index == digits.length()) {
            list.add(str.toString());
            return;
        }
        //单层搜索方式
        int num = digits.charAt(index) - '0';
        String letter = letterMap[num];
        for (int i = 0; i < letter.length();i++){
            str.append(letter.charAt(i));
            backtracking(digits,index+1);
            str.deleteCharAt(str.length()-1);
        }
    }
    
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new Solution_17().letterCombinations(digits));
    }
}
