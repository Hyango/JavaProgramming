package codesuixiang.HashTable;

public class Solution_242 {
    public boolean isAnagram(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS != lengthT) return false;
        
        int[] count =new int[26];
        for (int i = 0; i < lengthS; i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i]!=0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new Solution_242().isAnagram(s, t));
    }
}
