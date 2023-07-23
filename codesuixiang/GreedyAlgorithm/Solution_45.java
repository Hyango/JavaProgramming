package codesuixiang.GreedyAlgorithm;

public class Solution_45 {
    public int jump(int[] nums) {
        //每一次能跳到更远的地方都要立马跳过去.该思路错误,用例{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}无法通过.
        
        //正确思路:当一次 跳跃 结束时，从下一个格子开始，到现在 能跳到最远的距离，都 是下一次 跳跃 的 起跳点。
        int count = 0;
        int start = 0, end = 0;
        while (end < nums.length - 1) { //因为end从1开始,所以end=nums.length-1时就需要退出循环了.故此处不需要等于
            int maxPos = 0;
            for (int i = start; i <= end; i++) {
                //能跳到最远的距离
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end + 1;        //下一次跳跃范围开始的格子,其实是for循环中i结束的后一个位置
            end = maxPos;   //下一次起跳范围结束的格子
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(new Solution_45().jump(nums));
    }
}
