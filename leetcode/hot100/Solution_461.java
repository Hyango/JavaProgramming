package leetcode.hot100;

public class Solution_461 {
    
    public static int hammingDistance(int x, int y) {
        int count = 0;
        int temp = x ^ y;
        while (temp != 0) {
            count += temp & 1;
            temp = temp >> 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
