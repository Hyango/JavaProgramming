package acmexercise.huawei;

import java.util.Scanner;

public class ___Main_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt(); // 总钱数
            int m = in.nextInt(); // 物品购买总件数
            int[] v = new int[m]; // 表示该物品的价格(v<10000)
            int[] p = new int[m]; // 表示该物品的重要度(1 ~ 5)
            int[] q = new int[m]; //  q=0,表示该物品为主件. q>0,表示所属主件的编号
            for (int i = 0; i < m; i++) {
                v[i]=in.nextInt();
                p[i]=in.nextInt();
                q[i]=in.nextInt();
            }
            
            
            
        }
    }
}
