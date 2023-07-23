package codesuixiang.HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) resSet.add(i);
        }
        int[] resArray = new int[resSet.size()];
        int i = 0;
        for (Integer integer : resSet) {
            resArray[i++] = integer;
        }
        return resArray;
        
        // 利用stream流将set转换到array
//        return resSet.stream().mapToInt(s -> s).toArray();
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2};
        int[] array = new Solution_349().intersection(nums1, nums2);
        System.out.println(Arrays.toString(array));
    }
}
