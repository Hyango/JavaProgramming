package codesuixiang.HashTable;

public class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int lengthR = ransomNote.length();
        int lengthM = magazine.length();
        if (lengthR > lengthM) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < lengthM; i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lengthR; i++) {
            count[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] < 0)
                return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        String ransomNote = "bg", magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        System.out.println(new Solution_383().canConstruct(ransomNote, magazine));
    }
}
