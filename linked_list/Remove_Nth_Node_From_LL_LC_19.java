package linked_list;

public class Remove_Nth_Node_From_LL_LC_19 {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrToLL(arr);
        Node newHead = obj.removeNthFromEnd(head, 5);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public Node removeNthFromEnd(Node head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        Node prev = null;
        temp = head;
        int counter = 0, deleteNode = length - n + 1;
        while (temp != null) {
            counter++;
            if (deleteNode == 1) {
                head = head.next;
                return head;
            }
            else {
                if (counter == deleteNode) {
                    prev.next = temp.next;
                }
            }
            prev = temp;
            temp = temp.next;
        }
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
