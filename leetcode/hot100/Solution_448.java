package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(new Solution_448().findDisappearedNumbers(nums));
    }
}
