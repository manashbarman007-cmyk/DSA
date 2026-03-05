package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recover_BST {
//    int ind = -1; // defined globally
    NodeBT first; // first element of the first violation
    NodeBT prev; // previous element to the current element
    NodeBT middle; // second element of the first violation
    NodeBT last; // last element of the second violation

    public static void main(String[] args) {

    }


//    // Approach 1
//    public void recoverTree(NodeBT root) {
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        Collections.sort(list);
//        compareAndChange(root, list);
//    }
//
//    public void compareAndChange(NodeBT root, List<Integer> list) {
//        if (root == null) return;
//
//        compareAndChange(root.left, list);
//        if (root.data != list.get(++ind)) {
//            root.data = list.get(ind);
//        }
//        compareAndChange(root.right, list);
//    }
//    static void inorder (NodeBT root, List<Integer> list) {
//        if (root == null) return;
//
//        inorder(root.left, list);
//        list.add(root.data);
//        inorder(root.right, list);
//    }



     public void inorder(NodeBT root) {
        if (root == null) return;

        inorder(root.left);
        if (prev != null && (root.data < prev.data)) {
            // if it is the first violation then mark the elements
            if (first == null) {
                first = prev; // first element of the first violation
                middle = root;
            }
            else { // first != null (ie it is the second violation)
                last = root;
            }
        }
        // mark this nod as the previous
        prev = root;
        inorder(root.right);
     }

    // Approach 2
    public void recoverTree(NodeBT root) {
        first = last = middle = null;
        prev = new NodeBT(Integer.MIN_VALUE);
        inorder(root);

        // if there are two violations
        if (first != null && last != null) { // swap first and last val
            int firstVal = first.data;
            first.data = last.data;
            last.data = firstVal;
        }

        // if there is one violation
        else if (first != null && middle != null) { // swap first and middle val
            int firstVal = first.data;
            first.data = middle.data;
            middle.data = firstVal;
        }
    }
}
