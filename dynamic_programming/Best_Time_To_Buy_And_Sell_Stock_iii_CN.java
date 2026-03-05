package dynamic_programming;

import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock_iii_CN {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }


    //recursion
//    public static int maxProfit(int[] prices) {
//        // Write your code here.
//        return f(prices, 0, 1, 0);
//    }
//    static int f(int[] prices, int ind, int buy, int transaction) {
//        int n = prices.length;
//        //base case
//        if (ind == n || transaction == 2) { //transaction == 2, means that we cannot make any more transaction
//                                            //so, return a 0
//            return 0; //as we won't make any profit
//        }
//        int profit = Integer.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(- prices[ind] + f(prices, ind + 1, 0, transaction),f(prices, ind + 1, 1, transaction));
//        }
//        else {
//            profit = Math.max(prices[ind] + f(prices, ind + 1, 1, transaction + 1),f(prices, ind + 1, 0, transaction));
//        }
//        return profit;
//    }



    //memoization
//    public static int maxProfit(int[] prices) {
//        // Write your code here.
//        int n = prices.length;
//        int[][][] dp = new int[n][2][3];
//        for (int[][] x : dp) {
//            for (int[] y : x) {
//                Arrays.fill(y, -1);
//            }
//        }
//        return f(prices, 0, 1, 0, dp);
//    }
//    static int f(int[] prices, int ind, int buy, int transaction, int[][][] dp) {
//        int n = prices.length;
//        //base case
//        if (ind == n || transaction == 2) { //transaction == 2, means that we cannot make any more transaction
//            //so, return a 0
//            return 0; //as we won't make any profit
//        }
//        if (dp[ind][buy][transaction] != -1) {
//            return dp[ind][buy][transaction];
//        }
//        int profit = Integer.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(- prices[ind] + f(prices, ind + 1, 0, transaction, dp),
//                    f(prices, ind + 1, 1, transaction, dp));
//        }
//        else {
//            profit = Math.max(prices[ind] + f(prices, ind + 1, 1, transaction + 1, dp),
//                    f(prices, ind + 1, 0, transaction, dp));
//        }
//        return dp[ind][buy][transaction] = profit;
//    }


    //tabulation
//    public static int maxProfit(int[] prices) {
//        // Write your code here.
//        int n = prices.length;
//        int[][][] dp = new int[n + 1][2][3];
//        for (int[][] x : dp) {
//            for (int[] y : x) {
//                Arrays.fill(y, -1);
//            }
//        }
//        return f(prices, dp);
//    }
//    static int f(int[] prices, int[][][] dp) {
//        int n = prices.length;
//        for (int ind = n; ind >= 0; ind--) {
//            for (int buy = 1; buy >= 0; buy--) {
//                for (int transaction = 0; transaction <=2; transaction++) {
//                    //base case
//                    if (ind == n || transaction == 2) { //transaction == 2, means that we cannot make any more transaction
//                       dp[ind][buy][transaction] = 0;
//                       continue;
//                    }
//                    int profit = Integer.MIN_VALUE;
//                    if (buy == 1) {
//                        profit = Math.max(- prices[ind] + dp[ind + 1][0][transaction], dp[ind + 1][1][transaction]);
//                    }
//                    else {
//                        profit = Math.max(prices[ind] + dp[ind + 1][1][transaction + 1],dp[ind + 1][0][transaction]);
//                    }
//                    dp[ind][buy][transaction] = profit;
//                }
//            }
//        }
//        return dp[0][1][0];
//    }


    //space optimization
    public static int maxProfit(int[] prices) {
        // Write your code here.
        int n = prices.length;
        int[][] next = new int[2][3];
        return f(prices, next);
    }
    static int f(int[] prices, int[][] next) {
        int n = prices.length;
        int[][] cur =  new int[2][3];
        for (int ind = n; ind >= 0; ind--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int transaction = 0; transaction <=2; transaction++) {
                    //base case
                    if (ind == n || transaction == 2) { //transaction == 2, means that we cannot make any more transaction
                       next[buy][transaction] = 0;
                       continue;
                    }
                    int profit = Integer.MIN_VALUE;
                    if (buy == 1) {
                        profit = Math.max(- prices[ind] + next[0][transaction], next[1][transaction]);
                    }
                    else {
                        profit = Math.max(prices[ind] + next[1][transaction + 1],next[0][transaction]);
                    }
                    cur[buy][transaction] = profit;
                    //for the next iteration we set next as cur
                    next = cur;
                }
            }
        }
        return next[1][0];
    }
}
