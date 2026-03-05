package dynamic_programming;
import java.util.*;

public class Burst_Balloons_CN {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 9};
        System.out.println(burstBalloons(arr));
    }

    //recursion
//    public static int burstBalloons(int []arr){
//        // Write your code here.
//        int n = arr.length;
//        List< Integer > list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(arr[i]);
//        }
//        list.add(0, 1);
//        list.add(1);
//        return f(list, 1, n);
//    }
//    static int f(List< Integer > list, int i, int j) {
//        //base case
//        if (i > j) {
//            return 0; //as there will be no balloon left to burst, so cost = 0
//        }
//        int maxCost = -1;
//        for (int k = i; k <=j; k++) { // as we can start by bursting any ballons
//           int cost = list.get(i - 1) * list.get(k) * list.get(j + 1)
//                      + f(list, i, k - 1) + f(list, k + 1, j);
//           maxCost = Math.max(maxCost, cost);
//        }
//        return maxCost;
//    }


    //memoization
    public static int burstBalloons(int []arr){
        // Write your code here.
        int n = arr.length;
        List< Integer > list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        list.add(0, 1);
        list.add(1);
        int m = list.size();
        int[][] dp = new int[m][m];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return f(list, 1, n, dp);
    }
    static int f(List< Integer > list, int i, int j, int[][] dp) {
        //base case
        if (i > j) {
            return 0; //as there will be no balloon left to burst, so cost = 0
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int maxCost = -1;
        for (int k = i; k <= j; k++) { // as we can start by bursting any ballons
           int cost = list.get(i - 1) * list.get(k) * list.get(j + 1)
                      + f(list, i, k - 1, dp) + f(list, k + 1, j, dp);
           maxCost = Math.max(maxCost, cost);
        }
        return dp[i][j] = maxCost;
    }
}
