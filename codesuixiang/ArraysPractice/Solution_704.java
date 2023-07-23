package codesuixiang.ArraysPractice;

public class Solution_704 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(new Solution_704().search(nums, target));
    }
}
