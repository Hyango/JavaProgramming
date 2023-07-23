package codesuixiang.ArraysPractice;

public class _Solution_209 {
    //滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int startIndex = 0, endIndex = 0;
        int sum = 0;
        int subLength = Integer.MAX_VALUE;
        for (; endIndex < length; endIndex++) {
            sum += nums[endIndex];
            while (sum >= target) {
                subLength = Math.min(subLength, endIndex - startIndex + 1);
                sum -= nums[startIndex];
                startIndex++;
            }
        }
        return subLength == Integer.MAX_VALUE ? 0 : subLength;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int target = 10;
        System.out.println(new _Solution_209().minSubArrayLen(target, nums));
    }
}
