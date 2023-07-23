package codesuixiang.StringPractice;
// KMP
// leetcode-28

public class KMP_Solution_28 {
    // 自己写
    public static void getNext(int[] next, String s) { //与真实手动计算的前缀表一致,不做其他后处理(右移,减1等).
        int j = 0; //j 指向 前缀末尾, 随后定义的i 指向 后缀末尾
        next[0] = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {//字符不匹配,则j往左移动找可能得匹配点. j>0防止下一行的j-1溢出,无其他作用.
                j = next[j - 1];    //  即找可能得匹配点(前一位的对应的回退位置)
            }
            if (s.charAt(i) == s.charAt(j)) {//字符匹配,j++,既表示了更新后的子串长度,又同时更新了j的指向
                j++;
            }
            next[i] = j; // 此时j的位置下标即为 i对应的字符作为后缀尾 的最长相等前后缀的长度.
        }
    }
    
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) { //i指向文本串,  j指向模式串.
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {   //不匹配,则回退
                j = next[j - 1]; //回退一下
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j - 1 == needle.length() - 1) { //j-1指向了模式串的末尾,匹配完成
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(new KMP_Solution_28().strStr(haystack, needle));
    }
    
    
    // leedcode题解
    public static int strStr1(String ss, String pp) {
        // KMP 算法
        // ss: 原串(string)  pp: 匹配串(pattern)
        if (pp.isEmpty()) return 0;
        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;
        
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        
        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1]; //追加一个空格（哨兵）。目的是让 j 下标从 0 开始，省去 j 从 -1 开始的麻烦。
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }
        return -1;
    }
}
