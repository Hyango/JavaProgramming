package codesuixiang.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class _Solution_93 {
    /* 分割IP地址 */
    List<String> result;
    List<String> path;
    
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0);
        return result;
    }
    
    private void backtracking(String s, int startIndex) {
        //1. 回溯结束条件
        if (startIndex >= s.length() && path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String s1 : path) {
                sb.append(s1).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        //2. 单层逻辑
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {//分割有效
                path.add(s.substring(startIndex, i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            } else break;//分割无效
        }
        return;
    }
    
    private boolean isValid(String s, int start, int end) {
        if (s.charAt(start) - '0' == 0 && end - start >= 1)
            return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            num *= 10;
            num += s.charAt(i) - '0';
        }
        if (num > 255)
            return false;
        return true;
    }
    
    
    public static void main(String[] args) {
    String s = "25525511135";
        System.out.println(new _Solution_93().restoreIpAddresses(s));
    }
}
