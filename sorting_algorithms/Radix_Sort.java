package sorting_algorithms;

import java.util.Arrays;

public class Radix_Sort {
    public static void main(String[] args) {
        int[] ex1={2,24,56,115,67,86,32,276};
        int[] ex2={23,5};
        System.out.println("Original array: "+Arrays.toString(ex1));
        implementRadixSort(ex1);
        System.out.println("Original array: "+Arrays.toString(ex2));
        implementRadixSort(ex2);

    }

    static void implementRadixSort(int[] arr){
        int n=arr.length,max= Integer.MIN_VALUE;
        //find max element in arr
        for(int i=0;i<n;i++){
            if(max<arr[i]) max=arr[i];
        }
        int[] count=new int[10];
        int[][] radixArray=new int[10][arr.length];

        int exp=1; //exponent
        while (max/exp>0){
            //to storing the elements in radixArray
            for(int i=0;i<n;i++){
                int radixIndex=(arr[i]/exp)%10;
                radixArray[radixIndex][count[radixIndex]]=arr[i];//we store arr[i]
                count[radixIndex]++;
            }

            //to put elements back into arr
            int index=0;
            for(int i=0;i< radixArray.length;i++){
                for(int j=0;j< count[i];j++){
                    arr[index]=radixArray[i][j];
                    index++;
                }
                count[i]=0;
            }
            //one's place->ten's place->hundred's place and so on
            exp*=10;
        }

        //print the array
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }

}
