package trees;
import java.util.*;

public class Check_If_Two_BT_Are_Same {
    public static void main(String[] args) {

    }
    public boolean isSameTree(NodeBT p, NodeBT q) {
        if (!dfs(p, q)) return false;

        return true;
    }

    static boolean dfs (NodeBT node1, NodeBT node2) {

        //base case1
        if (node1 == null && node2 == null) { // if both node1 and node2 are null att the same time
            return true;
        }
        //base case2
        if (node1 == null || node2 == null) { // if only one of node 1 or node2 is null (ie not identical trees)
            return false;
        }

        boolean moveLeft = dfs(node1.left, node2.left);
        boolean moveRight = dfs(node1.right, node2.right);

        if (node1.data != node2.data) {
            return false;
        }

        if (!moveLeft || !moveRight) { // if either func returns a false then return a false
            return false;
        }

        return true;
    }
}
