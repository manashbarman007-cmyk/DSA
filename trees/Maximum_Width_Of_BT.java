package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_Of_BT {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(3);
        root.left.left = new NodeBT(4);
        root.right = new NodeBT(2);
        root.right.right = new NodeBT(8);
        System.out.println(widthOfBinaryTree(root));
        System.out.println(Integer.MAX_VALUE);
    }
    public static int widthOfBinaryTree(NodeBT root) {
        if (root == null) {
            return 0;
        }
        Queue <IndexNodePair> queue = new LinkedList<>();
        long maxWidth = Long.MIN_VALUE;
        queue.offer(new IndexNodePair(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            long leftMostInd = Long.MAX_VALUE;
            long rightMostInd = Long.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.peek().node;
                long curIndex = queue.peek().index;
                if (curNode.left != null) {
                    queue.offer(new IndexNodePair(curNode.left, (2 * curIndex))); // 2 * curIndex may give us integer overflow
                                                                                  // so we use 'long'
                }
                if (curNode.right != null) {
                    queue.offer(new IndexNodePair(curNode.right, (2 * curIndex) + 1));
                }
                leftMostInd = Math.min(leftMostInd, curIndex);
                rightMostInd = Math.max(rightMostInd, curIndex);
                queue.poll();
            }
            maxWidth = Math.max(maxWidth,rightMostInd - leftMostInd + 1);
        }
        return (int)maxWidth;
    }
}
class IndexNodePair {
    NodeBT node;
    long index;

    public IndexNodePair(NodeBT node, long index) {
        this.node = node;
        this.index = index;
    }
}
