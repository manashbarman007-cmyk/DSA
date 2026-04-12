package trees;
import java.util.*;

public class Zig_Zag_Or_Spiral_Traversal {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.right = new NodeBT(3);
        root.left.left = new NodeBT(4);
        root.left.right = new NodeBT(5);
        root.right.left = new NodeBT(6);
        root.right.right = new NodeBT(7);
        List<List<Integer>> list = zigzagLevelOrder(root);
        System.out.println(list);
    }
    static List<List<Integer>> zigzagLevelOrder(NodeBT root) {
        List<List<Integer>> list = new ArrayList<>();
        boolean leftToRight = true;
        if (root == null) {
            return list;
        }
        Queue<NodeBT> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at the current level
            Integer[] helper = new Integer[size];
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.poll();

                // using ternary operator to set the index
                int index = leftToRight ? i : (size - 1 - i);

                helper[index] = curNode.data;

                // if there exists a left element then add it to the queue
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                // if there exists a right element then add it to the queue
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            // change the order of direction for the next iteration
            leftToRight = !leftToRight;

            List<Integer> sublist = Arrays.asList(helper);

            list.add(sublist);
        }
        return list;
    }
}

// Use Deque

// class Solution {
//      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

//         List<List<Integer>> list = new ArrayList<>();

//         if (root == null) return list;

//         Deque<TreeNode> deque = new ArrayDeque<>();

//         deque.offerLast(root);

//         boolean traverseLeft = true;

//         while (!deque.isEmpty()) {
//             int size = deque.size();
//             List<Integer> sublist = new ArrayList<>();
//             if (traverseLeft) {
//                 traverseLeft = false;
//                 for (int i = 0; i < size; i++) {
//                     TreeNode curNode = deque.pollFirst();
//                     if (curNode.left != null) deque.offerLast(curNode.left);
//                     if (curNode.right != null) deque.offerLast(curNode.right);
//                     sublist.add(curNode.val);
//                 }

//             }else {
//                 traverseLeft = true;
//                 for (int i = 0; i < size; i++) {
//                     TreeNode curNode = deque.pollLast();
//                     if (curNode.right != null) deque.offerFirst(curNode.right);
//                     if (curNode.left != null) deque.offerFirst(curNode.left);
//                     sublist.add(curNode.val);
//                 }
//             }
//             list.add(sublist);
//         }

//         return list;
//     }
// }
