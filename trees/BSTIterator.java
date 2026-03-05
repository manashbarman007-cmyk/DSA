package trees;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

// Approach 1
//public class BSTIterator {
//    NodeBT root;
//    List<NodeBT> list;
//    int pointer;
//
//
//    public BSTIterator(NodeBT root) {
//        this.root = root;
//        pointer = -1;
//        list = new ArrayList<>();
//        inorder(root, list);
//    }
//
//    public void inorder (NodeBT root, List<NodeBT> list) {
//        if (root == null) return;
//
//        inorder(root.left, list);
//        list.add(root);
//        inorder(root.right, list);
//    }
//
//    public int next() {
//        pointer++;
//        return list.get(pointer).data;
//    }
//
//    public boolean hasNext() {
//        int n = list.size();
//        return (pointer < n - 1); // returns true when pointer < (n - 1)
//    }
//}

// Approach 2
public class BSTIterator {
    NodeBT root;
    Stack<NodeBT> stack;


    public BSTIterator(NodeBT root) {
        this.root = root;
        stack = new Stack<>();
        insert(root, stack );
    }

    public void insert (NodeBT root, Stack<NodeBT> stack) {
        NodeBT temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    public int next() {
        NodeBT curNode = stack.pop();
        insert(curNode.right, stack);
        return curNode.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty(); // returns true when stack is not empty
    }
}
