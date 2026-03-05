package linked_list;

public class Doubly_Linked_List_Intro {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3};
        Node_Dll head = convertArrToDll(arr);
//        Node_Dll temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();


//        Node_Dll newHead = deleteHeadNode(head);
//        Node_Dll newHead = deleteTailNode(head);
//        Node_Dll newHead = delete_K_Node(head, 3);
//         deleteGivenNode(head.next.next.next.next);
//        Node_Dll newHead = insertIn_frontHead(head, 7);
//        Node_Dll newHead = insertIn_frontTail(head, 9);
//        Node_Dll newHead = insertIn_front_kth_Node(head, 9, 5);
        insertIn_front_GivenNode(head.next.next.next.next, 9);
        Node_Dll newHead = head;

        Node_Dll temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    static Node_Dll convertArrToDll (int[] arr) {
        int n = arr.length;
        Node_Dll head = new Node_Dll(arr[0]); // the next and back are set to 'null' initially
        Node_Dll prev = head; // we create a copy as we do not want to temper with the head
        for (int i = 1; i < n; i++) {
            Node_Dll temp = new Node_Dll(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    // DELETION

    // 1. Deleting the head node
    static Node_Dll deleteHeadNode (Node_Dll head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) { // ie the DLL has only one element
            return null;
        }
        Node_Dll prev = head;
        head = head.next; // we move the head to the next node
        head.back = null;
        prev.next = null;
        return head;
    }

    // 2. Deleting the tail node
    static Node_Dll deleteTailNode (Node_Dll head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node_Dll temp = head;
        Node_Dll prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.back = null;

        return head;
    }

    // 3. Delete the k-th node of DLL (k : position of the node)
    static Node_Dll delete_K_Node (Node_Dll head, int  k) {
        if (head.next == null) {
            if (k == 1) {
                return null;
            }
        }
        if (k == 1) { // ie to delete the head node
            Node_Dll prev = head;
            head = head.next; // we move the head to the next node
            head.back = null;
            prev.next = null;
        }

        Node_Dll temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k && k > 1) {
                if (temp.next != null) {
                    Node_Dll prevNode = temp.back;
                    Node_Dll nextNode = temp.next;
                    temp.back = null;
                    temp.next = null;
                    prevNode.next = nextNode;
                    nextNode.back = prevNode;
                    break;
                }
                else { // ie to delete the tail node
                    Node_Dll prevNode = temp.back;
                    temp.back = null;
                    prevNode.next = null;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    // 4. Delete a given node
    static void deleteGivenNode (Node_Dll node) {
        if (node.next == null) { // if the given node is the tail node
            Node_Dll prevNode = node.back;
            prevNode.next = null;
            node.back = null;
            return; // we will exit the method and no longer continue and return to the caller method
        }
        Node_Dll prevNode = node.back;
        Node_Dll nextNode = node.next;
        node.back = null;
        node.next = null;
        prevNode.next = nextNode;
        nextNode.back = prevNode;
    }


    // INSERTION

    // 1. Insertion in front of the head
    static Node_Dll insertIn_frontHead (Node_Dll head, int val) {
        if (head == null) {
            return new Node_Dll(val);
        }
        Node_Dll newHead = new Node_Dll(val, head, null);
        head.back = newHead;
        return newHead;
    }

    // 2. Insertion in front of the tail
    static Node_Dll insertIn_frontTail (Node_Dll head, int val) {
        if (head == null) {
            return new Node_Dll(val);
        }
        Node_Dll temp = head;
        while (temp != null) {
            if (temp.next == null) {
                Node_Dll prevNode = temp.back;
                Node_Dll newNode = new Node_Dll(val, temp, prevNode);
                prevNode.next = newNode;
                temp.back = newNode;
            }
            temp = temp.next; // we move the temp to the next node
        }
        return head;
    }

    // 3. Insertion in front of k-th node
    static Node_Dll insertIn_front_kth_Node (Node_Dll head, int val, int k) {
        if (k == 1) {
            Node_Dll newNode = new Node_Dll(val, head, null);
            head.back = newNode;
            return newNode;
        }
        int counter = 0;
        Node_Dll temp = head;
        while (temp != null) {
            counter++;
            if (counter == k) {
                Node_Dll prevNode = temp.back;
                Node_Dll newNode = new Node_Dll(val, temp, prevNode);
                temp.back = newNode;
                prevNode.next = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    // 4. Insertion before a given node
    static void insertIn_front_GivenNode (Node_Dll node, int val) {
        Node_Dll prevNode = node.back;
        Node_Dll newNode = new Node_Dll(val, node, prevNode);
        node.back = newNode;
        prevNode.next = newNode;
    }
}

class Node_Dll {
    public int data;
    public Node_Dll next; // pointer to store the address of the next node
    public Node_Dll back; // pointer to store the address of the previous node

    // Constructor 1
    Node_Dll (int data1, Node_Dll next1, Node_Dll back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    //Constructor 2
    Node_Dll (int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
