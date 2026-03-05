package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class All_Three_Traversal {
    public static void main(String[] args) {

    }

    static void all3Traversal (NodeBT root) {
        Stack<Pair> stack = new Stack<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair curVal = stack.pop();
            if (curVal.num == 1) {
                preOrder.add(curVal.node.data);
                curVal.num++; // 1 is incremented to 2
                stack.push(curVal);
                if (curVal.node.left != null) {
                    stack.push(new Pair(curVal.node.left, 1));
                }
            }
            else if (curVal.num == 2) {
                inOrder.add(curVal.node.data);
                curVal.num++; // 2 is incremented to 3
                stack.push(curVal);
                if (curVal.node.right != null) {
                    stack.push(new Pair(curVal.node.right, 1));
                }
            }
            else { //ie if (curVal.num == 3)
                postOrder.add(curVal.node.data);
            }
        }
    }
}

class Pair {
    NodeBT node;
    int num;

    public Pair(NodeBT node, int num) {
        this.node = node;
        this.num = num;
    }
}


