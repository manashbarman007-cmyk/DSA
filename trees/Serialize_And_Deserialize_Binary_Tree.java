package trees;

import java.util.*;

public class Serialize_And_Deserialize_Binary_Tree {
    public static void main(String[] args) {
        NodeBT root = new NodeBT(1);
        root.left = new NodeBT(2);
        root.right = new NodeBT(13);
        root.right.left = new NodeBT(4);
        root.right.right = new NodeBT(5);
        System.out.println(serialize(root));
        List<List<Integer>> list = levelOrderTraversal(deserialize(serialize(root)));
        System.out.println(list);
        System.out.println(serialize(deserialize(serialize(root))));
    }

    // Encodes a tree to a single string.
    public static String serialize(NodeBT root) {
        if (root == null) return "";

        String str = "";
        Queue<NodeBT>  queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeBT curNode = queue.poll();
                if (curNode == null) {
                    str += "#,";
                }
                else {
                    str += curNode.data + ",";
                }
                if (curNode != null) {
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static NodeBT deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] str = data.split(",");
        int n = str.length;
        Queue<NodeBT> queue = new LinkedList<>();
        NodeBT root = new NodeBT(Integer.parseInt(str[0]));
        queue.offer(root);
        for (int i = 1; i < n; i++) {
            NodeBT curNode = queue.poll();

            if (!str[i].equals("#")){
                curNode.left = new NodeBT(Integer.parseInt(str[i]));
                queue.offer(curNode.left);
            }
            if (!str[++i].equals("#")){
                curNode.right = new NodeBT(Integer.parseInt(str[i]));
                queue.offer(curNode.right);
            }
        }

        return root;
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
