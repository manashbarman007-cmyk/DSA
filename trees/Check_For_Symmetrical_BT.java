package trees;

public class Check_For_Symmetrical_BT {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.left.left = new NodeBT(3);
        root.left.right = new NodeBT(4);
        root.right = new NodeBT(2);
        root.right.left = new NodeBT(4);
        root.right.right = new NodeBT(3);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(NodeBT root) {
        return func (root.left, root.right);
    }
    static boolean func (NodeBT root1, NodeBT root2) {

        // base case1
        if (root1 == null && root2 == null) return true; // if both the roots reach null simultaneously
        // base case2
        if (root1 == null || root2 == null) return false; // if either of the roots reaches null

        if (root1.data != root2.data) return false;

        boolean moveOut = func(root1.left, root2.right); // move root1 to left and root2 to right
        boolean moveIn = func(root1.right, root2.left); // move root1 to right and root2 to left

        // if either func returns a false then return a false
        if (!moveOut || !moveIn) return false;

        return true;
    }
}
