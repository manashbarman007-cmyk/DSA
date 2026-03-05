package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_Traversal {
    public static void main(String[] args) {

    }

    // 1 : PreOrder Traversal
    static List<Integer> preOrder (NodeBT root) {
        Stack<NodeBT> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

    // 2 : InOrder Traversal
    static List<Integer> inOrder (NodeBT root) {
        Stack<NodeBT> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        NodeBT node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else { // if node == null
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }


    // 3(a) : PostOrder Traversal (Using 2 stacks)
    static List<Integer> postOrder2 (NodeBT root) {
        Stack<NodeBT> stack1 = new Stack<>();
        Stack<NodeBT> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack1.push(root);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
            NodeBT node = stack2.peek();
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().data);
        }
        return list;
    }

    // 3(b) : PostOrder Traversal (Using 1 stacks)
    static List<Integer> postOrder1 (NodeBT root) {
        Stack<NodeBT> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        NodeBT curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            else { // if curNode == null
                NodeBT temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    list.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.data);
                    }
                }
                else { // if temp != null
                    curNode = temp;
                }
            }
        }
        return list;
    }
}
