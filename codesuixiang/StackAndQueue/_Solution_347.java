package codesuixiang.StackAndQueue;

import java.util.*;

public class _Solution_347 {
    //PriorityQueue可用作大顶堆.Comparator中按元素出现次数排序
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //将map中的键值对放入PriorityQueue,并按出现次数排序(从大到小,即大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int[] temp = new int[]{entry.getKey(), entry.getValue()};
            pq.add(temp);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int[] res = new _Solution_347().topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
        
    }
    
    public int[] topKFrequent1(int[] nums, int k) {
        //Warning:
        //使用TreeSet,由于Set的特性,当比较器返回值为0时,元素不会被加入Set中.
        //因此,按照此处代码的比较规则,两个元素的出现次数一样时,新的元素不会被加入TreeSet. 如nums = {1, 2, 3},k=2,代码将报错
        //除了此处,代码无其他问题.
        Map<Integer, Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for (int num : nums) {
//            if (map.containsKey(num))
//                map.put(num, map.get(num) + 1);
//            else map.put(num, 1);
            
            //上面三句可合并为如下语句.
            //map.getOrDefault(num,0):如果num存在则返回value,不存在就返回0;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //将map中的键值对放入treeset,并按出现次数排序(从大到小)
        TreeSet<int[]> ts = new TreeSet<>((o1, o2) -> o2[1] - o1[1]);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int[] temp = new int[]{entry.getKey(), entry.getValue()};
            ts.add(temp);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = ts.first()[0];
            ts.remove(ts.first());
        }
        return res;
    }
}
