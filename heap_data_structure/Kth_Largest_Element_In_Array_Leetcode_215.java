package heap_data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kth_Largest_Element_In_Array_Leetcode_215 {
    int largest = -1;
    public static void main(String[] args) {
        Kth_Largest_Element_In_Array_Leetcode_215 largest = new Kth_Largest_Element_In_Array_Leetcode_215();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(largest.findKthLargest(nums1, 2));
        System.out.println(largest.findKthLargest(nums2, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            list.add(i, nums[i]);
        }
        buildMaxHeap(list);
        int kth_largest = Integer.MIN_VALUE;
        for(int i = 1; i <= k; i++) {
            kth_largest = pop(list);
        }
        return  kth_largest;
    }
    public void buildMaxHeap(List<Integer> list) {
        double n = list.size();
        for(int i = (int)Math.ceil(n / 2) - 1; i >= 0; i--) {
            maxHeapify(list, (int)n, i);
        }
    }

    public void maxHeapify(List<Integer> list, int n, int i) {
        int left = (2 * i) + 1; // position of left child
        int right = (2 * i) + 2; // position of right child
        if (left < n && list.get(left) > list.get(i)) {
            largest = left;
        }
        else largest = i;
        if (right < n && list.get(right) > list.get(largest)) {
            largest = right;
        }
        if (largest != i) { // if the largest is not the current index then heapify it
            Collections.swap(list, i, largest);
            maxHeapify(list, n, largest);
        }
    }

    // Extract max/min algorithm
    public int pop(List<Integer> list) {
        int max = list.get(0);
        int n = list.size();
        Collections.swap(list, 0, n - 1);
        list.remove(n - 1); // remove the last element
        // max heapify the root
        int m = list.size();
        maxHeapify(list, m, 0);
        return max;
    }
}
