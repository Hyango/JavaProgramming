package codesuixiang.DynamicProgramming;

public class _Solution_392 {
    public boolean isSubsequence(String s, String t) {
        //DP
        //判断子序列,给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        //推广到:判断距离
        //作为例题,先从代码倒推: 2层for循环,循环外层为子序列s,内层为父序列(长序列)
        //1. 定义dp: dp[i][j]:s[i-1]和t[j-1]为结尾时,最长子序列的长度
        //2. 状态转移:
        //          当s[i-1]=t[j-1]时, 则此时子序列长度 = s[i-2]和t[j-2]结尾时最长子序列 + 1
        //              则dp[i][j]=dp[i-1][j-1]+1
        //          当s[i-1]!=t[j-1]时, 则s[0~i-1]和j[0~j-1]的最长子序列长度 等于 s[0~i-1]和j[0~j-2]的最长子序列长度.
        //              (注意: 为什么是s[0~i-1]和j[0~j-2] 而不是 s[0~i-2]和j[0~j-1]? 因为s才是子串!!仔细理解)
        //              则dp[i][j]=dp[i-2][j-1]
        int length1 = s.length();
        int length2 = t.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[length1][length2] == length1;
    }
    
    public boolean isSubsequence1(String s, String t) {
        //str.toCharArray() 和 str.indexOf()两参数的使用
        int index = -1;
        char[] ch=s.toCharArray();
        for (char c : ch){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new _Solution_392().isSubsequence(s, t));
    }
}
