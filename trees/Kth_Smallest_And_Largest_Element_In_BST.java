package trees;

public class Kth_Smallest_And_Largest_Element_In_BST {
    int count1 = 0, k_th_Smallest = 0; // defined globally
    int count2 = 0, k_th_Largest = 0; // define globally
    public static void main(String[] args) {

    }

    // For kth Smallest
    public int kthSmallest(NodeBT root, int k) {
        if (root.left == null && root.right == null) return root.data;
        func_kthSmallest(root, k);
        return k_th_Smallest;
    }

    // Helper for kth smallest
    public void func_kthSmallest (NodeBT root, int k) {
        if (root == null) return;

        func_kthSmallest(root.left, k);

        count1++;
        if (count1 == k) {
            k_th_Smallest = root.data;
        }

        func_kthSmallest(root.right, k);
    }


    // For kth Largest
    public int kthLargest(NodeBT root, int k) {
        // Your code here
        if (root.left == null && root.right == null) return root.data;
        func_kthLargest(root, k);
        return k_th_Largest;
    }

    // Helper for kth largest
    public void func_kthLargest (NodeBT root, int k) {
        if (root == null) return;

        func_kthLargest(root.right, k);

        count2++;
        if (count2 == k) {
            k_th_Largest = root.data;
        }

        func_kthLargest(root.left, k);
    }
}
