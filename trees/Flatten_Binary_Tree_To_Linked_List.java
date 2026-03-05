package trees;
import java.util.*;
public class Flatten_Binary_Tree_To_Linked_List {
    NodeBT prev = null; // defined globally

    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.left.left = new NodeBT(3);
        root.left.right = new NodeBT(4);
        root.right = new NodeBT(5);
        root.right.right = new NodeBT(6);
    }

    // Approach 1 : TC = O(2n)
//    public static void flatten(NodeBT root) {
//        TreeMap<Integer, NodeBT> tracker = new TreeMap<>(); // sorts in key
//        Integer[] pos = new Integer[1];
//        pos[0] = -1;
//        preOrder(root, tracker, pos);
//        int n = tracker.size();
//        for (int i = 0; i < n - 1; i++) {
//            tracker.get(i).right = tracker.get(i + 1);
//            tracker.get(i).left = null;
//        }
//    }
//
//    static void preOrder (NodeBT root, TreeMap<Integer,NodeBT> tracker, Integer[] pos) {
//        // base case
//        if (root == null) return;
//
//        pos[0]++;
//
//        tracker.put(pos[0], root);
//
//        preOrder(root.left, tracker, pos);
//        preOrder(root.right, tracker, pos);
//    }

    // Approach 2 : TC = O(n)
    public void flatten(NodeBT root) {
        // base case
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root; // update the prev
    }
}
