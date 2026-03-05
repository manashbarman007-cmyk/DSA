package sorting_algorithms;

import java.util.Arrays;

public class PigeonHole_Sort {
    public static void main(String[] args) {
       int[] ex1={24,22,25,22,21,27};
       int[] ex2={3, 8, 2, 1, 9, 5, 7, 7, 8};
        System.out.println("Unsorted Array: "+Arrays.toString(ex1));
        implementPigeonHoleSort(ex1);
        System.out.println();
        System.out.println("Unsorted Array: "+Arrays.toString(ex2));
        implementPigeonHoleSort(ex2);
    }
    static void implementPigeonHoleSort(int[] arr){
       int n= arr.length,max= Integer.MIN_VALUE,min= Integer.MAX_VALUE;

       //Step1: finding max and min in array and then find the range of possible unique elements
       for(int i=0;i<n;i++){
           if(max<arr[i]) max=arr[i];
           else if (min>arr[i]) min=arr[i];
       }

       //range of possible uniques elements in array
       int k=max-min+1;

       //Step2: create the pigeonhole array of size k
       int[] pigeonHoleArray=new int[k];

       //Step3: for loop for filling up the pigeonhole array
        for(int i=0;i<n;i++){
               pigeonHoleArray[arr[i]-min]++;
        }

        //Step4: loop for reconstructing the array in sorted manner from the pigeonhole array
        int index=0;
        for(int i=0;i<k;i++){
            while(pigeonHoleArray[i]>0){
                arr[index]=i+min;
                index++;
                pigeonHoleArray[i]--;
            }
        }

        //print the sorted array
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }
}
