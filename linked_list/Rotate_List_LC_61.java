package linked_list;

public class Rotate_List_LC_61 {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr = {1, 2, 3, 4, 5};
        Node head = obj.convertArrToLL(arr);
        Node newHead = rotateRight(head,2);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static  Node rotateRight(Node head, int k) {
       if (head == null || k == 0) {
            return head;
       }
       Node temp = head;
       Node tailNode = null;
       int length = 0;
       while (temp != null) {
           length++;
           tailNode = temp;
           temp = temp.next;
       }
       if (k % length == 0) { // ie ultimately the LL is at its original state
           return head;
       }
       temp = head;
       int pos = length - (k % length); // the position of the newTailNode (1 based indexing)
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        Node newTailNode = temp;
        tailNode.next = head;
        Node newHead = newTailNode.next;
        newTailNode.next = null;
        return newHead;
    }
}
