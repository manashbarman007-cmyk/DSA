package trees;

public class Floor_In_A_BST {
    public static void main(String[] args) {

    }
    public static int floor(NodeBT root, int x) {
        // Code here
        int floor = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data <= x) floor = Math.max(floor, root.data);
            root = (x < root.data)? root.left : root.right;
        }
        if (floor == Integer.MIN_VALUE) return -1;
        return floor;
    }
}
