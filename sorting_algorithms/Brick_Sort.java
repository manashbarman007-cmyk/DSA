package sorting_algorithms;

public class Brick_Sort {
    public static void main(String[] args) {
        int[] ex={8,6,3,1,7,2,4,5};
        implementBrickSort(ex);
    }
    static void implementBrickSort(int[] arr){
        int n= arr.length;;
        boolean isSorted=false;
        while(!isSorted){  //The while loop runs as long as isSorted==false
            boolean didSwap=false;
            //even-odd pairs
            for(int i=0;i<n-1;i+=2) {  //this loop finishes first
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    didSwap = true;
                }
            }
            //odd-even pairs
            for(int i=1;i<n-1;i+=2) { //this loop finishes second
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    didSwap = true;
                }
            }
            //the while loop breaks if didSwap==false
            if(!didSwap) {
                isSorted=true;
                // insted of isSorted=true, we can use break; as well if !didSwap
            }
        }
        //print the array
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

