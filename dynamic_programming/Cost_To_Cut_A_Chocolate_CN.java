package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cost_To_Cut_A_Chocolate_CN {
    public static void main(String[] args) {
       int[] cuts = {4, 3, 5, 1};
        System.out.println(cost(7, 4, cuts));
    }


    // recursion
//    public static int cost(int n, int c, int cuts[]) {
//
//        // Write your code here..
//        List< Integer > cutsList = new ArrayList<>();
//        for (int i = 0; i < c; i++) {
//            cutsList.add(cuts[i]);
//        }
//        cutsList.add(0, 0);
//        cutsList.add(n);
//        Collections.sort(cutsList);
//        return f(cutsList, 1, c);
//    }
//    static int f (List< Integer > list, int i, int j) {
//        //base case
//        if (i > j) {
//            return 0; // as the cost to cut a chocolate of length 0 will be 0, as we cannot make any more cuts
//        }
//        int minCost = (int) Math.pow(10, 9);
//        for (int k = i; k <= j; k++) {
//            int cost = list.get(j + 1) - list.get(i - 1)
//                    + f(list, i, k - 1) + f(list, k + 1, j);
//            minCost = Math.min(cost, minCost);
//        }
//        return minCost;
//    }



    // memoization
    public static int cost(int n, int c, int cuts[]) {

        // Write your code here..
        List< Integer > cutsList = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            cutsList.add(cuts[i]);
        }
        cutsList.add(0, 0);
        cutsList.add(n);
        Collections.sort(cutsList);
        int m = cutsList.size();
        int[][] dp = new int[m][m];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return f(cutsList, 1, c, dp);
    }
    static int f (List< Integer > list, int i, int j, int[][] dp) {
        //base case
        if (i > j) {
            return 0; // as the cost to cut a chocolate of length 0 will be 0, as we cannot make any more cuts
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = (int) Math.pow(10, 9);
        for (int k = i; k <= j; k++) {
            int cost = list.get(j + 1) - list.get(i - 1)
                    + f(list, i, k - 1, dp) + f(list, k + 1, j, dp);
            minCost = Math.min(cost, minCost);
        }
        return dp[i][j] = minCost;
    }
}
