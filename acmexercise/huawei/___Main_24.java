package acmexercise.huawei;

import java.util.Scanner;

public class ___Main_24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = in.nextInt();
            }
            
            int maxHeight = 0;
            int maxHeightIndex = -1;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > maxHeight)
                    maxHeightIndex = i;
            }
            
            // maxHeightIndex为中心,计算最长递增/递减子序列的长度. dp
            
        }
    }
}

/**
 * 描述
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次递减的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * 注意：不允许改变队列元素的先后顺序 且不要求最高同学左右人数必须相等
 * 数据范围： 1≤n≤3000
 *
 * 思路：分别找到每个同学的左边最长递增子序列，右边最长递减子序列
 */
/*
public class HJ24_dp最长递增or递减子序列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] stu=new int[n];
        int[] left=new int[n];
        int[] right=new int[n];
        for (int i = 0; i < n; i++) {
            stu[i]=sc.nextInt();
        }
        //左边最长递增子序列
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++) {
                if (stu[i]>stu[j])
                    left[i]=Math.max(left[i],left[j]+1);
            }
        }
        //右边最长递减子序列
        for (int i = n-1; i >=0; i--){
            for (int j = n-1; j >i; j--) {
                if (stu[i]>stu[j])
                    right[i]=Math.max(right[i],right[j]+1);
            }
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            if(right[i]+left[i]>max)
                max=right[i]+left[i];
        }
        System.out.println(n-max-1);
    }*/
