package dynamic_programming;

import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_CN {
    public static void main(String[] args) {
       int[] prices = {1, 2, 3};
        System.out.println(maximumProfit(prices, 3, 1));
    }


    //recursion
//    public static int maximumProfit(int[] prices, int n, int fee) {
//        // Write your code here.
//        return f(prices, n, fee, 0, 1);
//    }
//    static int f(int[] prices, int n, int fee, int ind, int buy) {
//        //base case
//        if (ind == n) {
//            return 0; //as we can't make any profit
//        }
//        int profit = Integer.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(-prices[ind] + f(prices, n, fee, ind + 1, 0),
//                    f(prices, n, fee, ind + 1, 1));
//        }
//        else {
//            profit = Math.max(prices[ind] - fee + f(prices, n, fee, ind + 1, 1),
//                    f(prices, n, fee, ind + 1, 0));
//        }
//        return profit;
//    }


    //memoization
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int[][] dp = new int[n][2];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return f(prices, n, fee, 0, 1, dp);
    }
    static int f(int[] prices, int n, int fee, int ind, int buy, int[][] dp) {
        //base case
        if (ind == n) {
            return 0; //as we can't make any profit
        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit = Integer.MIN_VALUE;
        if (buy == 1) {
            profit = Math.max(-prices[ind] + f(prices, n, fee, ind + 1, 0, dp),
                    f(prices, n, fee, ind + 1, 1, dp));
        }
        else {
            profit = Math.max(prices[ind] - fee + f(prices, n, fee, ind + 1, 1, dp),
                    f(prices, n, fee, ind + 1, 0, dp));
        }
        return dp[ind][buy] = profit;
    }
}
