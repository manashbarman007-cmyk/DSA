package linked_list;

import java.util.List;

public class Remove_Duplicates_From_A_Sorted_DLL_CN {
    public static void main(String[] args) {
        Doubly_Linked_List_Intro obj = new Doubly_Linked_List_Intro();
        int[] arr1 = {1, 1, 1, 2, 2, 3, 4, 4};
        Node_Dll head = obj.convertArrToDll(arr1);
        Node_Dll newHead = uniqueSortedList(head);
        Node_Dll temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node_Dll uniqueSortedList(Node_Dll head) {
        // Write your code here.
        Node_Dll temp = head;
        while (temp != null && temp.next != null) {
            Node_Dll nextNode = temp.next;
            while (nextNode != null && nextNode.data == temp.data) {
                Node_Dll nextToNextNode = nextNode.next;
                nextNode.next = null;
                nextNode.back = null;
                nextNode = nextToNextNode;
            }
            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.back = temp;
            }
            temp = nextNode;
        }
        return head;
    }
}
