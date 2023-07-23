package leetcode.hot100;

import java.util.Arrays;

public class Solution_338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                res[i] = res[i / 2];
            else
                res[i] = res[i - 1] + 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int n=5;
        int[] res = new Solution_338().countBits(n);
        String s = Arrays.toString(res);
        System.out.println(s);
    }
}
