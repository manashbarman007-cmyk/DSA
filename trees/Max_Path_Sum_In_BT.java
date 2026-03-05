package trees;

public class Max_Path_Sum_In_BT {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(-10);
        root.left = new NodeBT(9);
        root.right = new NodeBT(20);
        root.right.left = new NodeBT(15);
        root.right.right = new NodeBT(7);
        System.out.println(maxPathSum(root));

    }
    static int maxPathSum(NodeBT root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        findMaxSum (root, maxSum);
        return maxSum[0];
    }


    // this func figures out whether the left or the right path gives the max sum from the root and returns the maxSum
    static int findMaxSum (NodeBT node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(0, findMaxSum(node.left, maxSum)); // similar to Kadane's algo, if sum < 0, we reset it to 0
        int rightSum  = Math.max(0, findMaxSum(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], node.data + leftSum + rightSum);

       return node.data + Math.max(leftSum, rightSum);
    }

}
