package linked_list;
 import java.util.*;

public class Find_Pairs_With_Given_Sum_In_DLL_CN {
    public static void main(String[] args) {
        Doubly_Linked_List_Intro obj = new Doubly_Linked_List_Intro();
        int[] arr1 = {1, 2, 3, 4, 9};
        Node_Dll head = obj.convertArrToDll(arr1);
        List<List<Integer>> list = findPair(head,5);
        System.out.println(list);
    }

    // Approach 1 : TC = O(n * n) (approx)
//    public static List<List <Integer>> findPair(Node_Dll head, int k) {
//        // Write your code here.
//        List<List <Integer>> list = new ArrayList<>();
//        Node_Dll temp1 = head;
//        while (temp1 != null) {
//            Node_Dll temp2 = temp1.next;
//            while (temp2 != null) {
//                if (temp1.data + temp2.data == k) {
//                    List <Integer> sublist = new ArrayList<>();
//                    sublist.add(temp1.data);
//                    sublist.add(temp2.data);
//                    list.add(sublist);
//                } else if (temp1.data + temp2.data > k) {
//                    break; // as th ll is sorted, so there can be no sum == k beyond this
//                }
//                temp2 = temp2.next;
//            }
//            temp1 = temp1.next;
//        }
//        return list;
//    }


    // Approach 1 : TC = O(2 * n) (approx)
    public static List<List <Integer>> findPair(Node_Dll head, int k) {
        // Write your code here.
        List<List <Integer>> list = new ArrayList<>();
        Node_Dll temp1 = head;
        Node_Dll temp2 = head;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        while (temp1.data < temp2.data) {
            if (temp1.data + temp2.data > k) {
                temp2 = temp2.back;
            }
            else if (temp1.data + temp2.data < k) {
                temp1 = temp1.next;
            }
            else { // temp1.data + temp2.data == k
                List<Integer> sublist = new ArrayList<>();
                sublist.add(temp1.data);
                sublist.add(temp2.data);
                list.add(sublist);
                temp1 = temp1.next;
                temp2 = temp2.back;
            }
        }
        return list;
    }
}
