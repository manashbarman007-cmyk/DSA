package dynamic_programming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_CN {
    public static void main(String[] args) {
        int[] arr1 = {5, 4, 11, 1, 16, 8};
        int[] arr2 = {5, 5, 5, 5, 5, 5};
        System.out.println(longestIncreasingSubsequence(arr1));
        System.out.println(longestIncreasingSubsequence(arr2));
    }


    //recursion
//    public static int longestIncreasingSubsequence(int arr[]) {
//        //Your code goes here
//        int n = arr.length;
//        return f(arr, 0,  -1);
//    }
//    static int f(int[] arr, int cur_ind, int prev_ind) {
//        int n = arr.length;
//        //base case
//        if (cur_ind == n) { //as there are no more elements to pick
//            return 0; //ie there is no increasing subsequence
//        }
//        int pick = Integer.MIN_VALUE;
//        //we do not pick the cur_ind element and move one index forward
//        int notPick = f(arr, cur_ind + 1, prev_ind);
//
//        if (prev_ind == -1 || arr[cur_ind] > arr[prev_ind]) { //we can pick the cur_ind element and move one ind forward
//            pick = 1 + f(arr, cur_ind + 1, cur_ind);
//        }
//        int length = Math.max(pick, notPick);
//        return length;
//    }



    //memoization
//    public static int longestIncreasingSubsequence(int arr[]) {
//        //Your code goes here
//        int n = arr.length;
//        int[][] dp = new int[n][n + 1];
//        for (int[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(arr, 0,  -1, dp);
//    }
//    static int f(int[] arr, int cur_ind, int prev_ind, int[][] dp) {
//        int n = arr.length;
//        //base case
//        if (cur_ind == n) { //as there are no more elements to pick
//            return 0; //ie there is no increasing subsequence
//        }
//        if (dp[cur_ind][prev_ind + 1] != -1) {
//            return dp[cur_ind][prev_ind + 1];
//        }
//        int pick = Integer.MIN_VALUE;
//        //we do not pick the cur_ind element and move one index forward
//        int notPick = f(arr, cur_ind + 1, prev_ind, dp);
//
//        if (prev_ind == -1 || arr[cur_ind] > arr[prev_ind]) { //we can pick the cur_ind element and move one ind forward
//            pick = 1 + f(arr, cur_ind + 1, cur_ind, dp);
//        }
//        return dp[cur_ind][prev_ind + 1] = Math.max(pick,notPick);
//    }


    //tabulation
//    public static int longestIncreasingSubsequence(int arr[]) {
//        //Your code goes here
//        int n = arr.length;
//        int[][] dp = new int[n + 1][n + 1];
//        for (int[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(arr, dp);
//    }
//    static int f(int[] arr, int[][] dp) {
//        int n = arr.length;
//        for (int cur_ind = n; cur_ind >= 0; cur_ind--) {
//            for (int prev_ind = cur_ind - 1; prev_ind >= -1; prev_ind--) {
//                //base case
//                if (cur_ind == n) {
//                    dp[cur_ind][prev_ind + 1] = 0; //coordinate shift for the second parameter
//                    continue;
//                }
//                int pick = Integer.MIN_VALUE;
//                //we do not pick the cur_ind element and move one index forward
//                int notPick = dp[cur_ind + 1][prev_ind + 1];
//
//                if (prev_ind == -1 || arr[cur_ind] > arr[prev_ind]) { //we can pick the cur_ind element and move one ind forward
//                    pick = 1 + dp[cur_ind + 1][cur_ind + 1];
//                }
//                dp[cur_ind][prev_ind + 1] = Math.max(pick,notPick);
//            }
//        }
//        return dp[0][0];
//    }


    //Special tabulation where SC = O(n)
    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        return f(arr, dp);
    }
    static int f(int[] arr, int[] dp) {
        int n = arr.length;
        int LIS = -1;
        for (int cur_ind = 1; cur_ind < n; cur_ind++) {
            for (int prev_ind = 0; prev_ind < cur_ind; prev_ind++) {
                if (arr[cur_ind] > arr[prev_ind]) {
                    dp[cur_ind] = Math.max(dp[cur_ind], 1 + dp[prev_ind]);
                }
                LIS = Math.max(LIS, dp[cur_ind]);
            }
        }
        return LIS;
    }
}
