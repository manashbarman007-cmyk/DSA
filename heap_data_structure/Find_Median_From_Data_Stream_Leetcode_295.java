package heap_data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Find_Median_From_Data_Stream_Leetcode_295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }
}

// Approach 1: Brute force
//class MedianFinder {
//    List<Integer> list;
//    Heap heap;
//
//    public MedianFinder() {
//        list = new ArrayList<>();
//        heap = new Heap();
//    }
//
//    public void addNum(int num) {
//        list.add(num);
//        heap.heapsort(list);
//    }
//
//    public double findMedian() {
//        int n = list.size();
//        if ((n % 2) != 0) { // if n is odd
//            int ind = (n - 1) / 2;
//            return list.get(ind);
//        }
//        else { // if n is even
//            int ind1 = (n / 2) - 1;
//            int ind2 = n / 2;
//            double median = (list.get(ind1) + list.get(ind2)) / 2.0;
//            return median;
//        }
//    }
//}
//class Heap {
//    int largest = -1;
//    // Insert element algorithm
//    public void push(List<Integer> list, int ele) {
//        list.add(ele);
//        int ind = list.size() - 1;
//
//        // percolate up
//        while (ind > 0 && list.get((ind - 1) / 2) < list.get(ind)) {
//            int parentInd = (ind - 1) / 2;
//            Collections.swap(list, ind, parentInd);
//            ind = parentInd;
//        }
//    }
//
//    // Extract max/min algorithm
//    public int pop(List<Integer> list) {
//        int max = list.get(0);
//        int n = list.size();
//        Collections.swap(list, 0, n - 1);
//        list.remove(n - 1); // remove the last element
//        // max heapify the root
//        int m = list.size();
//        maxHeapify(list, m, 0);
//        return max;
//    }
//    public void buildMaxHeap( List<Integer> list) {
//        double n = list.size();
//        for(int i = (int)Math.ceil(n / 2) - 1; i >= 0; i--) {
//            maxHeapify(list, (int)n, i);
//        }
//    }
//
//    public void maxHeapify(List<Integer> list, int n, int i) {
//        int left = (2 * i) + 1; // position of left child
//        int right = (2 * i) + 2; // position of right child
//        if (left < n && list.get(left) > list.get(i)) {
//            largest = left;
//        }
//        else largest = i;
//        if (right < n && list.get(right) > list.get(largest)) {
//            largest = right;
//        }
//        if (largest != i) { // if the largest is not the current index then heapify it
//            Collections.swap(list, i, largest);
//            maxHeapify(list, n, largest);
//        }
//    }
//
//    public void heapsort(List<Integer> list) {
//        // extract elements from the heap one by one
//        int n = list.size();
//
//        //Step 1 : the given array is converted to a max heap
//        buildMaxHeap(list);
//
//        // Step 2: swap the root with the last element of the heap and max heapify the root
//        for (int i = n - 1; i >= 1; i--) { // repeat until the heap size is reduced to 1
//            Collections.swap(list, 0, i);
//            // call max heapify on the reduced heap
//            maxHeapify(list, i, 0);
//        }
//    }
//}

// Approach 2: Optimized
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int lSize = maxHeap.size();
        int rSize = minHeap.size();

        if (lSize == 0) { // num is the first element in the stream. So, store it in maxHeap
            maxHeap.offer(num);
        }
        else if (lSize == rSize) { // push one element to the maxHeap for sure (As we store the element for odd stream
                                   // in maxHeap)
            if (num < minHeap.peek()) { // store the element in the maxHeap
                maxHeap.offer(num);
            }
            else { // num >= minHeap.peek()
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        }
        else { // lSize != rSize (actually lSize = 1 + rSize)
               // push one element to the minHeap for sure
            if (num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
            else {
                minHeap.offer(num);
            }
        }

    }

    public double findMedian() {
        int lSize = maxHeap.size();
        int rSize = minHeap.size();
        int n = lSize + rSize; // total number of elements in data stream
        if (n % 2 != 0) { // odd number of elements
            return maxHeap.peek();
        }
        else {
            int num1 = maxHeap.peek();
            int num2 = minHeap.peek();

            return (num1 + num2) / 2.0;
        }
    }
}