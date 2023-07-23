package codesuixiang.StringPractice;

//剑指offer-05
public class Offer_05 {
    public static String replaceSpace(String s) {
        String res = s.replace(" ", "%20");
        return res;
    }
    
    public static String replaceSpace1(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') res.append("%20");
            else res.append(s.charAt(i));
        }
        return res.toString();
    }
    
    public static String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
    
    
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace2(s));
    }
}
