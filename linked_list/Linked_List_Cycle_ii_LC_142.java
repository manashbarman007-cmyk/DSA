package linked_list;

import java.util.HashMap;

public class Linked_List_Cycle_ii_LC_142 {
    public static void main(String[] args) {

    }

    // Approach 1 : Hashing
//    public Node detectCycle(Node head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        Node temp = head;
//        HashMap<Node, Integer> map = new HashMap<>();
//        while (temp != null) {
//            if (map.containsKey(temp)) {
//                return temp;
//            }
//            else {
//                map.put(temp, 1);
//            }
//            temp = temp.next;
//        }
//        return null; // returning a null if the LL is not cyclic
//    }

    // Approach 2 : Tortoise And Hare Algorithm
    public Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        if (slow == fast) { // ie head itself is the start of the cycle
            return head;
        }
        while (fast != null) {
            if (slow.next == fast.next) {
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null; // returning a null if the LL is not cyclic
    }
}
