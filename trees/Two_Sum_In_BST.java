package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Two_Sum_In_BST {

    public static void main(String[] args) {

    }

    // Approach 1
//    public boolean findTarget(NodeBT root, int k) {
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        int n = list.size();
//        for (int i = 0; i < n; i++) {
//            int remainingSum = k - list.get(i);
//            if (!hm.containsKey(remainingSum)) {
//                hm.put(list.get(i), i);
//            }
//            else {
//                return true; // ie hm contains the key
//            }
//        }
//        return false;
//    }
//
//    public void inorder(NodeBT root, List<Integer> list) {
//        if (root == null) return;
//
//        inorder(root.left, list);
//        list.add(root.data);
//        inorder(root.right, list);
//    }

    // Approach 2 : Using concept of BSTIterator
    public boolean findTarget(NodeBT root, int k) {
        if (root == null) return false;

        IteratorBST left = new IteratorBST(root, false); // for the inorder ie for next
        IteratorBST right = new IteratorBST(root, true); // for the reverse inorder ie for before

        int i = left.nextAndBefore(); // will give the next element
        int j = right.nextAndBefore(); // will give the before element

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = left.nextAndBefore();
            else j = right.nextAndBefore();
        }
        return false;
    }
}

class IteratorBST {
    NodeBT root;
    Stack<NodeBT> stack;
    boolean reverse;

    public IteratorBST (NodeBT root, boolean reverse) {
        this.root = root;
        this.reverse = reverse;
        stack = new Stack<>();
        insert(root, stack);
    }
    // store the inorder and reverse inorder
    public void insert(NodeBT root, Stack<NodeBT> stack) {
        NodeBT temp = root;
        while (temp != null) {
            stack.push(temp);
            if (!reverse) temp = temp.left; // for inorder
            else temp = temp.right; // for reverse inorder
        }
    }
    public int nextAndBefore() {
        NodeBT curNode = stack.pop();
        int curData = curNode.data;
        if (!reverse) insert(curNode.right, stack); // for inorder to find next
        else insert(curNode.left, stack); // for reverse inorder to find before
        return curData;
    }
}
