package sorting_algorithms;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] ex={7,12,9,11,3};
        implementBubbleSort(ex);
    }
    static void implementBubbleSort(int[] arr){
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            boolean didSwap=false;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]) {
                    swap(arr,j,j+1);
                    didSwap=true;
                }
            }
            //if for any iteration in 'i' didSwap==false, the loop will break;
            if(didSwap==false) break;
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
