package heap_data_structure;

import java.util.Arrays;

public class Heapsort {
    int largest = -1;
    public static void main(String[] args) {
        Heapsort heapsort = new Heapsort();
        int[] arr = {2, 1, 6, 3, 9, 8};
        heapsort.heapsort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void buildMaxHeap(int[] arr) {
        double n = arr.length;
        for(int i = (int)Math.ceil(n / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, (int)n, i);
        }
    }

    public void maxHeapify(int[] arr, int n, int i) {
        int left = (2 * i) + 1; // position of left child
        int right = (2 * i) + 2; // position of right child
        if (left < n && arr[left] > arr[i]) {
            largest = left;
        }
        else largest = i;
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) { // if the largest is not the current index then heapify it
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    public void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public void heapsort(int[] arr) {
        // extract elements from the heap one by one
        int n = arr.length;

        //Step 1 : the given array is converted to a max heap
        buildMaxHeap(arr);

        // Step 2: swap the root with the last element of the heap and max heapify the root
        for(int i = n - 1; i >= 1; i--) { // repeat until the heap size is reduced to 1
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            maxHeapify(arr, i,0);
        }
    }

}
