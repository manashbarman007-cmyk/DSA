package linked_list;

public class Delete_All_Occurrences_Of_A_Given_Key_In_DLL_CN {
    public static void main(String[] args) {
        Doubly_Linked_List_Intro obj = new Doubly_Linked_List_Intro();
        int[] arr1 = {10, 4, 10, 3, 5, 20, 10};
        int[] arr2 = {10, 10, 10, 10};
        Node_Dll head = obj.convertArrToDll(arr1);
        Node_Dll newHead = deleteAllOccurrences(head, 10);
        Node_Dll temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
    public static Node_Dll deleteAllOccurrences(Node_Dll head, int k) {
        // Write your code here.
        if (head == null) {
            return null;
        }
        if (head.next == null && head.data == k) {
            return null;
        }
        Node_Dll headNext = head.next;
        if (head.data == k) {
            head = head.next;
            headNext.back = null;
        }
        Node_Dll temp = head;
        Node_Dll prev = null;
        while (temp != null) {
            Node_Dll front = temp.next;
            if (temp.data == k) {
                if (front != null) {
                    if (prev != null) {
                        temp.back = null;
                        temp.next = null;
                        prev.next = front;
                        front.back = prev;
                    }
                    else { // if prev == null
                        temp.next = null;
                        front.back = prev;
                    }
                }
                else {
                    if (prev != null) {
                        prev.next = null;
                    }
                    else {
                       return null;
                    }
                }
            }
            if (temp.data != k) {
                prev = temp;
            }
            temp = front;
        }
        return head;
    }
}
