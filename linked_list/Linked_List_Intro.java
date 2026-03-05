package linked_list;

public class Linked_List_Intro {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6};
        //creating a new node with a value from the array
        Node y = new Node(arr[0]); // we are using the second constructor where next = null
        System.out.println(y.data);
        Node head = convertArrToLL(arr); // arr is converted to LL
        System.out.println(head.data);

        // traversing a ll
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();

        System.out.println(lengthOfLL(head));

        System.out.println(doesExist(head, 2));
    }

    static int lengthOfLL (Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
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

    static boolean doesExist (Node head, int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

class Node {
    int data; // the data value
    Node next; // the reference to the next node in linked list

    // Constructor
    public Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    public Node(int data1) { // we use this constructor when we need 'null' for the next pointer
        this.data = data1;
        this.next = null;
    }
}
