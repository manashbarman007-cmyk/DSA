package dynamic_programming;

import java.util.Arrays;

public class Unbounded_Knapsack_CN {
    public static void main(String[] args) {
        int[] profit = {5,11,13};
        int[] weight = {2,4,6};
        System.out.println(unboundedKnapsack(3,10,profit,weight));
    }

    //recursion
//    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//        // Write your code here.
//        int ans = f(w,profit,weight,n-1);
//        if(ans >= - (int)Math.pow(10,6)){
//            return 0;
//        }
//        return ans;
//    }
//    static int f(int w,int[] profit,int[] weight,int ind){
//        //base cases (think of a single element in the array)
//        if(ind == 0){
//            if(w >= weight[0]){
//                int x = w / weight[0];
//                return x * profit[0];
//            }
//            return 0; //else return 0 as we cannot pick anything if w < weight[0]
//        }
//        int notPick = Integer.MIN_VALUE;
//        int pick = Integer.MIN_VALUE;
//        if (ind > 0){
//            notPick=f(w,profit,weight,ind-1);
//            if(w >= weight[ind]){
//                pick = profit[ind] + f(w - weight[ind],profit,weight,ind); //staying on the same index as multiple
//                                                                              //pick is possible
//            }
//        }
//        return Math.max(pick,notPick);
//    }


    //memoization
//    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//        // Write your code here.
//        int[][] dp = new int[n][w+1];
//        for (int[] x : dp){
//            Arrays.fill(x,-1);
//        }
//        int ans = f(w,profit,weight,n-1,dp);
//        if(ans < 0){
//            return 0;
//        }
//        return ans;
//    }
//    static int f(int w,int[] profit,int[] weight,int ind,int[][] dp){
//        //base cases
//        if(ind == 0){
//            if(w >= weight[0]){
//                int x = w / weight[0];
//                return x * profit[0];
//            }
//            return 0; //else return 0 as we cannot pick anything if w < weight[0]
//        }
//        if(dp[ind][w] != -1){
//            return dp[ind][w];
//        }
//        int notPick = Integer.MIN_VALUE;
//        int pick = Integer.MIN_VALUE;
//        if (ind > 0){
//            notPick=f(w,profit,weight,ind-1,dp);
//            if(w >= weight[ind]){
//                pick = profit[ind] + f(w - weight[ind],profit,weight,ind,dp); //staying on the same index as multiple
//                                                                              //pick is possible
//            }
//        }
//        return dp[ind][w] = Math.max(pick,notPick);
//    }


    //tabulation
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        int ans = f(w,profit,weight,dp);
        if(ans < 0){
            return 0;
        }
        return ans;
    }
    static int f(int w,int[] profit,int[] weight,int[][] dp){
        int n = profit.length;
        for(int ind = 0;ind < n;ind++){
            for (int target = 0;target <= w;target++){
                //base case
                if(ind == 0){
                    if(target >= weight[0]){
                        int x = target / weight[0];
                        dp[0][target] = x * profit[0];
                        continue;
                    }
                    dp[0][target] = 0;
                    continue;
                }
                int pick = Integer.MIN_VALUE;
                int notPick = dp[ind - 1][target];
                if (target >= weight[ind]) {

                    pick = profit[ind] + dp[ind][target - weight[ind]]; //staying on the same index as multiple
                                                                            //pick is possible
                }
                dp[ind][target] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][w];
    }
}
