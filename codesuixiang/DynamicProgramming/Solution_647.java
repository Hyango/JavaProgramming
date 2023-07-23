package codesuixiang.DynamicProgramming;

public class Solution_647 {
    public int countSubstrings(String s) {
        //1. 定义布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        //2. 状态转移方程: 当s[i] = s[j], dp[i][j] = dp[i+1][j-1];
        //              否则,dp[i][j]=false
        //    注:由于就j>=i,所以只需要状态转移图的右上部分
        //3. 初始化,状态转移图可知,需要初始化的元素为dp[i][i]和dp[i][i+1].
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;
        //初始化dp
        for (int i = 0; i < length; i++) {
            count++;
            dp[i][i] = true; //dp[i][i]表示单个元素,一定属于回文串
            if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                dp[i][i + 1] = true; //相邻两个元素相同,一定属于回文串
            }
        }
        //状态转移方程,从初始化可知,dp更新时i从length-3开始, j从i+2开始.
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1]) {
                        count++;
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Solution_647().countSubstrings(s));
    }
    
}
