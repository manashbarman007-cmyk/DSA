package linked_list;
import linked_list.Node;

public class Add_Two_Numbers_CN {
    public static void main(String[] args) {
       int[] arr1 = {4, 5, 9, 9};
       int[] arr2 = {3, 5};
       Node head1 = convertArrToLL(arr1);
       Node head2 = convertArrToLL(arr2);
       Node newHead = addTwoNumbers(head1, head2);
       Node temp = newHead;
       while (temp != null) {
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
    }

    static Node addTwoNumbers(Node head1, Node head2) {
        // Write your code here.
        Node temp1 = head1;
        Node temp2 = head2;
        int carry = 0;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
           if (temp1 != null) {
               sum += temp1.data;
           }
           if (temp2 != null) {
               sum += temp2.data;
           }
            Node newNode = new Node(sum % 10);
             carry = sum / 10;
             current.next = newNode;
             current = newNode;
             if (temp1 != null) {
                 temp1 = temp1.next;
             }
             if (temp2 != null) {
                 temp2 = temp2.next;
             }
        }
        // if a carry remains we store it in a new node
        if (carry > 0) {
            Node newNode = new Node(carry);
            current.next = newNode;
        }
        Node newHead = dummyNode.next;
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
