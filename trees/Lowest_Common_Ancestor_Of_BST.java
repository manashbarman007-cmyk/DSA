package trees;

public class Lowest_Common_Ancestor_Of_BST {
    public static void main(String[] args) {

    }
    public NodeBT lowestCommonAncestor(NodeBT root, NodeBT p, NodeBT q) {
        // base case
        if (root == null ) return null;

        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q); // move left
        }
        if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q); // move right
        }

        return root;  // root is returned when left and right path splits
    }
}
