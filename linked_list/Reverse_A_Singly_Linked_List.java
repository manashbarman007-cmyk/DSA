package linked_list;

import java.util.Stack;

public class Reverse_A_Singly_Linked_List {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {1, 1, 2, 1};
        Node head = convertArrToLL(arr);
        Node newHead = reverseLL(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Approach 1 : Brute force
//    static Node reverseLL (Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Stack<Integer> stack = new Stack<>();
//        Node temp = head;
//        while (temp != null) {
//            stack.push(temp.data);
//            temp = temp.next;
//        }
//        temp = head;
//        while (temp != null) {
//            temp.data = stack.pop();
//            temp = temp.next;
//        }
//        return head;
//    }

    // Approach 2 : Iterative method (Optimised)
    static Node reverseLL (Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next; // we store the next node in 'front' as in the next step the next node will be
                                    // changed to 'prev'
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }


    // Approach 3 : Recursive
//    static Node reverseLL (Node head) {
//        // base case
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Node newHead = reverseLL(head.next);
//        Node front = head.next;
//        front.next = head;
//        head.next = null;
//        return newHead;
//    }

    static Node convertArrToLL (int[] arr) {
        int n = arr.length;
        Node head = new Node(arr[0]); // creating the head node with next pointer as 'null' initially
        Node mover = head; // creating a mover reference to set the next pointers
        for (int i = 1; i < n; i++) {
            Node temp = new Node(arr[i]); // we create the i-th node with next as null
            mover.next = temp; // the previous node points to the i-th node
            mover = temp; // we give the move to the i-th node
        }
        return head;
    }
}
