package codesuixiang.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        //利用哈希表找target-x,  key存放元素值, value存放下标
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i]))
                //如果存在另一个值,则返回 另一个值的索引和当前值的索引 组成的数组
                return new int[]{hm.get(target - nums[i]), i};
            else hm.put(nums[i], i);
        }
        return new int[0];
    }
    
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=13;
        int[] res=new Solution_1().twoSum(nums,target);
        //Arrays.toString()将数组转换成字符串
        System.out.println(Arrays.toString(res));
    }
    
}
