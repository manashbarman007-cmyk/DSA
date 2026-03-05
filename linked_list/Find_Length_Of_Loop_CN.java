package linked_list;

public class Find_Length_Of_Loop_CN {
    public static void main(String[] args) {

    }
    public static int lengthOfLoop(Node head) {
        // Write your code here
        if (head == null || head.next == null || head.next.next == null) {
            return 0;
        }
        Node fast = head;
        Node slow = head;
        int cycleLength = 0;
        Node traverseFast = null;
        Node traverseSlow = null;

        // to check if the LL is cyclic
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // moves forward by two nodes
            slow = slow.next; // moves forward by one node
            if (fast == slow) {
                traverseFast = fast;
                traverseSlow = slow;
                break;
            }
        }

        // to count the length of cycle
        while (traverseFast != null) {
            cycleLength++;
            traverseFast = traverseFast.next.next;
            traverseSlow = traverseSlow.next;
            if (traverseFast == traverseSlow) {
                break;
            }
        }
        return cycleLength;
    }
}
