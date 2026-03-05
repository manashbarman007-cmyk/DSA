package trees;
import java.util.*;

public class Vertical_Order_Traversal {
    public static void main(String[] args) {
        Vertical_Order_Traversal obj = new Vertical_Order_Traversal();
//        NodeBT root = new NodeBT(1);
//        root.left = new NodeBT(2);
//        root.left.left = new NodeBT(4);
//        root.left.right = new NodeBT(10);
//        root.left.left.right = new NodeBT(5);
//        root.left.left.right.right = new NodeBT(6);
//        root.right = new NodeBT(3);
//        root.right.left = new NodeBT(9);
//        root.right.right = new NodeBT(10);

//        NodeBT root = new NodeBT(5);
//        root.left = new NodeBT(2);
//        root.right = new NodeBT(3);
//        root.left.left = new NodeBT(4);
//        root.left.right = new NodeBT(2);
//        root.right.left = new NodeBT(2);
//        root.right.right = new NodeBT(7);

        NodeBT root = new NodeBT(0);
        root.left = new NodeBT(8);
        root.right = new NodeBT(1);
        root.right.left = new NodeBT(3);
        root.right.left.right = new NodeBT(4);
        root.right.left.right.right = new NodeBT(7);
        root.right.right = new NodeBT(2);
        root.right.right.left = new NodeBT(5);
        root.right.right.left.left = new NodeBT(6);


        System.out.println(obj.verticalTraversal(root));
    }
    public List<List<Integer>> verticalTraversal(NodeBT root) {
        ArrayList<Assign> assign = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        int minVertical = Integer.MAX_VALUE, maxVertical = Integer.MIN_VALUE;

        dfs(root, 0, 0, assign);

        int n = assign.size();

        // sort in ascending order on the basis of vertical coordinates
//        Collections.sort(assign, (a, b) -> a.level - b.level);
//        System.out.println(assign);

        for (int i = 0; i < n; i++) {
            minLevel = Math.min(minLevel, assign.get(i).level);
            maxLevel = Math.max(maxLevel, assign.get(i).level);
            minVertical = Math.min(minVertical, assign.get(i).vertical);
            maxVertical = Math.max(maxVertical, assign.get(i).vertical);
        }

        for (int vertical = minVertical; vertical <= maxVertical; vertical++) {
            List<Integer> sublist = new ArrayList<>();
            int count_vertical = 0; // counts the number of nodes with a particular vertical
            for (int ind = 0; ind < n; ind++) {
                if (assign.get(ind).vertical == vertical) {
                    count_vertical++;
                }
            }
            int ind = 0;
            while (count_vertical > 0 && ind < n) {
                if (assign.get(ind).vertical == vertical) {
                    if (ind < n -1 && assign.get(ind).vertical == assign.get(ind + 1).vertical &&
                            assign.get(ind).level == assign.get(ind + 1).level) {
                        Collections.sort(assign, (a, b) -> a.node.data - b.node.data);
                    }
                    sublist.add(assign.get(ind).node.data);
                    count_vertical--;
                }
                ind++;
            }
//            Collections.sort(sublist);
            list.add(sublist);
        }
        return list;
    }

    static void dfs (NodeBT node, int level, int vertical, ArrayList<Assign> assign) {
        if (node == null) {
            return;
        }
        assign.add(new Assign(node, level, vertical));
        dfs(node.left, level + 1, vertical - 1, assign);
        dfs(node.right, level + 1, vertical + 1, assign);
    }
}

class Assign {
    NodeBT node;
    int level;
    int vertical;

    public Assign(NodeBT node, int level, int vertical) {
        this.node = node;
        this.level = level;
        this.vertical = vertical;
    }
}
