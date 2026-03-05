package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Depth_Of_BT {
    public static void main(String[] args) {

    }

    // Using level order traversal
//    static int maxDepth (NodeBT root) {
//        if (root == null) {
//            return 0;
//        }
//        int maxDepth = 0; // as the minDepth can be 0
//        Queue<NodeBT> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            maxDepth++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                if (queue.peek().left != null) {
//                    queue.offer(queue.peek().left);
//                }
//                if (queue.peek().right != null) {
//                    queue.offer(queue.peek().right);
//                }
//                queue.poll();
//            }
//        }
//        return maxDepth;
//    }

    // Using recursion
    static int maxDepth (NodeBT root) {
        if (root == null) {
            return 0;
        }
        return func (root);
    }
    static int func (NodeBT node) {
        // base case
        if (node == null) {
            return 0;
        }
        int moveLeft = func(node.left);
        int moveRight = func(node.right);

        return Math.max(moveLeft, moveRight) + 1; // + 1 as we take into account for the current node
    }
}
