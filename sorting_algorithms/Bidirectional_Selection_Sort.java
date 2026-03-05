package sorting_algorithms;

public class Bidirectional_Selection_Sort {
    public static void main(String[] args) {
        int[] example = {7, 5, 9, 2, 8};
        implementBiDirectionalSelectionSort(example);

    }

    static void implementBiDirectionalSelectionSort(int[] arr) {
        int n = arr.length, k=n-1;
        for (int i = 0; i < k; i++) {
            int minIndex = i, maxIndex = i;
            int maxElement=arr[i],minElement=arr[i];
            //loop to find the index of the minimum element in range
            for (int j = i+1; j <= k; j++) {
                if (arr[j] < minElement) {
                    minElement=arr[j];
                    minIndex = j;
                } else if (arr[j] > maxElement) {
                    maxElement=arr[j];
                    maxIndex = j;
                }
            }
            //swap for the min element
            swap(arr,i,minIndex);

            //swap for the max element
            if(maxElement==arr[minIndex]){
                swap(arr,k,minIndex);
            }
            else swap(arr,k,maxIndex);

            k--;
        }
        //to print the array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(",");
        }
    }

    //to swap elements in array
    static void swap(int[] arr,int index1,int index2) {
        int temp = arr[index1];
        arr[index1]= arr[index2];
        arr[index2] = temp;
    }
}




