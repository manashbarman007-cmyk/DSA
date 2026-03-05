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
