package sorting_algorithms;

import java.util.Arrays;

public class Cycle_Sort_Variants {
    public static void main(String[] args) {
        int[] ex1={2,1,5,4,3};
        int[] ex2={2,1,0,3,4};
        System.out.println("The unsorted array is: "+Arrays.toString(ex1));
        implementCycleSort_1_To_N(ex1);
        System.out.println();
        System.out.println("The unsorted array is: "+Arrays.toString(ex2));
        implementCycleSort_0_To_N(ex2);
    }

    // range of input array is from 0 to N
    static void implementCycleSort_0_To_N(int[] arr){
        int index=0,n=arr.length;
        while (index<n){
            int element=arr[index];
            int actualIndex=element;
            if(arr[index]!=arr[actualIndex] && arr[index]<n){
                swap(arr,index,actualIndex);
            }
            else{  //if arr[index]==arr[actualIndex] && arr[index]>n
                index++;
            }
        }

        //Print the array
        System.out.println("The sorted array is: "+ Arrays.toString(arr));

    }

    // range of input array is from 1 to N
    static void implementCycleSort_1_To_N(int[] arr){
        int index=0,n=arr.length;
        while (index<n){
            int element=arr[index];
            int actualIndex=element-1;
            if(arr[index]!=arr[actualIndex] && arr[index]<n){
                swap(arr,index,actualIndex);
            }
            else{  //if arr[index]==arr[actualIndex] && arr[index]>n
                index++;
            }
        }

        //Print the array
        System.out.println("The sorted array is: "+ Arrays.toString(arr));

    }



    //to swap elements in array
    static void swap(int[] arr,int index1,int index2) {
        int temp = arr[index1];
        arr[index1]= arr[index2];
        arr[index2] = temp;
    }
}
