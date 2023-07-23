package leetcode.hot100;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//Solution_146
public  class LRUCacheTest{
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else if (map.size() == capacity) {//map中不存在key,但map已满
            Iterator<Integer> iterator = map.keySet().iterator();
            iterator.next();
            iterator.remove();
            map.put(key,value);
        } else {//map不存在key,且map未满
            map.put(key,value);
        }
    }
}
