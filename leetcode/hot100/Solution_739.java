package leetcode.hot100;

import java.util.Arrays;
import java.util.Stack;

public class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 维护一个单调递减栈, 排序规则为元素值, 栈内存放的是元素下标
        // 若新加入的元素值大于栈顶元素, 则栈顶元素出栈,栈顶元素与新加入元素的下标查即为所求结果.
        // 循环比较栈顶元素,直至栈顶元素大于新加入的元素值.
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // 遍历每个元素
        for (int i = 0; i < temperatures.length; i++) {
            // 栈不为空 且 新加入元素>栈顶元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int peekIndex = stack.peek();
                res[peekIndex] = i - peekIndex;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = new Solution_739().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    
    }
}
