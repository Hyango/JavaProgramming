package codesuixiang.HashTable;

import java.util.HashSet;
import java.util.Set;

public class Solution_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }
    
    private int getNextNum(int n) {
        int res = 0;
        int temp;
        while (n != 0) {
            temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new Solution_202().isHappy(n));
    }
    
    
}
