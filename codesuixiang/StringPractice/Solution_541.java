package codesuixiang.StringPractice;

public class Solution_541 {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int start = 0;
        while (start < s.length()) {
            if (start + k <= s.length()) { //剩余长度 >= k,翻转
                StringBuilder temp = new StringBuilder(s.substring(start, start + k));
                res.append(temp.reverse());
                if (start + 2 * k < s.length()) {//剩余长度>2k,直接拼接k-2k
                    res.append(s, start + k, start + 2 * k);
                } else {//剩余长度k~2k,直接拼接k后部分
                    res.append(s, start + k, s.length());
                }
            } else {//剩余长度 < k,反转拼接
                StringBuilder temp = new StringBuilder(s.substring(start, s.length()));
                res.append(temp.reverse());
            }
            
            start = start + 2 * k;
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        int k = 8;
        String s = "abcdefg";
        String res = new Solution_541().reverseStr(s, k);
        System.out.println(res);
    }
}
