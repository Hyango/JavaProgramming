package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    
    public static int lengthOfLongestSubstring(String s) {
        //用一个哈希表记录子串中每个元素的最后一次出现的位置
        //两个指针用于滑动窗口,一次遍历得到结果
        Map<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //如果字符出现在表里,则left移至 该字符最后一次出现的位置的后一位;
            if (hm.containsKey(ch)) {
                start = Math.max(hm.get(ch) + 1,start);//如果遇到字符串外的字符不能回退
            }
            hm.put(ch, i);
            maxLength = Math.max(i - start + 1, maxLength);
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
