package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution_136 {
    public static int singleNumber(int[] nums) {
        //哈希法
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num : nums) {
            Integer count=map.get(num);
            if (count==null) count=1;
            else count=2;
            map.put(num,count);
        }
        for (Integer num : nums) {
            if(map.get(num)==1)
                return num;
        }
        return Integer.MIN_VALUE;//没找到
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 5};
        System.out.println(singleNumber(nums));
    }
    
    //位运算方法
    public static int singleNumber1(int[] nums) {
        //交换律：a ^ b ^ c <=> a ^ c ^ b
        //任何数于0异或为任何数 0 ^ n => n
        //相同的数异或为0: n ^ n => 0
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
