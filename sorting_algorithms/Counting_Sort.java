package sorting_algorithms;

public class Counting_Sort {
    public static void main(String[] args) {
        int[] ex1= {2,3,0,2,3,2};
        int[] ex2= {4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3};
//        implementCountingSort(ex1);
        implementCountingSort(ex2);

    }
    static void implementCountingSort(int[] arr){
        int n= arr.length;
        int max= Integer.MIN_VALUE;
        //find the max value of the input array
        for(int i=0;i<n;i++){
            if(max<arr[i]) max=arr[i];
        }
        //create a count array of size max+1
        int[] countArr=new int[max+1];

        //for loop to increment values in the count Array
        for(int i=0;i<n;i++){
            countArr[arr[i]]++;
        }
        int index=0;
        //for loop to build the sorted input array from the counting array
        for(int i=0;i<=max;i++){
            while(countArr[i]>0){ //the while loop terminates when countArr[i] becomes 0
               arr[index]=i;
               countArr[i]--;
               index++;
            }
        }

        //print array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(",");
        }


    }
}
