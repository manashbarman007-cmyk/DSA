package heap_data_structure;

import java.util.*;

public class Sliding_Window_Maximum_Leetcode_239 {
    int largest = -1;
    public static void main(String[] args) {
        Sliding_Window_Maximum_Leetcode_239 window = new Sliding_Window_Maximum_Leetcode_239();
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, -1};
        int[] nums3 = {9, 10, 9, -7, -4, -8, 2, -6};
        int[] nums4 = {7, 2, 4};
//        int[] res1 = window.maxSlidingWindow(nums1, 3);
//        int[] res2 = window.maxSlidingWindow(nums2, 1);
        int[] res3 = window.maxSlidingWindow(nums3, 5);
//        int[] res4 = window.maxSlidingWindow(nums4, 2);
//        System.out.println(Arrays.toString(res1));
//        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
//        System.out.println(Arrays.toString(res4));
    }

    // Approach 1 : Brute force (Sliding window)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int left = 0;
//        int right = k - 1;
//        int n = nums.length;
//        int size = n - k + 1;
//        int[] res = new int[size];
//        int index = 0;
//
//        while(right < n) {
//            int max = -1000000000;
//            for (int i = left; i <= right; i++) {
//                max = Math.max(max, nums[i]);
//            }
//            res[index] = max;
//            index++;
//            left++;
//            right++;
//        }
//        return res;
//    }

    // Approach 2 : Max Heap
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value); // max heap in terms of value

        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            maxHeap.offer(new Pair(i, nums[i]));
        }

        res[0] = maxHeap.peek().value;

        for (int i = k; i < n; i++) {
            maxHeap.offer(new Pair(i, nums[i]));

            // Remove elements to the left of window
            while (maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }

            res[i - k + 1] = maxHeap.peek().value;
        }

        return res;
    }
}
class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}



