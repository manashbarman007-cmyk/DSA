package linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// NodeClass structure
class NodeClass {
    public int data;
    public NodeClass next;
    public NodeClass child;

    NodeClass()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    NodeClass(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    NodeClass(int data, NodeClass next, NodeClass child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}


public class Flatten_A_Linked_List_CN {
    public static void main(String[] args) {

    }

    //Approach 1
//    public static NodeClass flattenLinkedList(NodeClass head) {
//        //Write your code here
//        if (head == null) {
//            return head;
//        }
//        List<Integer> list = new ArrayList<>();
//        NodeClass temp = head;
//        while (temp != null) {
//            NodeClass childTemp = temp;
//            while (childTemp != null) {
//               list.add(childTemp.data);
//               childTemp = childTemp.child;
//            }
//            temp = temp.next;
//        }
//        Collections.sort(list);
//        NodeClass newHead = convertListToLL(list);
//       return newHead;
//    }
//    static NodeClass convertListToLL (List<Integer> list) {
//        NodeClass head = new NodeClass(list.get(0));
//        NodeClass temp = head;
//        int n = list.size();
//        for (int i = 1; i < n; i++) {
//            NodeClass newNode = new NodeClass(list.get(i)); // create a new node for each element
//            temp.child = newNode;
//            temp = temp.child;
//        }
//        return head;
//    }

    // Approach 2

    // Iterative main func
//    public static NodeClass flattenLinkedList(NodeClass head) {
//        if (head == null) {
//            return head;
//        }
//        NodeClass temp = head;
//        NodeClass dummyNode = new NodeClass(-1);
//        NodeClass dummyTemp = dummyNode;
//        while (temp != null) {
//            dummyTemp = merge2LL(dummyTemp, temp);
//            temp = temp.next;
//        }
//        NodeClass newHead = dummyNode.child;
//        return newHead;
//    }

    // Recursive main func
    public static NodeClass flattenLinkedList(NodeClass head) {
        //  base case
        if (head == null || head.next == null) {
            return head;
        }
        NodeClass temp = flattenLinkedList(head.next);
        NodeClass newHead = merge2LL(head, temp); // we merge while backtracking
        return newHead;
    }

    // helper func
    static NodeClass merge2LL (NodeClass head1, NodeClass head2) {
        NodeClass temp1 = head1;
        NodeClass temp2 = head2;
        NodeClass dummyNode = new NodeClass(-1);
        NodeClass dummyTemp = dummyNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                dummyTemp.child = temp1;
                dummyTemp = dummyTemp.child;
                temp1 = temp1.child;
            }
            else { // if temp2.data < temp1.data
                dummyTemp.child = temp2;
                dummyTemp = dummyTemp.child;
                temp2 = temp2.child;
            }
        }
        if (temp1 == null && temp2 != null) { // as each vertical lists are sorted
            dummyTemp.child = temp2;
        }
        else { // if temp2 == null && temp1 != null
            dummyTemp.child = temp1;
        }
        NodeClass newHead = dummyNode.child;
        return newHead;
    }
}
