package trees;

import java.util.HashMap;

public class Unique_Tree_From_InOrder_And_PostOrder {
    public static void main(String[] args) {

    }
    public NodeBT buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> rootTracker = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            rootTracker.put(inorder[i], i);
        }
        return constructTree(inorder, 0, n - 1, postorder, 0 , n - 1, rootTracker);
    }

    static NodeBT constructTree(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int postStart, int postEnd,
                                HashMap<Integer,Integer> rootTracker) {

        if (inStart > inEnd || postStart > postEnd) return null;

        NodeBT root = new NodeBT(postorder[postEnd]);

        // find the position of the root in inorder
        int positionOfRoot = rootTracker.get(root.data);

        // number of elements on the left side of root in inorder
        int numOnLeft = positionOfRoot - inStart;

        // connect the root's left
        root.left = constructTree(inorder, inStart, positionOfRoot - 1, postorder,
                                  postStart, postStart + numOnLeft - 1, rootTracker);

        // connect the root's right
        root.right = constructTree(inorder, positionOfRoot + 1, inEnd, postorder,
                                   postStart + numOnLeft, postEnd - 1, rootTracker);

        return root;
    }
}
