package trees;

public class Diameter_Of_Binary_Tree {

    public static void main(String[] args) {

    }
    public int diameterOfBinaryTree(NodeBT root) {
        int[] maxDiameter = new int[1];

        findHeight(root, maxDiameter);

        return maxDiameter[0];
    }
    static int findHeight (NodeBT node, int[] maxDiameter) {
        //base case
        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left, maxDiameter);
        int rightHeight = findHeight(node.right, maxDiameter);

       // Calculate the diameter at the current node and update the maxDiameter
        maxDiameter[0] = Math.max(leftHeight + rightHeight, maxDiameter[0]);

        // return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
