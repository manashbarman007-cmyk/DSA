package trees;
import java.util.*;
public class Lowest_Common_Ancestor {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(3);
        root.left = new NodeBT(5);
        root.left.left = new NodeBT(6);
        root.left.right = new NodeBT(2);
        root.left.right.left = new NodeBT(7);
        root.left.right.right = new NodeBT(4);
        root.right = new NodeBT(1);
        root.right.left = new NodeBT(0);
        root.right.right = new NodeBT(8);
        NodeBT lca = lowestCommonAncestor(root, root.left.left, root.left.right.right);
        System.out.println(lca.data);
    }
    public static NodeBT lowestCommonAncestor(NodeBT root, NodeBT p, NodeBT q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        NodeBT left = lowestCommonAncestor(root.left, p, q);
        NodeBT right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else return root; // if both are not null, we found the result
    }
}
