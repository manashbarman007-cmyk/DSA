package dynamic_programming;

public class Best_Time_To_Buy_And_Sell_Stock_iv_CN {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maximumProfit(prices, 6, 2));
    }

    //space optimization
    public static int maximumProfit(int[] prices, int n, int k)
    {
        // Write your code here.
        int[][] next = new int[2][k + 1];
        return f(prices, next, k);
    }
    static int f(int[] prices, int[][] next, int k) {
        int n = prices.length;
        int[][] cur =  new int[2][k + 1];
        for (int ind = n; ind >= 0; ind--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int transaction = k; transaction >= 0; transaction--) {
                    //base case
                    if (ind == n || transaction == 0) { //transaction == 0, means that we cannot make any more transaction
                        next[buy][transaction] = 0;
                        continue;
                    }
                    int profit = Integer.MIN_VALUE;
                    if (buy == 1) {
                        profit = Math.max(- prices[ind] + next[0][transaction], next[1][transaction]);
                    }
                    else {
                        profit = Math.max(prices[ind] + next[1][transaction - 1],next[0][transaction]);
                    }
                    cur[buy][transaction] = profit;
                    //for the next iteration we set next as cur
                    next = cur;
                }
            }
        }
        return next[1][k];
    }
}
