package linked_list;

import java.util.Collections;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists_LC_23 {
    public static void main(String[] args) {

    }

    // Approach 1 : Recursive
    // main func
    public Node mergeKLists(Node[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeArray(lists, 0);
    }

    // recursive helper func1
    static Node mergeArray (Node[] lists, int ind) {
        int n = lists.length;
        // base case
        if (ind == n - 1) {
            return lists[ind];
        }
        Node mergeHead = mergeArray(lists, ind + 1);
        Node newHead = merge2LL(lists[ind], mergeHead);  // merge while backtracking
        return newHead;
    }
    // helper func2
    static Node merge2LL (Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummyNode = new Node(-1);
        Node dummyTemp = dummyNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                dummyTemp.next = temp1;
                dummyTemp = dummyTemp.next;
                temp1 = temp1.next;
            }
            else { // if temp2.data < temp1.data
                dummyTemp.next = temp2;
                dummyTemp = dummyTemp.next;
                temp2 = temp2.next;
            }
        }
        if (temp1 == null && temp2 != null) { // as each lists are sorted
            dummyTemp.next = temp2;
        }
        else { // if temp2 == null && temp1 != null
            dummyTemp.next = temp1;
        }
        Node newHead = dummyNode.next;
        return newHead;
    }


    
}

// Using PriorityQueue

// class Solution {
//     public Node mergeKLists(Node[] lists) {

//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (Node head : lists) {
//             Node temp = head;
//             while (temp != null) {
//                 pq.offer(temp.data);
//                 temp = temp.next;
//             }
//         }
        
//         Node dummy = new Node(-1);
//         Node cur = dummy;
//         while (!pq.isEmpty()) {
//             cur.next = new Node(pq.poll());
//             cur = cur.next;
//         }
//         return dummy.next;
//     }
// }
