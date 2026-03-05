package trees;
import java.util.*;
public class All_Nodes_At_Distance_K_In_Binary_Tree {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(3);
        root.left = new NodeBT(5);
        root.left.left = new NodeBT(6);
        root.left.right = new NodeBT(2);
        root.left.right.left = new NodeBT(7);
        root.left.right.right = new NodeBT(4);
        root.right = new NodeBT(1);
        root.right.left = new NodeBT(0);
        root.right.right = new NodeBT(8);
        System.out.println(distanceK(root, root.left, 2));
    }

    public static List<Integer> distanceK(NodeBT root, NodeBT target, int k) {
        List<Integer> list = new ArrayList<>();
        HashMap<NodeBT, NodeBT> parentTracker = new HashMap<>();
        markParents(root, parentTracker);
        Queue<NodeBT> queue = new LinkedList<>();
        HashMap<NodeBT, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int dist = 0;
        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == k) break; // we get out of the loop
            dist++;
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
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll().data);
        }
        return list;
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
}
