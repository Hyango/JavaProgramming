package TestDemo.MapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        //Map第一种遍历方式map.keySet()
        Map<String, String> map = new HashMap<>();
        map.put("语文", "111");
        map.put("数学", "222");
        map.put("英语", "333");
        
        Set<String> keys = map.keySet();
        //增强for
        System.out.println("-------增强for-------");
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
        
        //迭代器实现
        System.out.println("-------迭代器实现-------");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
        
        //lamda实现
        System.out.println("-------lamda实现-------");
        keys.forEach(s -> System.out.println(s + " " + map.get(s)));
    }
}
