package trees;
import java.util.*;

public class Root_To_Leaf {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.left.right = new NodeBT(5);
        root.right = new NodeBT(3);
        System.out.println(binaryTreePaths(root));
    }
    public static List<String> binaryTreePaths(NodeBT root) {
        List<String> list = new ArrayList<>();
        func(root, "", list);
        return list;
    }

    // Inorder traversal
    static void func (NodeBT node, String str, List<String> list) {
        // base case
        if (node == null) return;

        if (!isLeaf(node)) {
            str += node.data + "->"; // we concatenate it
        }
        else {
            str += node.data; // we concatenate it
        }

        // if we are at leaf node
        if (node.left == null && node.right == null) {
            list.add(str);
            str = ""; // we reset the str as empty
        }
        func(node.left, str, list);
        func(node.right, str, list);
    }

    // this func returns 'true' if the node is a leaf node
    static boolean isLeaf (NodeBT node) {
        return node.left == null && node.right == null;
    }
}
