package trees;
import java.util.*;
public class Bottom_View_Of_Binary_Tree {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(20);
        root.left = new NodeBT(8);
        root.left.left = new NodeBT(5);
        root.left.right = new NodeBT(7);
        root.right = new NodeBT(22);
        root.right.left = new NodeBT(34);
        root.right.right = new NodeBT(25);
        System.out.println(bottomView(root));
    }
    public static ArrayList<Integer> bottomView(NodeBT root) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Pair1> queue = new LinkedList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        queue.offer(new Pair1(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.peek().node;
                int curData = curNode.data;
                int curVertical = queue.peek().vertical;
                if (curNode.left != null) {
                    queue.offer(new Pair1(curNode.left, curVertical - 1));
                }
                if (curNode.right != null) {
                    queue.offer(new Pair1(curNode.right, curVertical + 1));
                }
                if (!tm.containsKey(curVertical)) {
                    tm.put(curVertical, curData);
                }
                else { // modify the new cuData
                    tm.put(curVertical, curData);

                }
                queue.poll();
            }
        }
        for (Map.Entry<Integer,Integer> map : tm.entrySet()) {
            list.add(map.getValue());
        }
        return list;
    }
}
