package leetcode.hot100;

public class Solution_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}

class Trie {
    //实现Trie(前缀树)
    private Trie[] children;
    private boolean isEnd;//指示以前一个节点字母为结尾的串是否为单词
    
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new Trie();
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie cur=this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie cur=this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return true;
    }
}