package codesuixiang.DynamicProgramming;

public class Solution_1049 {
    
    public int lastStoneWeightII(int[] stones) {
        //这道题看出是背包问题比较有难度
        //最后一块石头的重量：从一堆石头中,每次拿两块重量分别为x,y的石头,
        //若x=y,则两块石头均粉碎;
        //若x<y,两块石头变为一块重量为y-x的石头求最后剩下石头的最小重量(若没有剩下返回0)
        //问题转化为：把一堆石头分成两堆,求两堆石头重量差最小值
        //进一步分析：要让差值小,两堆石头的重量都要接近sum/2;
        //          我们假设两堆分别为A,B,A<sum/2,B>sum/2,若A更接近sum/2,B也相应更接近sum/2
        //进一步转化：将一堆stone放进最大容量为sum/2的背包,求放进去的石头的最大重量MaxWeight,
        //          最终答案即为sum-2*MaxWeight;、
        //0/1背包最值问题：外循环stones,内循环target=sum/2倒序,应用转移方程1
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        
        int target = sum / 2; //背包最大容量,此处向下取整
        int length = stones.length;
        int[] dp = new int[target + 1];
        //初始化
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
    
    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println(new Solution_1049().lastStoneWeightII(stones));
    
    }
}
