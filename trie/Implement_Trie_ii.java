package trie;

public class Implement_Trie_ii {
    public static void main(String[] args) {
        Trie1 obj = new Trie1();
        obj.insert("coding");
        obj.insert("coding");
        obj.insert("ninja");
        obj.insert("nin");
        System.out.println(obj.countWordsEqualTo("coding"));
        System.out.println(obj.countWordsStartingWith("nin"));
        obj.erase("coding");

    }
}
class Trie1 {
    TrieNode_ii root;

    public Trie1() {
        // Write your code here.
        root = new TrieNode_ii();
    }

    public void insert(String word) {
        // Write your code here.
        TrieNode_ii temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char curCh = word.charAt(i);
            if (!temp.containsKey(curCh)) {
                temp.put(curCh, new TrieNode_ii());
            }
            // move to the node of the curCh
            temp = temp.get(curCh);
            temp.increaseCntPrefix();
        }
        temp.increaseEndWith();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        TrieNode_ii temp = root;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char curCh = word.charAt(i);
            if (!temp.containsKey(curCh)) {
                return 0;
            }
            // move to the node of the curCh
            temp = temp.get(curCh);
        }
        return temp.getEndWith();
    }

    public int countWordsStartingWith(String prefix) {
        // Write your code here.
        TrieNode_ii temp = root;
        int n = prefix.length();

        for (int i = 0; i < n; i++) {
            char curCh = prefix.charAt(i);
            if (!temp.containsKey(curCh)) {
                return 0;
            }
            // move to the node of the curCh
            temp = temp.get(curCh);
        }
        return temp.getCntPrefix();
    }

    public void erase(String word) {
        // Write your code here.

        // the word to be deleted is guaranteed to be present in the tree
        TrieNode_ii temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char curCh = word.charAt(i);
            // move to the node of the curCh
            temp = temp.get(curCh);
            temp.decreaseCntPrefix();
        }
        temp.decreaseEndWith();
    }
}

class TrieNode_ii {
    TrieNode_ii[] links;
    int endWith;
    int cntPrefix;

    public TrieNode_ii() {
        links = new TrieNode_ii[26];
        endWith = 0;
        cntPrefix = 0;
    }

    // check if the node exists
    boolean containsKey (char ch) {
        return links[ch - 'a'] != null; // will return true if the links array contains the element
    }

    // insert the node inside the array
    void put (char ch, TrieNode_ii node) {
        links[ch - 'a'] = node;
    }

    // get the node with a specific key (letter) from the Trie
    TrieNode_ii get(char ch) {
        return links[ch - 'a'];
    }


    // to get the count
    int getCntPrefix() {
        return cntPrefix;
    }

    // increase the count
    void increaseCntPrefix() {
        cntPrefix += 1;
    }

    // decrease the count
    void decreaseCntPrefix() {
        cntPrefix -= 1;
    }

    // increase endWith
    void increaseEndWith () {
        endWith += 1;
    }

    // decrease endWith
    void decreaseEndWith () {
        endWith -= 1;
    }

    // returns the endWith
    int getEndWith() {
        return endWith;
    }
}


