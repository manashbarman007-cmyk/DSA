package trees;

import java.util.HashMap;

public class Insert_Node_In_BST {
    public static void main(String[] args) {

    }
    public NodeBT insertIntoBST(NodeBT root, int val) {
        if (root == null) {
            return new NodeBT(val);
        }
        // Step 1 : find the ceil node (ie the inorder successor)
        int ceil = Integer.MAX_VALUE;
        NodeBT copyRoot = root;
        NodeBT originalRoot = root;
        HashMap<Integer, NodeBT> ceilTracker = new HashMap<>();
        NodeBT ceilNode = null;
        while (root != null) {
            if (root.data >= val){
                ceil = Math.min(ceil, root.data);
                ceilTracker.put(ceil, root);
            }
            root = (val < root.data)? root.left : root.right;
        }
        if (ceilTracker.containsKey(ceil)) ceilNode = ceilTracker.get(ceil);

        // step 2 : if ceil node does not exit
        if (ceilNode == null) { // ie if there is no ceilNode
            while (copyRoot.right != null) {
                copyRoot = copyRoot.right; // move to the rightmost node
            }
            copyRoot.right = new NodeBT(val);
        }

        // step 3 : if ceil node exits
        else {
            NodeBT newNode = new NodeBT(val);
            NodeBT prevLeft = ceilNode.left;
            ceilNode.left = newNode;
            newNode.left = prevLeft;
        }
        return originalRoot;
    }
}
