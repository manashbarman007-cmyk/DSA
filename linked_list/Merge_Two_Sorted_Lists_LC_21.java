package linked_list;

public class Merge_Two_Sorted_Lists_LC_21 {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {5};
        Node list1 = obj.convertArrToLL(arr1);
        Node list2 = obj.convertArrToLL(arr2);
        Node newHead = mergeTwoLists(list1, list2);
        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node mergeTwoLists(Node list1, Node list2) {
      if (list1 == null && list2 == null) {
          return null;
      }
      if (list1 == null) {
          return list2;
      }
      if (list2 == null) {
          return list1;
      }
      Node temp1 = list1;
      Node temp2 = list2;
      Node dummyNode = new Node(-1);
      Node dummyTemp = dummyNode;
      while (temp1 != null && temp2 != null) {
          if (temp1.data <= temp2.data) {
              dummyTemp.next = temp1;
              dummyTemp = temp1;
              temp1 = temp1.next;
          }
          else { // if (temp2.data < temp1.data)
              dummyTemp.next = temp2;
              dummyTemp = temp2;
              temp2 = temp2.next;
          }
      }
      if (temp1 != null) {
          dummyTemp.next = temp1;
      }
      else { // if temp2 != null
          dummyTemp.next = temp2;
      }
      Node newHead = dummyNode.next;
      return newHead;
    }

}
