package linked_list;

public class Intersectiion_Of_Two_LL_LC_160 {
    public static void main(String[] args) {
        Remove_Nth_Node_From_LL_LC_19 obj = new Remove_Nth_Node_From_LL_LC_19();
        int[] arr1 = {4, 1, 8, 4, 5};
        int[] arr2 = {5, 6, 2, 8, 4, 5};
        Node headA = obj.convertArrToLL(arr1);
        Node headB = obj.convertArrToLL(arr2);
        headB.next.next.next = headA.next.next;
        headA.next.next = headB.next.next.next;
        Node intersection = getIntersectionNode(headA, headB);
        System.out.println(intersection.data);
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        int length1 = 0, length2 = 0;
        Node temp1 = headA;
        Node temp2 = headB;
        while (temp1 != null) {
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        int length = Math.abs(length1 - length2);
        if (length > 0) {
            for (int i = 1; i <= length; i++) {
                if (length1 > length2) {
                    temp1 = temp1.next;
                } else {
                    temp2 = temp2.next;
                }
            }
        }

        while (temp1 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null; // if there is no intersection
    }
}
