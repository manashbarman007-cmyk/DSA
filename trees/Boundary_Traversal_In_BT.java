package trees;
import java.util.*;

public class Boundary_Traversal_In_BT {
    public static void main(String[] args) {
//        NodeBT root = new NodeBT(1);
//        root.right = new NodeBT(2);
//        root.right.right = new NodeBT(3);
//        root.right.right.right = new NodeBT(4);

        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.right = new NodeBT(3);
        root.left.left = new NodeBT(4);
        root.left.right = new NodeBT(5);
        root.right.left = new NodeBT(6);
        root.right.right = new NodeBT(7);

        System.out.println(boundaryTraversal(root));
    }
    static boolean isLeaf(NodeBT root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    // Function to add the
    // left boundary of the tree
    static void addLeftBoundary(NodeBT root, ArrayList<Integer> res) {
        NodeBT curr = root.left;
        while (curr != null) {
            // If the current node is not a leaf,
            // add its value to the result
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            // Move to the left child if it exists,
            // otherwise move to the right child
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Function to add the
    // right boundary of the tree
    static void addRightBoundary(NodeBT root, ArrayList<Integer> res) {
        NodeBT curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while (curr != null) {
            // If the current node is not a leaf,
            // add its value to a temporary list
            if (!isLeaf(curr)) {
//                temp.add(curr.data);
                stack.push(curr.data);
            }
            // Move to the right child if it exists,
            // otherwise move to the left child
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        // Reverse and add the values from the temporary list to the result

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    // Function to add the
    // leaves of the tree
    static void addLeaves(NodeBT root, ArrayList<Integer> res) {
        // If the current node is a
        // leaf, add its value to the result
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        // Recursively add leaves of
        // the left and right subtrees
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    // Main function to perform the
    // boundary traversal of the binary tree
    static ArrayList<Integer> boundaryTraversal(NodeBT root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // If the root is not a leaf,
        // add its value to the result
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // Add the left boundary, leaves,
        // and right boundary in order
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

}
