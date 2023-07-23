package codesuixiang.GreedyAlgorithm;

import java.util.Arrays;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        //从胃口最小的开始喂
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {//喂饱了
                j++;
                i++;
                count++;
            }else j++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] g={10,9,8,7};
        int[] s={5,6,7,8};
        System.out.println(new Solution_455().findContentChildren(g, s));
    }
}
