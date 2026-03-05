package recursion_and_backtracking;

import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] ex1={4,6,2,5,7,9,1,3};
        System.out.println(Arrays.toString(ex1));
        quickSort(ex1,0, ex1.length-1);
        System.out.println(Arrays.toString(ex1));

    }
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if (low<high){
            int partitionInd=partition(arr, low, high);
            quickSort(arr,low,partitionInd-1); //for left half
            quickSort(arr,partitionInd+1,high); //for right half
        }

    }

    static int partition(int arr[], int low, int high) {

        // your code here
        int pivot=arr[low]; //fist element as pivot
        int i=low,j=high;
        while (i<j){
            while (arr[i]<=pivot && i<=high-1){ //we find the first greater element than pivot
                i++;
            }
            while (arr[j]>pivot && j>=low+1){ //we find the first smaller element than pivot
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;  //j will be the partitionInd
    }

     static void swap(int arr[], int ind1, int ind2){
        int temp=arr[ind1];
        arr[ind1]=arr[ind2];
        arr[ind2]=temp;
     }
}
