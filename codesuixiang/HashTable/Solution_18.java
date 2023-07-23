package codesuixiang.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {
    //四数之和
    //与三数之和(ThreeSum)同理
    //使用四个指针(i<j<L<R)。固定最小的i,j在左边，L=j+1,R=_size-1 移动两个指针包夹求解。
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //注意是j>i+1,如果从j>0开始,可能忽略起始状态
                int Left = j + 1, Right = length - 1;
                while (Left < Right) {
                    long sum = (long) nums[i] + nums[j] + nums[Left] + nums[Right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[Left], nums[Right]));
                        while (Left < Right && nums[Left] == nums[Left + 1]) Left++;
                        while (Left < Right && nums[Right] == nums[Right - 1]) Right--;
                        Left++;
                        Right--;
                    } else if (sum > target) {
                        Right--;
                    } else {
                        Left++;
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int target = -294967296;
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> res = fourSum(nums, target);
        //输出方式1
        System.out.println(res.toString());
        
    }
}
