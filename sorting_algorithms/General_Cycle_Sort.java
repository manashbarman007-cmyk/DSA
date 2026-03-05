package sorting_algorithms;

import java.util.Arrays;

public class General_Cycle_Sort {
    public static void main(String[] args) {
        int[] ex = {1, 8, 3, 9, 10, 10, 4};
        System.out.println("The unsorted array is: "+Arrays.toString(ex));
        implementGeneralCycleSort(ex);

    }

    static void implementGeneralCycleSort(int[] arr) {
        int n = arr.length;
        for (int cycles = 0; cycles < n - 1; cycles++) { //as cycle runs up to n-2
            int position = cycles, item = arr[cycles];

            //find the number of smaller elements in the unsorted part
            for (int i = cycles + 1; i < n; i++) {
                if (arr[i] < item) {
                    position++;
                }
            }
            //that means the element is at the correct position
            if (position == cycles) {
                continue; //the code below the continue will not be executed and we move to the next iteration
            }

            //ignore duplicates and place the item at the next immediate index
            while (arr[position] == item) {
                position++;
            }

            //if smaller elements are found then perform swap
            if (position != cycles) {
                int temp = arr[position];
                arr[position] = item;
                item = temp;
            }

            //now we need to check if there are any smaller elements than the current item and more swaps
            //are required
            while (position != cycles) {
                position = cycles;

                //find the number of smaller elements in the unsorted part
                for (int i = cycles + 1; i < n; i++) {
                    if (arr[i] < item) {
                        position++;
                    }
                }
                //ignore duplicates and place the item at the next immediate index
                while (arr[position] == item) {
                    position++;
                }

                //perform swap
                if(item!=arr[position]){
                    int temp = arr[position];
                    arr[position] = item;
                    item = temp;
                }
            }
        }
        System.out.println("The sorted array is: "+ Arrays.toString(arr));
    }
}

