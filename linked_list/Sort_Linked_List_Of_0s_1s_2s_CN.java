package linked_list;

import java.util.Stack;

public class Sort_Linked_List_Of_0s_1s_2s_CN {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0, 2, 1};
        Node head = convertArrToLL(arr);
        Node newHead = sortList(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    // brute force, TC = O(2n)
//    public static Node sortList(Node head) {
//        // Write your code here
//        if (head == null || head.next == null) {
//            return head;
//        }
//        int count0 = 0, count1 = 0, count2 = 0;
//        Node temp = head;
//        while (temp != null) {
//            if (temp.data == 0) {
//                count0++;
//            } else if (temp.data == 1) {
//                count1++;
//            }else {
//                count2++;
//            }
//            temp = temp.next;
//        }
//        temp = head;
//        while (temp != null) {
//            if (count0 > 0){
//                if (temp.data != 0){
//                    temp.data = 0;
//                }
//                count0--;
//            }else if ( count1 > 0){
//                if (temp.data != 1){
//                    temp.data = 1;
//                }
//                count1--;
//            }else if (count2> 0){
//                if (temp.data != 2) {
//                    temp.data = 2;
//                }
//                count2--;
//            }
//            temp = temp.next;
//        }
//        return head;
//    }


    // Optimised, TC = O(n)
    public static Node sortList(Node head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        Node zeroHead = new Node(-1); // dummy node
        Node zero = zeroHead;
        Node oneHead = new Node(-1); // dummy node
        Node one = oneHead;
        Node twoHead = new Node(-1); // dummy node
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            }
            else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            }
            else { // if temp.data == 2
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        Node newHead = zeroHead.next;
        return newHead;
    }


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
