package trees;
import  java.util.*;

public class Top_View_Of_Binary_Tree {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.left.left = new NodeBT(4);
        root.left.right = new NodeBT(10);
        root.left.left.right = new NodeBT(5);
        root.left.left.right.right = new NodeBT(6);
        root.right = new NodeBT(3);
        root.right.left = new NodeBT(9);
        root.right.right = new NodeBT(11);

//        NodeBT root = new NodeBT(1);
//        root.right = new NodeBT(2);
//        root.right.left = new NodeBT(3);
//        root.right.right = new NodeBT(4);
//        root.right.right.left = new NodeBT(5);
//        root.right.right.right = new NodeBT(6);
//        root.right.right.right.left = new NodeBT(7);
//        root.right.right.right.right = new NodeBT(8);
//        root.right.right.right.left.left = new NodeBT(9);
//        root.right.right.right.left.right = new NodeBT(10);
//        root.right.right.right.left.right.left = new NodeBT(11);
//        root.right.right.right.left.right.right = new NodeBT(12);
//        root.right.right.right.left.right.right.left = new NodeBT(13);
//        root.right.right.right.left.right.right.right = new NodeBT(14);

//
//        NodeBT root = new NodeBT(5);
//        root.left = new NodeBT(2);
//        root.right = new NodeBT(3);
//        root.left.left = new NodeBT(4);
//        root.left.right = new NodeBT(2);
//        root.right.left = new NodeBT(2);
//        root.right.right = new NodeBT(7);

//        NodeBT root = new NodeBT(1);
//        root.left = new NodeBT(2);
//        root.right = new NodeBT(3);
//        root.right.right = new NodeBT(4);
//        root.right.right.left = new NodeBT(5);
//        root.right.right.left.left = new NodeBT(6);
//        root.right.right.left.right = new NodeBT(7);
        System.out.println(topView(root));
    }

    static ArrayList<Integer> topView(NodeBT root) {
        // code here
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
                queue.poll();
            }
        }
        for (Map.Entry<Integer,Integer> map : tm.entrySet()) {
            list.add(map.getValue());
        }
        return list;
    }
}
class Pair1 {
    NodeBT node;
    int vertical;

    public Pair1(NodeBT node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
