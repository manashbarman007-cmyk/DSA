package trees;

public class Ceil_In_A_BST {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(10);
        root.left = new NodeBT(5);
        root.left.left = new NodeBT(3);
        root.left.left.left = new NodeBT(2);
        root.left.left.right = new NodeBT(4);
        root.left.right = new NodeBT(6);
        root.left.right.right = new NodeBT(9);
        root.right = new NodeBT(13);
        root.right.left = new NodeBT(11);
        root.right.right = new NodeBT(14);
        System.out.println(findCeil(root, 1));
    }
    public static int findCeil(NodeBT root, int key) {
        int ceil = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data >= key) ceil = Math.min(ceil, root.data);
            root = (key < root.data)? root.left : root.right;
        }

        if (ceil == Integer.MAX_VALUE) return -1; // ie ceil is not found

        return ceil;
    }
}
