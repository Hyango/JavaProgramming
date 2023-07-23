package codesuixiang.StringPractice;

public class RepeatedSubstringPattern {
    //KMP方法.
    // 若字符串由重复的子串构成,那么其next数组形式为(以abcabcabc为例):0,0,0,1,2,3,4,5,6
    // 所以有: 字符串的长度 - 字符串最后一个字符的最长公共前后缀的长度 = 子串长度, 字符串的长度%子串长度为==0
    // 充分性:若为重复子串构成,则比满足上述结果.
    // 必要性:难证明.只能画图穷举....
    public static void getNext(int[] next, String s) {
        int j = 0;//指向前缀尾
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
    
    public static boolean repeatedSubstringPattern(String s) {
        int[] next=new int[s.length()];
        getNext(next,s);
        int len=s.length();
        if(next[len - 1] != 0 && len % (len - (next[len - 1] )) == 0){ //注意next[len - 1] != 0,如果等于0,后面的表达式也必等于0;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(repeatedSubstringPattern(s));
    
    }
    
    
    //leetcode 题解方法
    public boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s); //注意substring的范围,需要掐头去尾,否则直接就含有原字符串
    }
}
