package trees;

import java.util.ArrayList;
import java.util.List;

public class Largest_BST_In_Binary_Tree {
    public static void main(String[] args) {

    }
    public static int largestBST(NodeBT root) {
        // Write your code here.
        CompareNodes obj = postorder(root);
        return obj.maxSize;
    }

    public static CompareNodes postorder(NodeBT root) {
        if (root == null) {
            return new CompareNodes(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        CompareNodes left = postorder(root.left);
        CompareNodes right = postorder(root.right);

        if (root.data > left.maxNode && root.data < right.minNode) {
            return new CompareNodes(1 + left.maxSize + right.maxSize, Math.min(left.minNode, root.data),
                    Math.max(right.maxNode, root.data));
        }

        // otherwise return [-IM, IM] so that they do not get compared
        return new CompareNodes(Math.max(left.maxSize, right.maxSize), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

class CompareNodes {
    int maxSize;
    int minNode;
    int maxNode;

    public CompareNodes(int maxSize, int minNode, int maxNode) {
        this.maxSize = maxSize;
        this.minNode = minNode;
        this.maxNode = maxNode;
    }
}
