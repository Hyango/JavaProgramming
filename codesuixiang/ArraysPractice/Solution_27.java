package codesuixiang.ArraysPractice;

public class Solution_27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int slowIndex = 0, fastIndex = 0;
        while (slowIndex < length && fastIndex < length) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        return slowIndex;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(new Solution_27().removeElement(nums, val));
    }
}
