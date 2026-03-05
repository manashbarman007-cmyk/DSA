package linked_list;

public class Add_1_To_A_Num_Represented_By_LL_CN {
    public static void main(String[] args) {
        Reverse_A_Singly_Linked_List obj = new Reverse_A_Singly_Linked_List();
        int [] arr1 = {9, 9, 9};
        Node head = obj.convertArrToLL(arr1);
        Node newHead = addOne(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node addOne(Node head) {
        // Write your code here.

        // Step 1 : Reverse the LL
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next; // we store the next node in 'front' as in the next step the next node will be
            // changed to 'prev'
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        // Step 2 : add '+1' to the head of the reversed LL and store them in a new LL
        Node newTemp = prev;
        int carry = 0;
        Node dummyNode = new Node(-1); // create a new LL
        Node varTemp = dummyNode;
        while (newTemp != null) {
            if (newTemp == prev) { // we add 1 only to the head
                Node sumNode = new Node((newTemp.data + 1) % 10);
                carry = (newTemp.data + 1) / 10;
                varTemp.next = sumNode;
            }
            else {
                Node sumNode = new Node((newTemp.data + carry) % 10);
                carry = (newTemp.data + carry) / 10;
                varTemp.next = sumNode;
            }
            varTemp = varTemp.next;
            newTemp = newTemp.next;
        }
        if (carry > 0) {
            Node sumNode = new Node(carry);
            varTemp.next = sumNode;
        }

        // Step 3: Finally reverse newly created LL
        Node newHead = dummyNode.next;
        Node reverseTemp = newHead;
        Node reversePrev = null;
        // reverse the LL
        while (reverseTemp != null) {
            Node front = reverseTemp.next; // we store the next node in 'front' as in the next step the next node will be
                                          // changed to 'reversePrev'
            reverseTemp.next = reversePrev;
            reversePrev = reverseTemp;
            reverseTemp = front;
        }

        return reversePrev;
    }
}
