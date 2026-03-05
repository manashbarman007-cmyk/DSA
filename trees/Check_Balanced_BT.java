package trees;

public class Check_Balanced_BT {
    public static void main(String[] args) {

    }

    // Approach 1 : Brute force
//    static boolean checkBalancedBT (NodeBT root) {
//        if (root == null) {
//            return true;
//        }
//        int leftHeight = findHeight (root.left);
//        int rightHeight = findHeight (root.right);
//
//        if (Math.abs(leftHeight - rightHeight) > 1) return false;
//
//        boolean checkLeft = checkBalancedBT(root.left);
//        boolean checkRight = checkBalancedBT(root.right);
//
//        if (!checkLeft || !checkRight) return false; // if either check gives a false we return a false
//
//        return true;
//    }
//    static int findHeight (NodeBT node) {
//        // base case
//        if (node == null) {
//            return 0;
//        }
//        int moveLeft = findHeight(node.left);
//        int moveRight = findHeight(node.right);
//
//        return Math.max(moveLeft, moveRight) + 1;
//    }

    // Approach 1 : Optimised approach
    static boolean checkBalancedBT (NodeBT root) {
        if (findHeight(root) == -1) {
            return false;
        }
        return true;
    }
    static int findHeight (NodeBT node) {
        // base case
        if (node == null) {
            return 0;
        }
        int leftHeight = findHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = findHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) { // we implement the check here itself
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
