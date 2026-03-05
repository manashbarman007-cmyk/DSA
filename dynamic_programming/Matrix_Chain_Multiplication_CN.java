package dynamic_programming;

import java.util.Arrays;

public class Matrix_Chain_Multiplication_CN {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 3, 2};
        System.out.println(matrixMultiplication(arr1, 4));
    }


    // by recursion
//    public static int matrixMultiplication(int[] arr , int N) {
//        // Write your code here
//        return f(arr, 1, N - 1);
//    }
//    static int f(int[] arr, int i, int j) {
//        //base case
//        if (i == j) {
//            return 0; //as the number of operations in 0 for a single matrix
//        }
//        int minCost = (int)Math.pow(10, 9);
//        for (int k = i; k < j; k++) {
//            int cost = arr[i - 1] * arr[k] * arr[j] + f(arr, i, k) + f(arr, k + 1,j);
//            minCost = Math.min(minCost, cost);
//        }
//        return minCost;
//    }


    //memoization
//    public static int matrixMultiplication(int[] arr , int N) {
//        // Write your code here
//        int[][] dp = new int[N][N];
//        for (int[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(arr, 1, N - 1, dp);
//    }
//    static int f(int[] arr, int i, int j, int[][] dp) {
//        //base case
//        if (i == j) {
//            return 0; //as the number of operations in 0 for a single matrix
//        }
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//        int minCost = (int)Math.pow(10, 9);
//        for (int k = i; k < j; k++) {
//            int cost = arr[i - 1] * arr[k] * arr[j] + f(arr, i, k, dp) + f(arr, k + 1, j, dp);
//            minCost = Math.min(minCost, cost);
//        }
//        return dp[i][j] = minCost;
//    }


    // tabulation
    public static int matrixMultiplication(int[] arr , int N) {
        // Write your code here
        int[][] dp = new int[N][N];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return f(arr, dp);
    }
    static int f(int[] arr, int[][] dp) {

        int n = arr.length;

        for (int i = n - 1; i >= 1 ; i--) {
            for (int j = 1; j <= n - 1; j++) {
                //base case
                if (i == j) {
                    dp[i][j] = 0; //as the number of operations in 0 for a single matrix
                    continue;
                }
                int minCost = (int)Math.pow(10, 9);
                for (int k = i; k < j; k++) {
                    int cost = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n - 1] ;
    }
}
