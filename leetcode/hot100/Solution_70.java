package leetcode.hot100;

public class Solution_70 {
    
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[46]; //题目给了n<=45,若需要动态调整,改用ArrayList
        dp[1] = 1;
        dp[2] = 2;
        //到达地n阶楼梯,必须从n-1阶或者n-2阶上去,那么总方法是到达n-1阶楼梯的方法和到达n-2阶楼梯方法之和
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n=45;
        System.out.println(climbStairs(n));
    }
}
