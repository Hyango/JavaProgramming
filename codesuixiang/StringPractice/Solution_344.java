package codesuixiang.StringPractice;

public class Solution_344 {
    public void reverseString(char[] s) {
        int left=0;
        int right= s.length-1;
        char temp;
        while (left < right) {
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        return;
    }
    
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        new Solution_344().reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
        
    }
    
}
