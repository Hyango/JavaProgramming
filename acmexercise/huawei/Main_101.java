package acmexercise.huawei;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main_101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();//接收数组长度
            Integer[] arr = new Integer[n];//创建数组
            
            for (int i = 0; i < n; i++) {//数组填入
                arr[i] = in.nextInt();
            }
            
            int flag = in.nextInt();//接收排序标识
            Arrays.sort(arr,(o1,o2)->{return o1-o2;});//数组排序
            
            if (flag == 0) {//正序输出
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else { //逆序输出
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
}
