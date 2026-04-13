package linked_list;
import linked_list.Node_Dll;

import java.util.Stack;

public class Reverse_A_DLL {
    public static void main(String[] args) {
       int[] arr = {4, 2, 3, 1, 5};
       Node_Dll head = convertArrToDll(arr);
       Node_Dll temp = head;
       while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
       }

        System.out.println();

       Node_Dll newHead = reverse(head);
       Node_Dll newTemp = newHead;
        while (newTemp != null) {
            System.out.print(newTemp.data + " ");
            newTemp = newTemp.next;
        }
    }

    // Approach 1 : using a stack
//    static Node_Dll reverse (Node_Dll head) {
//        Stack<Integer> stack = new Stack<>();
//        Node_Dll temp = head;
//        while (temp != null) {
//          stack.push(temp.data);
//          temp = temp.next;
//        }
//        temp = head; //we again reset the temp as head
//        while (temp != null) {
//            temp.data = stack.pop();
//            temp = temp.next;
//        }
//        return head;
//    }

    // Approach 2 : Using a single traversal (we change the pointer directions)
    static Node_Dll reverse (Node_Dll head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node_Dll currentNode = head;
        Node_Dll prevNode = null;

        while (currentNode != null) {
            prevNode = currentNode.back;
            currentNode.back = currentNode.next;
            currentNode.next = prevNode;
            
            currentNode = currentNode.back;
        }
        Node_Dll newHead = prevNode.back;

        return newHead;
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
}

// Study this (more intuitive) 

// class Solution {
//      public Node reverse(Node head) {
//         // code here
//         Node curNode = head;
//         Node prevNode = null;
//         while (curNode != null) {
//             Node nextNode = curNode.next;
            
//             // swap logic
//             curNode.next = prevNode;
//             curNode.prev = nextNode;
            
            
//             prevNode = curNode;
//             curNode = nextNode;
//         }
        
//         return prevNode;
//     }
// }
