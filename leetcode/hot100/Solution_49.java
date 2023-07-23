package leetcode.hot100;

import java.util.*;

public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 对每一个字符串排序, 异位词的排序结果是相同的. 将排序后的结果作为key, 原词加入value
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }
        ArrayList<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
    
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution_49().groupAnagrams(strs));
    
    }
}
