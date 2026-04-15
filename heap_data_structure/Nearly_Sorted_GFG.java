package heap_data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Nearly_Sorted_GFG {
    int largest = -1;
    int smallest = -1;
    public static void main(String[] args) {
        Nearly_Sorted_GFG sorted = new Nearly_Sorted_GFG();
//        int[] arr1 = {2, 3, 1, 4};
        int[] arr2 = {1, 4, 5, 2, 3, 6, 7, 8, 9, 10};
//        sorted.nearlySorted(arr1, 2);
        sorted.nearlySorted(arr2, 2);
//        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    // Approach 1: Using heap sort
//    public void nearlySorted(int[] arr, int k) {
//        // code here
//        heapSort(arr);
//    }
//
//    public void heapSort(int[] arr) {
//        // Step 1: Build a Max Heap
//        buildMaxHeap(arr);
//
//        int n = arr.length;
//
//        // Step 2: swap root with the last element in the heap and keep on reducing the heap size till
//        // it becomes 1 and keep on heapifying the root
//        for (int i = n - 1; i >= 1; i--) {
//            swap(arr, 0, i);
//            maxHeapify(arr, i, 0);
//        }
//    }
//    public void buildMaxHeap(int[] arr) {
//        double n = arr.length;
//        for(int i = (int)Math.ceil(n / 2) - 1; i >= 0; i--) {
//            maxHeapify(arr, (int)n, i);
//        }
//    }
//
//    public void maxHeapify(int[] arr, int n, int i) {
//        int left = (2 * i) + 1; // position of left child
//        int right = (2 * i) + 2; // position of right child
//        if (left < n && arr[left] > arr[i]) {
//            largest = left;
//        }
//        else largest = i;
//        if (right < n && arr[right] > arr[largest]) {
//            largest = right;
//        }
//        if (largest != i) { // if the largest is not the current index then heapify it
//            swap(arr, i, largest);
//            maxHeapify(arr, n, largest);
//        }
//    }
//    public void swap(int[] arr, int ind1, int ind2) {
//        int temp = arr[ind1];
//        arr[ind1] = arr[ind2];
//        arr[ind2] = temp;
//    }

    public void nearlySorted(int[] arr, int k) {
        // code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            list.add(arr[i]);
        }
        int pushInd = list.size();
        int n = arr.length;
        buildMinHeap(list);
        int index = 0;
        while(pushInd < n) {
            arr[index] = pop(list);
            index++;
            push(list, arr[pushInd]);
            pushInd++;
        }
        while (!list.isEmpty()){
            arr[index] = pop(list);
            index++;
        }
    }

    public void minHeapify(List<Integer> list, int n, int i) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        if (left < n && list.get(left) < list.get(i)) {
            smallest = left;
        }
        else smallest = i;
        if (right < n && list.get(right) < list.get(smallest)) {
            smallest = right;
        }
        if (smallest != i) {
            Collections.swap(list, i, smallest);
            minHeapify(list, n, smallest);
        }
    }

    public void buildMinHeap(List<Integer> list) {
        double n = list.size();
        for(int i = (int)Math.ceil(n / 2) - 1; i >= 0; i--) {
            minHeapify(list, (int)n, i);
        }
    }

    // Extract max/min algorithm
    public int pop(List<Integer> list) {
        int min = list.get(0);
        int n = list.size();
        Collections.swap(list, 0, n - 1);
        list.remove(n - 1); // remove the last element
        // min heapify the root
        int m = list.size();
        minHeapify(list, m, 0);
        return min;
    }

    public void push(List<Integer> list, int ele) {
        list.add(ele);
        int ind = list.size() - 1;

        // percolate up
        while (ind > 0 && list.get((ind - 1) / 2) > list.get(ind)) {
            int parentInd = (ind - 1) / 2;
            Collections.swap(list, ind, parentInd);
            ind = parentInd;
        }
    }
}



// study this

 // public void nearlySorted(int[] arr, int k) {
 //        // code here
 //        int n = arr.length;
 //        PriorityQueue<Integer> pq = new PriorityQueue<>();

 //        // we run this for loop for the first (k + 1) elements as the smallest
 //        // element will always be in this range
 //        for (int i = 0; i <= k && i < n; i++) {
 //            pq.offer(arr[i]);
 //        }

 //        int ind = 0;

 //        // process the remaining elements
 //        for (int i = k + 1; i < n; i++) {
 //            arr[ind++] = pq.poll();
 //            pq.offer(arr[i]);
 //        }

 //        while (!pq.isEmpty()) {
 //            arr[ind++] = pq.poll();
 //        }
 //    }
