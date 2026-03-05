package trie;
import java.util.*;
import java.util.stream.Collectors;

public class Max_XOR_With_An_Element_From_Array_CN {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 2, 5, 4));
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        ArrayList<Integer> sublist1 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> sublist2 = new ArrayList<>(Arrays.asList(5, 2));
        ArrayList<Integer> sublist3 = new ArrayList<>(Arrays.asList(2, 5));
        ArrayList<Integer> sublist4 = new ArrayList<>(Arrays.asList(3, -1));
        queries.add(sublist1);
        queries.add(sublist2);
        queries.add(sublist3);
        queries.add(sublist4);

        System.out.println(maxXorQueries(arr, queries));
    }
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        int n = arr.size();
        int m = queries.size();
        Triplet[] triplet = new Triplet[m];
        TrieBit2 trie = new TrieBit2();

        for (int i = 0; i < m; i++) {
            triplet[i] = new Triplet(queries.get(i).getFirst(), queries.get(i).getLast(), i);
        }

        // sort triplet based on 'Ai' in ascending order
        Arrays.sort(triplet, (a, b) -> a.Ai - b.Ai);

        // sort arr in ascending order
        Collections.sort(arr);

        Integer[] ans = new Integer[m];

        int ind = 0;
        for (int i = 0; i < m; i++) {
            while (ind < n) {
                if (arr.get(ind) <= triplet[i].Ai) {
                    trie.insert(arr.get(ind));
                }
                else {
                    break;
                }
                ind++;
            }
            int Xi = triplet[i].Xi;
            int max = (trie.root.containsKey(0) || trie.root.containsKey(1))? trie.getMaxXor(Xi) : -1;
            ans[triplet[i].index] = max;
        }
        return new ArrayList<>(Arrays.asList(ans));
    }
}

class TrieNodeBit2 {
    TrieNodeBit2[] links;

    public TrieNodeBit2() {
        links = new TrieNodeBit2[2]; // we will be storing 0 and 1
    }

    void put(int ind, TrieNodeBit2 node) { // ind is either 0 or 1
        links[ind] = node;
    }

    boolean containsKey(int ind) {
        return links[ind] != null;
    }

    TrieNodeBit2 get(int ind) {
        return links[ind];
    }
}

class TrieBit2 {
    TrieNodeBit2 root;

    public TrieBit2() {
        root = new TrieNodeBit2();
    }

    public void insert (int num) {
        TrieNodeBit2 temp = root;
        for (int i = 31; i >= 0; i--) { // for a 32-bit number we insert from MSB to LSB
            int bit = (num >> i) & 1; // we check for the number if the i-th bit is set or not
            if (!temp.containsKey(bit)) {
                temp.put(bit, new TrieNodeBit2());
            }
            // move to the reference node of 'bit'
            temp = temp.get(bit);
        }
    }

    public int getMaxXor (int x) {
        TrieNodeBit2 temp = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1; // we check for the number if the i-th bit is set or not
            if (temp.containsKey(1 - bit)) { // we check for the opposite bit
                maxXor = maxXor | (1 << i); // we make the i-th bit of maxXor set
                temp = temp.get(1 - bit); // move to the reference node of bit
            }
            else { // maxXor will remain as 0 if 'bit' and the bit in temp are same
                temp = temp.get(bit); // move to the reference node of bit
            }
        }
        return maxXor;
    }
}

class Triplet {
    int Xi;
    int Ai;
    int index;

    public Triplet(int Xi, int Ai, int index) {
        this.Xi = Xi;
        this.Ai = Ai;
        this.index = index;
    }
}