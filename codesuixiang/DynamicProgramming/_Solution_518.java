package codesuixiang.DynamicProgramming;

public class _Solution_518 {
    public int change(int amount, int[] coins) {
        //完全背包问题
        //1.dp[0]初始化为1.若为0.之后所有都将为0，
        //2.先遍布物品再遍历背包容量.dp[j] = dp[j] + dp[j - coins[i]]
        //等式右侧解释：
        //dp[j]：不放"当前这枚"coins[i]时，装满背包的方法数，
        //dp[j- coins[i]]：要放"当前这枚"coins[i]时，放入后能使装满背包的方法数
        //为什么说"当前这枚"呢？
        //因为更新后的dp[j](等式左边)包括了放入coins[i]的方法数.
        //当背包容量为j + coins[i]时，dp[j + coins[i]] = dp[j + coins[i]] + dp[j]. 此时又放入了一枚coins[i].
        //也即完全背甩问题可以多次放入同一物品
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(new _Solution_518().change(amount, coins));
    }
}
