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
