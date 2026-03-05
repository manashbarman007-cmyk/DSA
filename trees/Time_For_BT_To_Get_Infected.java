package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Time_For_BT_To_Get_Infected {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(5);
        root.left.right = new NodeBT(4);
        root.left.right.left = new NodeBT(9);
        root.left.right.right = new NodeBT(2);
        root.right = new NodeBT(3);
        root.right.left = new NodeBT(10);
        root.right.right = new NodeBT(6);
        System.out.println(amountOfTime(root, 3));
    }
    public static int amountOfTime(NodeBT root, int start) {
        HashMap<NodeBT, NodeBT> parentTracker = new HashMap<>();
        markParents(root, parentTracker);

        Queue<NodeBT> queue = new LinkedList<>();
        HashMap<NodeBT, Boolean> visited = new HashMap<>();
        int time = 0;
        NodeBT[] target = new NodeBT[1];
        dfs(root, target, start);
        queue.offer(target[0]);
        visited.put(target[0], true);
        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.peek();
                NodeBT parentOfCurNode = parentTracker.get(curNode);
                if (curNode.left != null && !visited.containsKey(curNode.left)) {
                    queue.offer(curNode.left);
                    visited.put(curNode.left, true);
                }
                if (curNode.right != null && !visited.containsKey(curNode.right)) {
                    queue.offer(curNode.right);
                    visited.put(curNode.right, true);
                }
                if (parentOfCurNode != null && !visited.containsKey(parentOfCurNode)) {
                    queue.offer(parentOfCurNode);
                    visited.put(parentOfCurNode, true);
                }
                queue.poll();
            }
            time++;
        }
        return time - 1;
    }

    static void markParents (NodeBT root, HashMap<NodeBT, NodeBT> parentTracker) {
        // BFS traversal
        Queue<NodeBT> queue = new LinkedList<>();
        queue.offer(root);
        parentTracker.put(root, null); // as the parent has no root
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.peek();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    parentTracker.put(curNode.left, curNode);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    parentTracker.put(curNode.right, curNode);
                }
                queue.poll();
            }
        }
    }

    // to find target node
    static void dfs (NodeBT root, NodeBT[] target, int start) {
        if (root == null) return;

        if (root.data == start) target[0] = root;

        dfs(root.left, target, start);
        dfs(root.right, target, start);
    }
}
