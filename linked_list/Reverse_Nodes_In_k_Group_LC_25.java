package linked_list;

public class Reverse_Nodes_In_k_Group_LC_25 {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = obj.convertArrToLL(arr);
        Node newHead = reverseKGroup(head,3);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node reverseKGroup(Node head, int k) {
        // we need to figure out the kTh node
        Node temp = head;
        Node prevNode = null;
        while (temp != null) {
            Node kth_Node = findKthNode(temp, k);
            if (kth_Node == null) {
                if (prevNode != null) { // this executes only if prevNode exists
                    prevNode.next = temp; // as the last remaining block is kept as it is
                }
                break;
            }
            Node newNode = kth_Node.next; // we store the next node of kth node
            kth_Node.next = null; // we separate the kth node
            reverseLL(temp); // reverse each block
            if (temp == head) { // ie it is the first block
                head = kth_Node;
            }
            else {
               prevNode.next = kth_Node; // we connect the reversed blocks
            }
            prevNode = temp;
            temp = newNode;
        }
        return head;
    }

    // This func will reverse the LL
    static Node reverseLL (Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        Node newHead = prev;
        return newHead;
    }

    // This func will find the kth node
    static Node findKthNode (Node head, int k) {
        Node temp = head;
        while (temp != null && k > 1) {
            k--;
            temp = temp.next;
        }
        Node kth_Node = temp;
        return kth_Node;
    }
}
