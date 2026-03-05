package dynamic_programming;

import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock_With_Cooldown_CN {
    public static void main(String[] args) {
       int[] prices = {4, 9, 0 ,4, 10};
        System.out.println(stockProfit(prices));
    }


    //recursion
//    public static int stockProfit(int[] prices) {
//        // Write your code here.
//        return f(prices, 0, 1);
//    }
//    static int f(int[] prices, int ind, int buy) {
//        int n =prices.length;
//        //base case
//        if (ind >= n) {
//            return 0;
//        }
//        int profit = Integer.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(-prices[ind] + f(prices, ind + 1, 0),
//                    f(prices, ind + 1, 1));
//        }
//        else {
//            profit = Math.max(prices[ind] + f(prices, ind + 2, 1),
//                    f(prices, ind + 1, 0));
//        }
//        return profit;
//    }


    //memoization
//    public static int stockProfit(int[] prices) {
//        // Write your code here.
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        for (int[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(prices, 0, 1, dp);
//    }
//    static int f(int[] prices, int ind, int buy, int[][] dp) {
//        int n =prices.length;
//        //base case
//        if (ind >= n) {
//            return 0;
//        }
//        if (dp[ind][buy] != -1) {
//            return dp[ind][buy];
//        }
//        int profit = Integer.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(-prices[ind] + f(prices, ind + 1, 0, dp),
//                    f(prices, ind + 1, 1, dp));
//        }
//        else {
//            profit = Math.max(prices[ind] + f(prices, ind + 2, 1, dp),
//                    f(prices, ind + 1, 0, dp));
//        }
//        return dp[ind][buy] = profit;
//    }


    //tabulation
//    public static int stockProfit(int[] prices) {
//        // Write your code here.
//        int n = prices.length;
//        int[][] dp = new int[n + 2][2];
//        for (int[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(prices, dp);
//    }
//    static int f(int[] prices, int[][] dp) {
//        int n =prices.length;
//        for (int ind = n + 1; ind >= 0; ind--) {
//            for (int buy = 0; buy <= 1; buy++) {
//                 base case
//                if (ind >= n) {
//                    dp[ind][buy] = 0;
//                    continue;
//                }
//
//                int profit = Integer.MIN_VALUE;
//                if (buy == 1) {
//                    profit = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
//                }
//                else {
//                    profit = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
//                }
//                dp[ind][buy] = profit;
//            }
//        }
//
//        return dp[0][1];
//    }



    //space optimization
    public static int stockProfit(int[] prices) {
        // Write your code here.
        int n = prices.length;
        int[] next1 = new int[2];
        int[] next2 = new int[2];
        return f(prices, next1, next2);
    }
    static int f(int[] prices, int[] next1, int[] next2) {
        int n =prices.length;
        int[] cur = new int[2];
        for (int ind = n + 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                //base case
                if (ind >= n) {
                    next1[buy] = 0;
                    next2[buy] = 0;
                    continue;
                }
                int profit = Integer.MIN_VALUE;
                if (buy == 1) {
                    profit = Math.max(-prices[ind] + next1[0], next1[1]);
                }
                else {
                    profit = Math.max(prices[ind] + next2[1], next1[0]);
                }
                cur[buy] = profit;

                //for the next iteration
                // Update front1 and front2 arrays
                System.arraycopy(next1, 0, next2, 0, 2);
                System.arraycopy(cur, 0, next1, 0, 2);
            }
        }
        return next1[1];
    }
}
