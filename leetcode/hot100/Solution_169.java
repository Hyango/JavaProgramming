package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution_169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int halfCount = nums.length / 2;
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
            if (count > halfCount) {
                res = num;
                break;//多数元素只会有一个,找到即可停止遍历
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums={3,2,3};
        System.out.println(new Solution_169().majorityElement(nums));
    
    }
}
