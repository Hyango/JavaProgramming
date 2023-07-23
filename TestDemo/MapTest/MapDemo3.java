package TestDemo.MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo3 {
    public static void main(String[] args) {
        //Map第三种遍历方式lamda forEach
        Map<String, String> map = new HashMap<>();
        map.put("政治", "111");
        map.put("历史", "222");
        map.put("地理", "333");
        
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + " " + value);
            }
        });
        
        System.out.println("-----lamda-----");
        map.forEach((key, value) -> System.out.println(key + " " + value));
    
        System.out.println();
        System.out.println(map);
    }
}
