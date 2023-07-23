package codesuixiang.StringPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
    
    
    //leetcode题解做法
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
    
    public static void main(String[] args) {
        String s = "  hello  world  ";
        System.out.println(new Solution_151().reverseWords(s));
    }
}
