package trie;

public class Max_XOR_Of_Two_Nums_In_Array_LC_421 {
    public static void main(String[] args) {
        Max_XOR_Of_Two_Nums_In_Array_LC_421 obj = new Max_XOR_Of_Two_Nums_In_Array_LC_421();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(obj.findMaximumXOR(nums));
    }

    public int findMaximumXOR(int[] nums) {
        TrieBit1 trie = new TrieBit1();
        int n = nums.length;
        int max = 0;

        // insert all nums[i] in the trie
        for (int i = 0; i < n; i++) {
            trie.insert(nums[i]);
        }

        // get the maxXor
        for (int i = 0; i < n; i++) {
            int xor = trie.getMaxXor(nums[i]);
            max = Math.max(xor, max);
        }
        return max;
    }
}

class TrieNodeBit1 {
    TrieNodeBit1[] links;

    public TrieNodeBit1() {
        links = new TrieNodeBit1[2]; // we will be storing 0 and 1
    }

    void put(int ind, TrieNodeBit1 node) { // ind is either 0 or 1
        links[ind] = node;
    }

    boolean containsKey(int ind) {
        return links[ind] != null;
    }

    TrieNodeBit1 get(int ind) {
        return links[ind];
    }
}

class TrieBit1 {
    TrieNodeBit1 root;

    public TrieBit1() {
        root = new TrieNodeBit1();
    }

    public void insert (int num) {
        TrieNodeBit1 temp = root;
        for (int i = 31; i >= 0; i--) { // for a 32-bit number we insert from MSB to LSB
            int bit = (num >> i) & 1; // we check for the number if the i-th bit is set or not
            if (!temp.containsKey(bit)) {
                temp.put(bit, new TrieNodeBit1());
            }
            // move to the reference node of 'bit'
            temp = temp.get(bit);
        }
    }

    public int getMaxXor (int x) {
        TrieNodeBit1 temp = root;
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
