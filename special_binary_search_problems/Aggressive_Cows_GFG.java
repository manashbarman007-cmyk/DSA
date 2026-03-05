package special_binary_search_problems;

import java.util.Arrays;

public class Aggressive_Cows_GFG {
    public static void main(String[] args) {
    int[] example1={1,2,4,8,9};
    int[] example2={10,1,2,7,5};
    int[] example3={2,12,11,3,26,7};
        System.out.println(aggressiveCows(example1,3));
        System.out.println(aggressiveCows(example2,3));
        System.out.println(aggressiveCows(example3,5));

    }
    public static int aggressiveCows(int[] stalls, int k){
        int start=1, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE,res=-1;
        Arrays.sort(stalls); //the array is sorted in ascending order
        int end=stalls[stalls.length-1]-stalls[0]; //As now the array is sorted in ascending order, the first
                                                 // element is minimum and the last element is maximum
        while (start<=end){
            int mid=start+(end-start)/2;
            boolean isPossible=isAllocationPossible(stalls,mid,k);
            if(isPossible){ //if this condition is true
                res=mid;
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return res;
    }

    //counting cows
    static boolean isAllocationPossible(int[] arr, int minDistance, int k){
        int cowsCount=1,previousCowDistance=arr[0]; // the first cow is placed at the first stall
        for(int i=1;i<arr.length;i++){ //this is for the second cow

            if(arr[i]-previousCowDistance>=minDistance){ //if this condition is satisfied then we can place the second cow
               cowsCount++;
               previousCowDistance=arr[i]; //the second cow is placed in the new stall
            }
            if(cowsCount>=k){
                return true; // we exit the method returning true to the calling method
            }
        }
        return false;
    }
}
