package dynamic_programming;
import java.util.*;

public class Best_Time_To_Buy_And_Sell_Stock_CN {
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(2);
        prices.add(100);
        prices.add(150);
        prices.add(120);
        System.out.println(maximumProfit(prices));
    }


    //TC = O(n^2) solution
//    public static int maximumProfit(ArrayList<Integer> prices){
//        // Write your code here.
//        int n = prices.size();
//        int profit = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                profit = Math.max(profit,prices.get(j) - prices.get(i));
//            }
//        }
//        return profit;
//    }


    //TC = O(n) solution
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int n = prices.size();
        int profit = Integer.MIN_VALUE, min = prices.get(0);
        for (int i = 1; i < n; i++) {
           int cost = prices.get(i) - min;
           profit = Math.max(cost,profit);
           min = Math.min(min,prices.get(i));
        }
        if (profit >= 0) {
            return profit;
        }
        return 0; // if profit < 0
    }
}
