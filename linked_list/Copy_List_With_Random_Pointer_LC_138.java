package linked_list;

import java.util.HashMap;

class NodeR {
    int val;
    NodeR next;
    NodeR random;

    public NodeR(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Copy_List_With_Random_Pointer_LC_138 {
    public static void main(String[] args) {

    }

    // Approach 1 : With HashMap
//    public NodeR copyRandomList(NodeR head) {
//        NodeR temp = head;
//        HashMap<NodeR, NodeR> map = new HashMap<>();
//        while (temp != null) {
//            NodeR newNode = new NodeR(temp.val);
//            map.put(temp, newNode);
//            temp = temp.next;
//        }
//        temp = head;
//        while (temp != null) {
//            NodeR copyNode = map.get(temp);
//            copyNode.next = map.get(temp.next);
//            copyNode.random = map.get(temp.random);
//            temp = temp.next;
//        }
//        return map.get(head);
//    }

    // Approach 2 : Without HashMap
    public NodeR copyRandomList(NodeR head) {
        NodeR temp = head;
        while (temp != null) {
            NodeR newNode = new NodeR(temp.val);
            newNode.next = temp.next; // we store the copyNode in between the original nodes
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;

        // to connect the random pointer of the copy Node
        while (temp != null) {
            NodeR copyNode = temp.next;
            NodeR randomOfTemp = temp.random;
            if (randomOfTemp != null) {
                copyNode.random = randomOfTemp.next;
            }
            else { // randomOfTemp == null
                copyNode.random = null;
            }
            temp = temp.next.next;
        }

        NodeR dummyNode = new NodeR(-1);
        temp = head;
        NodeR dummyTemp = dummyNode;

        // to connect the next pointer to appropriate nodes
        while (temp != null) {
            dummyTemp.next = temp.next;
            temp.next = temp.next.next;
            dummyTemp = dummyTemp.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}
