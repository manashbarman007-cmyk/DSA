package linked_list;
import linked_list.Node; // we import the Node class from earlier

public class Insertion_And_Deletion_In_LL {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9};
        Node head = convertArrToLL(arr); // the array has been converted to a LL
        System.out.println(head.data);
//        Node newHead = deleteHead(head);
//        Node newHead = deleteTail(head);
//        System.out.println(newHead.data);
//        Node newHead = delete_k_th_node(head, 8);
//        Node newHead = delete_node_based_on_val(head, 19);
//        Node newHead = insertAtHead(head, 4);
//        Node newHead = insert_at_k_th_node(head,2, 7);
        Node newHead = insert_val_in_front_x(head, 7, 9);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // move the temp to the next element
        }
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

    // DELETION:

    // 1. delete head
    static Node deleteHead (Node head) {
        if (head == null) {
            return null;
        }
        head = head.next; // we move the head to the next node
                          // the current head is deleted by the garbage collector automatically in the future
        return head;
    }

    // 2. delete tail
    static Node deleteTail (Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head; // we create a temp ref so that we don't temper the actual head
        while (temp.next.next != null) {
            temp = temp.next; // we move the temp to the next element
            // the current tail is deleted by the garbage collector automatically in the future
        }
        temp.next = null; // the new tail points to the null
        return head; // we return the modified head
    }

    // 3. delete k-th node (k : position of the node)
    static Node delete_k_th_node (Node head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) { // ie we have to delete the first node
           return head.next; // we shift the head to the next element
        }
        int length = 0;
        Node temp = head;
        Node prev = null; // initialize as null
        while (temp != null) {
            length++;
            if (length == k) {
               prev.next = prev.next.next;
               break;
            }
            prev = temp; // the prev is shifted to temp
            temp = temp.next; // the temp is shifted to the next element
        }
        return head; // if k > length then nothing is removed
    }

    // 4. deleting a node based on its value
    static Node delete_node_based_on_val (Node head, int val) {
        if (head == null) {
            return null;
        }
        if (val == head.data) { // ie we have to delete the first node
           return head.next; // we shift the head to the next element
        }
        Node temp = head;
        Node prev = null; // initialize as null
        while (temp != null) {
            if (temp.data == val) {
               prev.next = prev.next.next;
               break;
            }
            prev = temp; // the prev is shifted to temp
            temp = temp.next; // the temp is shifted to the next element
        }
        return head; // if k > length then nothing is removed
    }

    // INSERTION

    // 1. Insertion at the head of the LL
    static Node insertAtHead (Node head, int val) {
        Node newInsertedHead = new Node(val, head);
        return newInsertedHead;
    }

    // 2. Insertion at the tail of the LL
    static Node insertAtTAil (Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node newTail = new Node(val); // it points to null
        Node temp =  head;
        while (temp.next != null) { // note the condition carefully
            temp = temp.next; // we do that so that temp is at the previous tail
        }
        temp.next = newTail; // therefore, the temp (previous tail) is pointing to the new tail
        return head;
    }

    // 3. Insertion at the k-th node (k : position of the node)
    static Node insert_at_k_th_node (Node head, int k, int val) {
        if (head == null) {
            if (k == 1) {
                return new Node(val);
            }
            return null; // else case
        }
        if (k == 1) {
            return new Node(val, head); // the new node will point to the head
        }
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            if (length == k - 1) {  // we stop at the previous node
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break; // we exit the loop
            }
            temp = temp.next;
        }
        return head;
    }

    // 4. Insert 'val' in front of 'x'
    static Node insert_val_in_front_x (Node head, int val, int x) {
        if (head.data == x) {
            return new Node(val, head);
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == x) {
                Node newNode = new Node(val, temp);
                prev.next = newNode;
                break; // we exit the loop
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
 }
