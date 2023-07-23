package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class _Solution_131 {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0);
        
        return result;
    }
    private void backtracking(String s, int startIndex) { //startIndex指向的是每一个分割子串的头部
        //1.回溯结束条件: startIndex指向尾巴的时候,已经分割完了
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //2. 单层逻辑
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i+1));
            } else continue;
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }
    // 也可参考Solution_647,利用dp创建回文数组
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new _Solution_131().partition(s));
    }
    
    
    /*该写法返回的是可能得回文子串,而不是分割方案*/
/*    private void backtracking(String s, int startIndex) {
        //1.回溯结束条件
        if (path.size() == s.length())
            return;

        //2. 单层逻辑
        StringBuilder sb=new StringBuilder();
        for (Character character : path) {
            sb.append(character);
        }
        if (isPalindrome(sb.toString())) {
            List<String> temp = new ArrayList<>();
            temp.add(sb.toString());
            result.add(temp);
        }

        for (int i = startIndex; i < s.length(); i++) {
            path.add(s.charAt(i));
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }*/
}
