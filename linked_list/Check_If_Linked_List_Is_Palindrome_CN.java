package linked_list;

public class Check_If_Linked_List_Is_Palindrome_CN {
    public static void main(String[] args) {
        Reverse_A_Singly_Linked_List obj = new Reverse_A_Singly_Linked_List();
        int [] arr1 = {1, 2, 3, 4};
        Node head = obj.convertArrToLL(arr1);
        System.out.println(isPalindrome(head));
        }

    public static boolean isPalindrome(Node head) {
        // write your code here
        boolean isPalinrome = true;
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Node temp = head;
        Node original_LL = new Node(-1); // dummy node
        Node temp1 = original_LL;
        Node prev = null;
        while (temp != null) {
            Node newNode = new Node(temp.data); // we create a new LL to preserve the given LL
            temp1.next = newNode;
            temp1 = newNode;

            // code to reverse the given LL
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        temp1.next = null;
        Node newHead = prev;
        temp1 = original_LL.next;

        Node newTemp = newHead;

        while (temp1 != null) {
            if (temp1.data != newTemp.data) {
                isPalinrome = false; // not a palindrome
                break;
            }
            temp1 = temp1.next;
            newTemp = newTemp.next;
        }
        return isPalinrome;
    }

}
