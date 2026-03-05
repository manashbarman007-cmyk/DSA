package trees;
import java.util.ArrayList;
import java.util.List;
public class Validate_Binary_Search_Tree {
    int min_Range = Integer.MIN_VALUE, max_Range = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    // Approach 1
//    public boolean isValidBST(NodeBT root) {
//        // base case
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        int n = list.size();
//        for (int i = 0; i < n - 1; i++) {
//            if (list.get(i) >= list.get(i + 1)) {
//                return false;
//            }
//        }
//        return true; // for valid BST the list must be in increasing order
//    }
//
//    static void inorder (NodeBT root, List<Integer> list) {
//        if (root == null) return;
//
//        inorder(root.left, list);
//        list.add(root.data);
//        inorder(root.right, list);
//    }

    // Approach 2
    public boolean isValidBST(NodeBT root) {
        return func(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static boolean func(NodeBT root, long min_Range, long max_Range) {
        // base case
        if (root == null) return true;

        // if current node does not lie in range return false
        if (root.data <= min_Range || root.data >= max_Range) return false;

        boolean leftCall = func(root.left, min_Range, root.data);
        boolean rightCall = func(root.right, root.data, max_Range);

        // if either call returns false then return a false
        if (!leftCall || !rightCall) return false;

        return true;
    }
}
