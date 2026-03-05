package linked_list;

public class Middlle_Of_Linked_List_CN {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {4, 1, 8, 4, 5, 9};
        Node head = obj.convertArrToLL(arr);
        Node newHead = findMiddle(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node findMiddle(Node head)
    {
        // Write your code here.
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int midNode = (length / 2) + 1;
        int count = 0;
        temp = head;
        while (temp != null) {
            count++;
            if (count == midNode) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // returning a dummy null
    }
}
