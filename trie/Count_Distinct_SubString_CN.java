package trie;

public class Count_Distinct_SubString_CN {
    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("abc"));
    }
    public static int countDistinctSubstrings(String s)
    {
        //	  Write your code here.
        TrieDistinct trie = new TrieDistinct();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            trie.insert(s.substring(i));
        }
        return 1 + trie.count; // 1 + as we consider the empty string as well
    }
}

class TrieDistinct {
    int count;
    TrieNodeCount root;

    public TrieDistinct() {
        root = new TrieNodeCount();
        count = 0;
    }

    public void insert(String word) {
        int n = word.length();
        TrieNodeCount temp = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!temp.containsKey(ch)) {
                temp.put(ch, new TrieNodeCount()); // create a new node for ch
                count++;
            }
            temp = temp.get(ch); // move to the node of ch
        }
    }
}

class TrieNodeCount {
    TrieNodeCount[] links;

    public TrieNodeCount() {
        links = new TrieNodeCount[26];
    }

    void put(char ch, TrieNodeCount node) {
        links[ch - 'a'] = node;
    }

    TrieNodeCount get(char ch) {
        return links[ch - 'a'];
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
}