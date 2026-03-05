package dynamic_programming;

import java.util.Arrays;

public class Partition_Array_For_Max_Sum_CN {
    public static void main(String[] args) {
        int[] arr = {1, 20, 13, 4, 4, 1};
        System.out.println(maximumSubarray(arr, 3));
    }


    // recursion
//    public static int maximumSubarray(int arr[], int k) {
//        // Write your code here..
//        int n = arr.length;
//        return f(arr, k, 0);
//    }
//    static int f(int[] arr, int k, int ind) {
//        int n = arr.length;
//        //base case
//        if (ind == n) {
//            return 0; // as we can't make any more partition
//        }
//        int maxSum = 0;
//        int length = 0;
//        int maxElement = -1000000;
//        for (int j = ind; j < Math.min(ind + k, n); j++) {
//            length++;
//            maxElement = Math.max(maxElement, arr[j]);
//            int sum = (maxElement * length) + f(arr, k, j + 1);
//            maxSum = Math.max(maxSum, sum);
//        }
//        return maxSum;
//    }


    // memoization
    public static int maximumSubarray(int arr[], int k) {
        // Write your code here..
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(arr, k, 0, dp);
    }
    static int f(int[] arr, int k, int ind, int[] dp) {
        int n = arr.length;
        //base case
        if (ind == n) {
            return 0; // as we can't make any more partition
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int maxSum = 0;
        int length = 0;
        int maxElement = -1000000;
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            length++;
            maxElement = Math.max(maxElement, arr[j]);
            int sum = (maxElement * length) + f(arr, k, j + 1, dp);
            maxSum = Math.max(maxSum, sum);
        }
        return dp[ind] =  maxSum;
    }
}


