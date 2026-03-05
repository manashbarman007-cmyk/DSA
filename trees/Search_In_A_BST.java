package trees;

public class Search_In_A_BST {
    static NodeBT searchNode = null; // defined globally

    public static void main(String[] args) {
        NodeBT root = new NodeBT(4);
        root.left = new NodeBT(2);
        root.left.left = new NodeBT(1);
        root.left.right = new NodeBT(3);
        root.right = new NodeBT(7);
        System.out.println(searchBST(root, 5));

    }
    public static NodeBT searchBST(NodeBT root, int val) {
        while (root != null && root.data != val) {
            root = (val < root.data)? root.left : root.right;
        }
        return root;
    }
}
