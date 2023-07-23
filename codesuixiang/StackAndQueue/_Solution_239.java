package codesuixiang.StackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _Solution_239 {
    //单调队列
    //原理：
    //① 将滑动窗口的值依次放入队列、
    //② 若新放入的元素值比队内元素值大，则将所有比该元素值小的元素出队
    //   (因为只要这个元素值还在滑动窗口内，那么比它先进队列且比他小的一定不会成为滑动窗口最大值)
    //③ 每次移动滑动窗口，判断队头元素是否还在窗口内，不在则出队。
    //④ 此时队头元素为滑动窗口最大值
    
    //代码过程：  为了方便，队列中维护元素下标.
    //1. 将前k个元素依次加入队列(队列中是元素下标)，保证单调(根据元素值排序)
    //      P1:若新加入元素值比队内元素值大，则队内比他小的元素值出队，新元素(下标)入队
    //2. 遍历[k，nums.length)元素.
    //      2.1 过程如P1
    //      2.2 判断队头元素是否在窗中,不在则出队
    //      2.3 此时队头元素为窗口内最大值,将值保存
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        res[0] = nums[deque.getFirst()];
        
        for (int i = k; i < length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.pollLast();
            deque.offerLast(i);
            while (deque.getFirst() < i - k + 1) //队头已不再滑动窗口中
                deque.pollFirst();
            res[i - k + 1] = nums[deque.getFirst()];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = new _Solution_239().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
