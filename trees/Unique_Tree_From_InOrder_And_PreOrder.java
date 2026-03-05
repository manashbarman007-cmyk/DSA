package trees;

import java.util.HashMap;

public class Unique_Tree_From_InOrder_And_PreOrder {
    public static void main(String[] args) {

    }

    public static NodeBT buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> rootTracker = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            rootTracker.put(inorder[i], i);
        }
        return constructTree(preorder, 0, n - 1, inorder, 0, n - 1, rootTracker);
    }
    static NodeBT constructTree (int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> rootTracker) {

        if (preStart > preEnd || inStart > inEnd) return null;

        NodeBT root = new NodeBT(preorder[preStart]);

        // find the position of the root in the inorder
        int inorderRootPosition = rootTracker.get(root.data);

        // number of elements on the left side of root in inorder
        int numLeft = inorderRootPosition - inStart;

        // connect the root's left
        root.left = constructTree(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inorderRootPosition - 1, rootTracker);

        // connect the root's right
        root.right = constructTree(preorder, preStart + numLeft + 1, preEnd, inorder, inorderRootPosition + 1, inEnd, rootTracker);

        return root;
    }
}
