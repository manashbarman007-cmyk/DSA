package trees;

public class Count_Complete_Tree_Nodes {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.left.left = new NodeBT(4);
        root.left.right = new NodeBT(5);
        root.right = new NodeBT(3);
        root.right.left = new NodeBT(6);
        System.out.println(countNodes(root));
    }

    // Approach 1 : TC = O(n)
//    public int countNodes(NodeBT root) {
//        int[] count = new int[1];
//        dfs(root, count);
//        return count[0];
//    }
//    static void dfs(NodeBT root, int[] count) {
//        // base case
//        if (root == null) return;
//        count[0]++;
//        dfs(root.left, count);
//        dfs(root.right, count);
//    }


    // Approach 2 : TC = O(log^2(n))
    public static int countNodes(NodeBT root) {
        return dfs(root);
    }
    static int dfs(NodeBT root) {
        // base case
        if (root == null) {
            return 0;
        }
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }
        else {
            return 1 + dfs(root.left) + dfs(root.right);
        }
    }
    static int findLeftHeight (NodeBT root) {
        // base case
        if (root == null) return 0;
        return 1 + findLeftHeight(root.left);
    }
    static int findRightHeight (NodeBT root) {
        // base case
        if (root == null) return 0;
        return 1 + findRightHeight(root.right);
    }
}

