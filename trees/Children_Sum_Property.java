package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Children_Sum_Property {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(40);
        root.left = new NodeBT(10);
        root.left.left = new NodeBT(2);
        root.left.right = new NodeBT(5);
        root.right = new NodeBT(20);
        root.right.left = new NodeBT(30);
        root.right.right = new NodeBT(40);
        childrenSum(root);
        List<List<Integer>> list = levelOrderTraversal(root);
        System.out.println(list);
    }
    static void childrenSum(NodeBT root) {
        if (root == null) {
            return;
        }
        int sumChild = 0;
        if (root.left != null) sumChild += root.left.data;
        if (root.right != null) sumChild += root.right.data;

        if (sumChild >= root.data) root.data = sumChild;
        else { // if (sumChild < root.data)
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        childrenSum(root.left);
        childrenSum(root.right);

        // while returning (ie when coming back we update the root sum)
        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total; // ie we update when root is not a leaf node
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
