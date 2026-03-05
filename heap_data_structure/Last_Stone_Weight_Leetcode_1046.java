package heap_data_structure;

import java.util.*;

public class Last_Stone_Weight_Leetcode_1046 {
    int largest = -1;
    public static void main(String[] args) {
        Last_Stone_Weight_Leetcode_1046 stone = new Last_Stone_Weight_Leetcode_1046();
        int[] stones = {2, 2};
        int i = stone.lastStoneWeight(stones);
        System.out.println(i);
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        int n = stones.length;
        if (n == 1) {
            return stones[0];
        }
        for (int i = 0; i < n; i++) {
            list.add(i, stones[i]);
        }
        buildMaxHeap(list);
        while (list.size() > 1) {
            int max1 = pop(list);
            int max2 = pop(list);
            int result = Math.abs(max1 - max2);
            if(result > 0) {
                push(list, result);
            }
        }
        if(list.isEmpty()) return 0;
        else return list.get(0);
    }

    // Insert element algorithm
    public void push(List<Integer> list, int ele) {
        list.add(ele);
        int ind = list.size() - 1;
        // percolate up
        while (ind > 0 && list.get((ind - 1) / 2) < list.get(ind)) {
            int parentInd = (ind - 1) / 2;
            Collections.swap(list, ind, parentInd);
            ind = parentInd;
        }
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
