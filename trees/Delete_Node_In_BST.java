package trees;

public class Delete_Node_In_BST {
    public static void main(String[] args) {

    }


    // use the concept for inorder successor and inorder predecessor
    public NodeBT deleteNode(NodeBT root, int key) {
        // edge case 1
        if (root == null) {
            return null;
        }
        // edge case 2
        if (root.left == null && root.right == null && root.data == key) {
            return null;
        }
        // edge case 3
        if (root.data == key) {
            return deleteRoot(root);
        }
        NodeBT temp = root;
        NodeBT prev = null;
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = (key < temp.data)? temp.left : temp.right;
        }
        NodeBT leftTempChild = (temp != null)? temp.left : null;
        NodeBT rightTempChild = (temp != null)? temp.right : null;

        if (key < prev.data) {
            if (rightTempChild == null) prev.left = leftTempChild;
            else if (leftTempChild == null) prev.left = rightTempChild;
            else {  // connect the prev node to the inorder successor of the deleted node
                NodeBT mover = rightTempChild;
                while (mover.left != null) {
                    mover = mover.left;
                }
                prev.left = rightTempChild;
                mover.left = leftTempChild;
            }
        }
        else { // if (key >= prev.data)
            if (rightTempChild == null) prev.right = leftTempChild;
            else if (leftTempChild == null) prev.right = rightTempChild;
            else { // connect the prev node to the inorder predecessor of the deleted node
                NodeBT mover = leftTempChild;
                while (mover.right != null) {
                    mover = mover.right;
                }
                prev.right = leftTempChild;
                mover.right = rightTempChild;
            }
        }
        return root;
    }

    static NodeBT deleteRoot(NodeBT root) {
        NodeBT leftRootChild = root.left;
        NodeBT rightRootChild = root.right;
        if (leftRootChild == null) return rightRootChild;
        if (rightRootChild == null) return leftRootChild;
        else {
            NodeBT temp = rightRootChild;
            root.left = null;
            root.right = null;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = leftRootChild;
            return rightRootChild;
        }
    }
}


// study this:

// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if (root == null) return null;
//         TreeNode[] nodeAndParent = findNodeAndParent(root, key);
//         if (nodeAndParent == null) return root; // i.e. the node does not exist
//         else {
//             TreeNode nodeToRemove = nodeAndParent[0];
//             TreeNode parent = nodeAndParent[1];

//             // case 1 : node is a leaf node
//             if (nodeToRemove.left == null && nodeToRemove.right == null) {

//                 // root deletion
//                 if (parent == null) {
//                     return null;
//                 }
//                 else {
//                     if (nodeToRemove.val < parent.val) parent.left = null;
//                     else parent.right = null;
//                 }
//             }
//             // case 2 : node has 1 child
//             else if (nodeToRemove.left == null || nodeToRemove.right == null) {
//                 TreeNode child;

//                 if (nodeToRemove.left == null) {
//                     child = nodeToRemove.right;

//                     //root deletion
//                     if (parent == null) {
//                         return child;
//                     }
//                     else {
//                         if (nodeToRemove.val < parent.val) parent.left = child;
//                         else parent.right = child;
//                     }
//                 } else {
//                     child = nodeToRemove.left;

//                     //root deletion
//                     if (parent == null) {
//                         return child;
//                     }
//                     else {
//                         if (nodeToRemove.val < parent.val) parent.left = child;
//                         else parent.right = child;
//                     }
//                 }
//             }
//             // case 3 : if node has 2 children
//             else {
//                 TreeNode[] inorderSuccessorAndParent = findInorderSuccessorAndParent(nodeToRemove);
//                 TreeNode inorderSuccessor = inorderSuccessorAndParent[0];
//                 TreeNode inorderSuccessorParent = inorderSuccessorAndParent[1];

//                 if (inorderSuccessorParent != nodeToRemove) {
//                     nodeToRemove.val = inorderSuccessor.val;
//                     inorderSuccessorParent.left = inorderSuccessor.right;
//                 }else {
//                     nodeToRemove.val = inorderSuccessor.val;
//                     nodeToRemove.right = inorderSuccessor.right;
//                 }
//             }
//         }
//         return root;
//     }

//     public TreeNode[] findNodeAndParent (TreeNode root, int key) {
//         TreeNode[] nodeAndParent = new TreeNode[2];
//         TreeNode parent = null;
//         while (root != null) {
//             if (key == root.val) {
//                 nodeAndParent[0] = root;
//                 nodeAndParent[1] = parent;
//                 return nodeAndParent;
//             } else if (key < root.val) {
//                 parent = root;
//                 root = root.left;
//             }else {
//                 parent = root;
//                 root = root.right;
//             }
//         }
//         return null;
//     }
//     public TreeNode[] findInorderSuccessorAndParent (TreeNode node) {
//         TreeNode[] inorderSuccessorAndParent = new TreeNode[2];
//         TreeNode parent = node;

//         // move right
//         TreeNode cur = node.right;
        
//         while (cur != null) {
//             if (cur.left != null) {
//                 parent = cur;
//                 cur = cur.left;
//             }else {
//                 inorderSuccessorAndParent[0] = cur;
//                 inorderSuccessorAndParent[1] = parent;
//                 return inorderSuccessorAndParent;
//             }
//         }
//         return null;
//     }
// }
