package linked_list;

public class Odd_Even_Linked_List_LC_328 {
    public static void main(String[] args) {
        Odd_Even_Linked_List_LC_328 obj = new Odd_Even_Linked_List_LC_328();
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrToLL(arr);
        Node newHead = obj.oddEvenList(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
    public Node oddEvenList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node currOddNode = head;
        Node currEvenNode = head.next;
        Node currEvenNodeHead = currEvenNode;

        while (currEvenNode != null && currEvenNode.next != null) {
            currOddNode.next = currOddNode.next.next;
            currEvenNode.next = currEvenNode.next.next;

            currOddNode = currOddNode.next;
            currEvenNode = currEvenNode.next;

        }
        currOddNode.next = currEvenNodeHead;
        return head;
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
