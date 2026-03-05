package dynamic_programming;

import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock_ii_CN {
    public static void main(String[] args) {
      long[] values = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(getMaximumProfit(7,values));
    }

    //recursion
//    public static long getMaximumProfit (int n, long[] values) {
//        // Your code goes here.
//        return f(values, 0, 1);
//    }
//    static long f (long[] values, int ind, int buy) {
//        int n = values.length;
//        //base case
//        if (ind == n) {
//            return 0;
//        }
//        long profit = Long.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(-values[ind] + f(values, ind + 1, 0), f(values, ind + 1, 1));
//        }
//        else {
//            profit = Math.max(values[ind] + f(values, ind + 1, 1), f(values, ind + 1, 0));
//
//        }
//        return profit;
//    }


    //memoization
//    public static long getMaximumProfit (int n, long[] values) {
//        // Your code goes here.
//        long[][] dp = new long[n][2];
//        for (long[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(values, 0, 1, dp);
//    }
//    static long f (long[] values, int ind, int buy, long[][] dp) {
//        int n = values.length;
//        //base case
//        if (ind == n) {
//            return 0;
//        }
//        if (dp[ind][buy] != -1) {
//            return dp[ind][buy];
//        }
//        long profit = Long.MIN_VALUE;
//        if (buy == 1) {
//            profit = Math.max(-values[ind] + f(values, ind + 1, 0, dp), f(values, ind + 1, 1, dp));
//        }
//        else {
//            profit = Math.max(values[ind] + f(values, ind + 1, 1, dp), f(values, ind + 1, 0, dp));
//        }
//        return dp[ind][buy] = profit;
//    }


    //tabulation
//    public static long getMaximumProfit (int n, long[] values) {
//        // Your code goes here.
//        long[][] dp = new long[n + 1][2];
//        for (long[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return f(values, dp);
//    }
//    static long f (long[] values, long[][] dp) {
//        int n = values.length;
//        for (int ind = n; ind >= 0; ind--) {
//            for (int buy = 0; buy <= 1; buy++) {
//                //base case
//                if (ind == n) {
//                    dp[ind][buy] = 0;
//                    continue;
//                }
//                long profit = Long.MIN_VALUE;
//                if (ind < n) {
//                    if (buy == 1) {
//                        profit = Math.max(-values[ind] + dp[ind + 1][0], dp[ind + 1][1]);
//                    } else {
//                        profit = Math.max(values[ind] + dp[ind + 1][1], dp[ind + 1][0]);
//                    }
//                    dp[ind][buy] = profit;
//                }
//            }
//        }
//        return dp[0][1];
//    }


    //space optimization
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here.
        long[] next = new long[2];
        Arrays.fill(next, -1);
        return f(values, next);
    }
    static long f (long[] values, long[] next) {
        int n = values.length;
        long[] cur = new long[2];
        for (int ind = n; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                //base case
                if (ind == n) {
                    next[buy] = 0;
                    continue;
                }
                long profit = Long.MIN_VALUE;
                if (ind < n) {
                    if (buy == 1) {
                        profit = Math.max(-values[ind] + next[0], next[1]);
                    } else {
                        profit = Math.max(values[ind] + next[1], next[0]);
                    }
                    cur[buy] = profit;
                }
                //now we need to update the values of next as cur
                next = cur;
            }
        }
        return next[1];
    }
}
