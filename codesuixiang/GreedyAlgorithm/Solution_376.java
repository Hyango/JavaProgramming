package codesuixiang.GreedyAlgorithm;

public class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        //将数值画在坐标系中,划线连接.同一坡度(左开,右闭]上的数值其标记(up down值)相同
        if (nums.length<2) return nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(up,down);
    }
    
    public static void main(String[] args) {
        int[] nums ={1,7,4,9,2,5};
        System.out.println(new Solution_376().wiggleMaxLength(nums));
    }
}
