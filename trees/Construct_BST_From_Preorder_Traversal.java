package trees;

import java.util.HashMap;

public class Construct_BST_From_Preorder_Traversal {
    public static void main(String[] args) {

    }
    public NodeBT bstFromPreorder(int[] preorder) {
        int[] ind = {0};
        return construct(preorder, ind, Integer.MAX_VALUE);
    }

    public NodeBT construct(int[] preorder,int[] ind, int max_Range) {
        // base case
        int n = preorder.length;
        if (ind[0] >= n || preorder[ind[0]] > max_Range) return null;

        NodeBT root = new NodeBT(preorder[ind[0]++]);

        root.left = construct(preorder, ind, root.data);
        root.right = construct(preorder, ind, max_Range);

        return root;
    }
}
