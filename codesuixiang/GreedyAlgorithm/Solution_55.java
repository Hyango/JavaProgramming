package codesuixiang.GreedyAlgorithm;

public class Solution_55 {
    public boolean canJump(int[] nums) {
        //定义一个cover,用于存储所能到达最远的位置
        //遍历数组,结束条件为 i<=cover. 不断更新cover,当cover>=nums.length时,返回true
        int cover = 0;
        int length=nums.length;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= length - 1) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution_55().canJump(nums));
    }
}
