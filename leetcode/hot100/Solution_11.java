package leetcode.hot100;

public class Solution_11 {
    public int maxArea(int[] height) {
        //双指针法,指向头尾.  S(i,j)=min(h[i],h[j])×(j−i)
        //在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽底边宽度-1变短
        //若向内移动短板 ，水槽的短板min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
        //若向内 移动长板 ，水槽的短板min(h[i],h[j])不变或变小，因此下个水槽的面积 一定变小 。
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[i] < height[j]) {
                result = Math.max(result, height[i] * (j - i));
                i++;
            } else {
                result = Math.max(result, height[j] * (j - i));
                j--;
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution_11().maxArea(height));
    }
}
