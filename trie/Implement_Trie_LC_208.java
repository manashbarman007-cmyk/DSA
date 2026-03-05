package trie;

public class Implement_Trie_LC_208 {
    public static void main(String[] args) {

    }
}
class Trie {
TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char curCh = word.charAt(i);
            if (!temp.containsKey(curCh)) {
                temp.put(curCh, new TrieNode()); // new TrieNode() will be the child node for temp
            }
            // now we need to move temp to the node of curCh
            temp = temp.get(curCh);
        }
        // set the temp.flag as true
        temp.setEnd();
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            char curCh = word.charAt(i);
            if (!temp.containsKey(curCh)) {
                return false;
            }
            // move the temp to the node of curCh
            temp = temp.get(curCh);
        }
        return temp.isEnd();
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            char curCh = prefix.charAt(i);
            if (!temp.containsKey(curCh)) {
                return false;
            }
            // move to the node of curCh
            temp = temp.get(curCh);
        }

        // ie the prefix is found
        return true;
    }
}

class TrieNode {
    TrieNode[] links;
    boolean flag;

    public TrieNode() {
        links = new TrieNode[26];
        flag = false;
    }

    // check if the node exists
    boolean containsKey (char ch) {
        return links[ch - 'a'] != null; // will return true if the links array contains the element
    }

    // insert the node inside the array
    void put (char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    // get the node with a specific key (letter) from the Trie
    TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    // set the flag as 'true' when the word ends
    void setEnd() {
        flag = true;
    }

    boolean isEnd () {
        return flag; // returns the value of the flag
    }
}
