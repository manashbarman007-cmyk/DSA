package dynamic_programming;

import java.util.Arrays;

public class Rod_Cutting_Problem_CN {
    public static void main(String[] args) {
     int[] ex1 = {2,5,7,8,10};
        System.out.println(cutRod(ex1,5));
    }

    //length = ind + 1
    //recursion
//    public static int cutRod(int price[], int n) {
//        // Write your code here.
//        int m=price.length;
//        return f(price,n,m - 1);
//    }
//    static int f(int[] price, int n,int ind){
//        // base cases (think of having only one element in array)
//        if(ind == 0){ //we go to the first index as we check for the whole array
//            if(n >= 1){
//                return n * price[0];
//            }
//            return 0; //this will be returned if ind == 0 and n == 0
//        }
//        if(ind < 0){
//            return -100000000;
//        }
//        int pick = Integer.MIN_VALUE;
//        int notPick = Integer.MIN_VALUE;
//        if(ind > 0) {
//            notPick = f(price, n, ind - 1);
//            if (n >= ind + 1) {
//                pick = price[ind] + f(price, n - (ind + 1), ind);
//            }
//        }
//        return Math.max(pick,notPick);
//    }


    //memoization
//    public static int cutRod(int price[], int n) {
//        // Write your code here.
//        int m=price.length;
//        int[][] dp = new int[m][n+1];
//        for (int[] x : dp){
//            Arrays.fill(x,-1);
//        }
//        return f(price,n,m - 1,dp);
//    }
//    static int f(int[] price, int n,int ind,int[][] dp){
//        // base cases (think of having one element in array)
//        if(ind == 0){ //we go to the first index as we check for the whole array
//            if(n >= 1){
//                return n * price[0];
//            }
//            return 0; //this will be returned if ind == 0 and n == 0
//        }
//        if(ind < 0){
//            return -100000000;
//        }
//        if(dp[ind][n] != -1){
//            return dp[ind][n];
//        }
//        int pick = Integer.MIN_VALUE;
//        int notPick = Integer.MIN_VALUE;
//        if(ind > 0) {
//            notPick = f(price, n, ind - 1,dp);
//            if (n >= ind + 1) {
//                pick = price[ind] + f(price, n - (ind + 1), ind,dp);
//            }
//        }
//        return dp[ind][n] = Math.max(pick,notPick);
//    }


    //tabulation
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int m=price.length;
        int[][] dp = new int[m][n+1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(price,n,dp);
    }
    static int f(int[] price, int n,int[][] dp){
        int m = price.length;
        for(int ind = 0;ind < m;ind++){
            for (int segments = 0;segments <= n;segments++){
                // base cases (think of having one element in array)
                if(ind == 0){
                    if(segments >= 1){
                        dp[ind][segments] = segments * price[0];
                        continue;
                    }
                    dp[ind][segments] = 0;
                    continue;
                }
                int pick = Integer.MIN_VALUE;
                int notPick = Integer.MIN_VALUE;
                if(ind > 0) {
                    notPick = dp[ind - 1][segments];
                    if (segments >= ind + 1) {
                        pick = price[ind] + dp[ind][segments - (ind + 1)];
                    }
                }
                dp[ind][segments] = Math.max(pick,notPick);
            }
        }
        return dp[m-1][n];
    }
}
