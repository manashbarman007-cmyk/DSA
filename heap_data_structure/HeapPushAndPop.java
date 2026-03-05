package heap_data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapPushAndPop {
    int largest = -1;
    public static void main(String[] args) {
        HeapPushAndPop pushAndPop = new HeapPushAndPop();
        List<Integer> list = new ArrayList<>(List.of(20, 9, 8, 7, 6, 5, 4, 3));
        pushAndPop.push(list, 12);
        System.out.println(list);
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
    public void buildMaxHeap( List<Integer> list) {
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
}
