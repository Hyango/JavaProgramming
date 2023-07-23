package acmexercise.huawei;

import java.util.Scanner;

public class _Main_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sqrtN = (int) Math.sqrt(n);
            // 从2开始，找到的第一个N%i==0的i为a1，首先a1一定是质数，因为假如a1是合数的话在2和a1之间一定存在其他N可以整除的质数，
            // 但是i是从2开始找到的第一个可以整除的数，因此i只能是质数，也就是说i是N最小的质因子
            for (int i = 2; i <= sqrtN; i++) {
                while (n % i == 0) {
                    System.out.print(i + " ");
                    n /= i;
                }
            }
            if (n!=1)
                System.out.print(n);
        }
    }
}
