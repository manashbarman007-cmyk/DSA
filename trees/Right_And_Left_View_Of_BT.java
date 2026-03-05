package trees;
import java.util.*;

public class Right_And_Left_View_Of_BT {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(20);
        root.left = new NodeBT(8);
        root.left.left = new NodeBT(5);
        root.left.right = new NodeBT(7);
        root.right = new NodeBT(22);
        root.right.left = new NodeBT(34);
        root.right.right = new NodeBT(25);
        System.out.println(rightSideView(root));
        System.out.println(leftSideView(root));
    }

    // iterative
//    public static List<Integer> rightSideView(NodeBT root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        Queue<Doublet> queue = new LinkedList<>();
//        TreeMap<Integer, Integer> tm = new TreeMap<>();
//        queue.offer(new Doublet(root, 0));
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                NodeBT curNode = queue.peek().node;
//                int curData = curNode.data;
//                int curLevel = queue.peek().level;
//                if (curNode.left != null) {
//                    queue.offer(new Doublet(curNode.left, curLevel + 1));
//                }
//                if (curNode.right != null) {
//                    queue.offer(new Doublet(curNode.right, curLevel + 1));
//                }
//                if (!tm.containsKey(curLevel)) {
//                    tm.put(curLevel, curData);
//                }
//                else { // update the curData
//                    tm.put(curLevel, curData);
//                }
//                queue.poll();
//            }
//        }
//        for (Map.Entry<Integer, Integer> map : tm.entrySet()) {
//            list.add(map.getValue());
//        }
//        return list;
//    }

    // Recursive (recursive preOrder) using a treeMap
    public static List<Integer> rightSideView(NodeBT root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
//        TreeMap<Integer, Integer> tm = new TreeMap<>();
//        func (root, 0, tm);
//        for (Map.Entry<Integer, Integer> map : tm.entrySet()) {
//            list.add(map.getValue());
        func(root, 0, list);
        return list;
    }

    // Using a treeMap
//    static void func (NodeBT root, int level, TreeMap<Integer, Integer> tm) {
//        if (root == null) {
//            return;
//        }
//        // if we come to a level for the first time then store the value
//        if (!tm.containsKey(level)) {
//            tm.put(level, root.data);
//        }
//        func (root.right, level + 1, tm);
//        func (root.left, level + 1, tm);
//    }

    // Without using a treeMap
    static void func (NodeBT root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        // if we come to a level for the first time then store the value
        if (level == list.size()) {
            list.add(root.data);
        }
        func (root.right, level + 1, list);
        func (root.left, level + 1, list);
    }

    // iterative
    public static List<Integer> leftSideView (NodeBT root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Doublet> queue = new LinkedList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        queue.offer(new Doublet(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.peek().node;
                int curData = curNode.data;
                int curLevel = queue.peek().level;
                if (curNode.left != null) {
                    queue.offer(new Doublet(curNode.left, curLevel + 1));
                }
                if (curNode.right != null) {
                    queue.offer(new Doublet(curNode.right, curLevel + 1));
                }
                if (!tm.containsKey(curLevel)) {
                    tm.put(curLevel, curData);
                }
                queue.poll();
            }
        }
        for (Map.Entry<Integer, Integer> map : tm.entrySet()) {
            list.add(map.getValue());
        }
        return list;
    }
}
class Doublet {
    NodeBT node;
    int level;

    public Doublet(NodeBT node, int level) {
        this.node = node;
        this.level = level;
    }
}
