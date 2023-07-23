package codesuixiang.StringPractice;
//剑指offer-58
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        res.append(s, n, s.length());
        res.append(s, 0, n);
        return res.toString();
    }
    
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
    
    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        System.out.println(new Offer_58().reverseLeftWords(s, n));
    }
}
