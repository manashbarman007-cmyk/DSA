package trees;

import java.util.ArrayList;
import java.util.List;

public class Morris_Traversal {
    public static void main(String[] args) {

    }
    static List<Integer> inorder (NodeBT root) {
        NodeBT curNode = root;
        List<Integer> list = new ArrayList<>();
        while (curNode != null) {
            // case 1 : if there is no left subtree
            if (curNode.left == null) {
                list.add(curNode.data);
                curNode = curNode.right;
            }

            // case 2 and 3 : if there is a left subtree and the rightmost node of the left subtree in not yet linked
                           // or if the rightmost node of the left subtree is already connected to curNode
            else {
                NodeBT mover = curNode.left;
                while (mover.right != null && mover.right != curNode) {
                    mover = mover.right;
                }
                if (mover.right == null){
                    mover.right = curNode; // the thread is created
                    curNode = curNode.left;
                }
                else { // if (mover.right == curNode)
                    mover.right = null; // the thread is broken
                    list.add(curNode.data);
                    curNode = curNode.right;
                }
            }
        }
        return list;
    }

    static List<Integer> preorder (NodeBT root) {
        NodeBT curNode = root;
        List<Integer> list = new ArrayList<>();
        while (curNode != null) {
            // case 1 : if there is no left subtree
            if (curNode.left == null) {
                list.add(curNode.data);
                curNode = curNode.right;
            }

            // case 2 and 3 : if there is a left subtree and the rightmost node of the left subtree in not yet linked
                           // or if the rightmost node of the left subtree is already connected to curNode
            else {
                NodeBT mover = curNode.left;
                while (mover.right != null && mover.right != curNode) {
                    mover = mover.right;
                }
                if (mover.right == null){
                    mover.right = curNode; // the thread is created
                    list.add(curNode.data);
                    curNode = curNode.left;
                }
                else { // if (mover.right == curNode)
                    mover.right = null; // the thread is broken
                    curNode = curNode.right;
                }
            }
        }
        return list;
    }
}
