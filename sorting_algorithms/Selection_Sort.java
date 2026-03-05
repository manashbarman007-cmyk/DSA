package sorting_algorithms;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] example={7,5,9,2,8};
        implementSelectionSort(example);

    }
    static void implementSelectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i,minElement=arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //swap elements
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
        //to print the array
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
            if(i<n-1) System.out.print(",");
        }
    }
}
