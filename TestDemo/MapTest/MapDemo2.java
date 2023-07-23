package TestDemo.MapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        //Map第二种遍历方式map.entrySet()
        Map<String, String> map = new HashMap<>();
        map.put("物理", "111");
        map.put("化学", "222");
        map.put("生物", "333");
        
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //下面不加Map. 需要调包 import java.util.Map.Entry;
        //Set<Entry<String,String>> entries = map.entrySet();
        //增强for
        System.out.println("-------增强for-------");
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);
            
        }
        
        //迭代器实现
        System.out.println("-------迭代器实现-------");
        Iterator<Map.Entry<String, String>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);
        }
        
        //lamda实现
        System.out.println("-------lamda实现-------");
        entries.forEach(stringStringEntry -> {
                    String key = stringStringEntry.getKey();
                    String value = stringStringEntry.getValue();
                    System.out.println(key + " " + value);
                }
        );
    }
}
