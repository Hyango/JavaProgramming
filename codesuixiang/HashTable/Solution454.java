package codesuixiang.HashTable;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        //求nums1,nums2和为temp的次数
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp))
                    map.put(temp, map.get(temp) + 1);
                else map.put(temp, 1);
            }
        }
        //若nums3与nums4和为-temp,则获取次数
        int count=0;
        for (int i : nums3) {
            for (int j : nums4) {
                temp=i+j;
                if(map.containsKey(-temp))
                   count+=map.get(-temp);
            }
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-1,-2};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        System.out.println(new Solution454().fourSumCount(nums1, nums2, nums3, nums4));
    
    }
}
