package linked_list;

import java.util.HashMap;

public class Linked_List_Cycle_LC_141 {
    public static void main(String[] args) {

    }

    // Approach 1 : Using Hashing (TC = O(n * 2 * log n))
//    public static boolean hasCycle(Node head) {
//        boolean isCyclic = false;
//        if (head == null) {
//            return false;
//        }
//        HashMap<Node, Integer> map = new HashMap<>();
//        Node temp = head;
//
//        while (temp != null) {
//           if (map.containsKey(temp)) {
//               return true;
//           }
//           else {
//               map.put(temp, 1);
//           }
//           temp = temp.next;
//        }
//        return false; // if the LL is not cyclic
//    }

    // Approach 1 : Tortoise and Hare Algorithm
    public static boolean hasCycle(Node head) {
        boolean isCyclic = false;
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
           fast = fast.next.next; // moves forward by two nodes
           slow = slow.next; // moves forward by one node
            if (fast == slow) {
                isCyclic = true;
                break;
            }
        }
        return isCyclic; // if the LL is not cyclic
    }
}
