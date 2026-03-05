package trees;

import java.util.*;

public class BFS_Traversal {
    public static void main(String[] args) {

    }
    static List<List<Integer>> levelOrderTraversal (NodeBT root) {
        Queue<NodeBT> queue = new LinkedList<>(); // implementing queue using LL
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list; // return the empty list
        }
        queue.offer(root); // we insert in the queue
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll().data);
            }
            list.add(sublist);
        }
        return list;
    }
}
