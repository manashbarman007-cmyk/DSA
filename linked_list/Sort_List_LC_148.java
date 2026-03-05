package linked_list;

public class Sort_List_LC_148 {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {4, 2, 1, 3, 5};
        Node head = obj.convertArrToLL(arr);
        Node newHead = sortList(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node sortList(Node head) {
        // base case
       if (head == null || head.next == null) {
           return head;
       }
       Node mid = findMidNode(head);
       Node rightHead = mid.next;
       Node leftHead = head;
       mid.next = null;
       leftHead = sortList(leftHead);
       rightHead = sortList(rightHead);
       return merge2LL(leftHead, rightHead); // merge while backtracking
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

    static Node findMidNode (Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node midNode = slow;
        return midNode;
    }
}
