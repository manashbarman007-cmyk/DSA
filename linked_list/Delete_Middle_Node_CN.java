package linked_list;

public class Delete_Middle_Node_CN {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {4, 1, 8};
        Node head = obj.convertArrToLL(arr);
        Node newHead = deleteMiddle(head);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node deleteMiddle(Node head) {
        // Write your code here.
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
