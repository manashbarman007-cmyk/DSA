package trees;

public class DFS_Traversal {
    public static void main(String[] args) {

    }

    // 1 : PreOrder (Root - Left - Right)
    static void preOrder (NodeBT node) { // the root node is passed here
        // base case
        if (node == null) {
            return;
        }
        System.out.println(node.data); // print the current node
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2 : InOrder (Left - Root - Right)
    static void inOrder (NodeBT node) { // the root node is passed here
        // base case
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    // 3 : PostOrder (Left - Right - Root)
    static void postOrder (NodeBT node) { // the root node is passed here
        //base case
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);


    }

}
