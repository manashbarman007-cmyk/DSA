package sorting_algorithms;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] ex={7,12,9,11,3};
        implementInsertionSort(ex);
    }
    static void implementInsertionSort(int[] arr){
        int n=arr.length;
        //outer loop to pick the values from the unsorted part of the array
        for(int i=1;i<n;i++){//0th index element is always considered to be sorted
            int insertIndex=i;
            int currentElement=arr[i];
            int j=i-1;
            //inner loop runs through the sorted part of the array
            //the while block represents the shifting logic
            while(j>=0 && arr[j]>currentElement){
                arr[j+1]=arr[j];
                insertIndex=j;
                j--;
            }
            arr[insertIndex]=currentElement;
        }

        //to print the array
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
            if(i<n-1) System.out.print(",");
        }
    }
}
