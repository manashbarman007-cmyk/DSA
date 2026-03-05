package trees;
import java.util.*;

public class Inorder_Successor_And_Predecessor_In_BST {
    NodeBT predecessor = null, successor = null;
    public static void main(String[] args) {

    }

    // Approach 1
//    public ArrayList<NodeBT> findPreSuc(NodeBT root, int key) {
//        // code here
//        ArrayList<Integer> list = new ArrayList<>();
//        HashMap<Integer, NodeBT> hm = new HashMap<>();
//        inorder(root, list, hm);
//        NodeBT predecessor = getFloor(list, hm, key);
//        NodeBT successor = getCeil(list, hm, key);
//        ArrayList<NodeBT> result = new ArrayList<>();
//        result.add(predecessor);
//        result.add(successor);
//
//        return result;
//    }
//    public void inorder(NodeBT root, ArrayList<Integer> list, HashMap<Integer, NodeBT> hm) {
//        if (root == null) return;
//
//        inorder(root.left, list, hm);
//        hm.put(root.data, root);
//        list.add(root.data);
//        inorder(root.right, list, hm);
//    }
//    public NodeBT getFloor (ArrayList<Integer> list, HashMap<Integer, NodeBT> hm, int key) {
//        int n = hm.size();
//        int floor = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            if (list.get(i) < key) floor = Math.max(floor, list.get(i));
//        }
//        return hm.getOrDefault(floor, null);
//    }
//
//    public NodeBT getCeil (ArrayList<Integer> list, HashMap<Integer, NodeBT> hm, int key) {
//        int n = hm.size();
//        int ceil = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            if (list.get(i) > key) ceil = Math.min(ceil, list.get(i));
//        }
//        return hm.getOrDefault(ceil, null);
//    }

    public ArrayList<NodeBT> findPreSuc(NodeBT root, int key) {
        findPredecessor(root, key);
        findSuccessor(root, key);
        ArrayList<NodeBT> list = new ArrayList<>();
        list.add(predecessor);
        list.add(successor);
        return list;
    }
    public void findPredecessor (NodeBT root, int key) {
        if (root == null) {
            return;
        }
        if (key <= root.data) {
            findPredecessor(root.left, key);
        }
        else { // if (key > root.data)
            predecessor = root;
            findPredecessor(root.right, key);
        }
    }
    public void findSuccessor (NodeBT root, int key) {
        if (root == null) {
            return;
        }
        if (key < root.data) { // we get the potential answer here
            successor = root;
            findSuccessor(root.left, key);
        }
        else { // if (key >= root.data)
            findSuccessor(root.right, key);
        }
    }
}
