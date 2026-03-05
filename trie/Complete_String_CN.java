package trie;

import java.util.Arrays;

public class Complete_String_CN {
    static TrieStr trie = new TrieStr();

    public static void main(String[] args) {
        String[] str = {"ab", "abc", "a", "bp"};
        System.out.println(completeString(4, str));
    }

    public static String completeString(int n, String[] a) {
        // Write your code here.

        // insert all the strings in the trie
        for (int i = 0; i < n; i++) {
            trie.insert(a[i]);
        }

        String completeString = "";

        for (int i = 0; i < n; i++) {
            String curString = a[i];
            if (trie.checkIfAllPrefixExists(curString)) {
                if (curString.length() > completeString.length()) {
                    completeString = curString;
                }
                else if (curString.length() == completeString.length() && curString.compareTo(completeString) < 0){
                    // if the curString is lexicographically smaller but has
                    //  the same length
                    completeString = curString; // reset is to empty
                }
            }
        }

        if (!completeString.isEmpty()) return completeString;
        return "None";
    }
}

class TrieStr {
    TrieNode root;

    public TrieStr() {
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

    public boolean checkIfAllPrefixExists(String word) {
        int n = word.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            char curCh = word.charAt(i);
            if (temp.containsKey(curCh)) {
                temp = temp.get(curCh); // go to the node of curCh
                if (!temp.isEnd()) {
                    return false;
                }
            }
            // the trie does not contain curCh
            else return false;
        }
        return true;
    }
}
