package dynamic_programming;

import java.util.Arrays;

public class Distinct_Subsequences_CN {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag","bag"));
    }


    //recursion
//    public static int numDistinct(String S, String T) {
//        // Write your code here
//        int n = S.length(),m = T.length();
//        return f(S,T,n - 1,m - 1);
//    }
//    static int f(String S,String T,int ind1,int ind2) {
//        //base case
//        if (ind2 < 0) { //we have exhausted string T
//            return 1; //ie we got a subsequence of T in S
//        }
//        if(ind1 < 0) { //String S is exhausted
//            return 0;
//        }
//        if(S.charAt(ind1) == T.charAt(ind2)){
//            return f(S,T,ind1 - 1,ind2 - 1) + f(S,T,ind1 - 1,ind2);
//        }
//        return f(S,T,ind1 - 1,ind2);
//    }


    //memoization
//    public static int numDistinct(String S, String T) {
//        // Write your code here
//        int n = S.length(),m = T.length();
//        int[][] dp = new int[n][m];
//        for (int[] x : dp){
//            Arrays.fill(x,-1);
//        }
//        return f(S,T,n - 1,m - 1,dp);
//    }
//    static int f(String S,String T,int ind1,int ind2,int[][] dp) {
//        //base case
//        if (ind2 < 0) { //we have exhausted string T
//            return 1; //ie we got a subsequence of T in S
//        }
//        if(ind1 < 0) { //String S is exhausted
//            return 0;
//        }
//        if(dp[ind1][ind2] != -1) {
//            return dp[ind1][ind2];
//        }
//        if(S.charAt(ind1) == T.charAt(ind2)){
//            return dp[ind1][ind2] = f(S,T,ind1 - 1,ind2 - 1,dp) + f(S,T,ind1 - 1,ind2,dp);
//        }
//        return dp[ind1][ind2] = f(S,T,ind1 - 1,ind2,dp);
//    }


    //tabulation
    public static int numDistinct(String S, String T) {
        // Write your code here
        int n = S.length(),m = T.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(S,T,dp);
    }
    static int f(String S,String T,int[][] dp) {
        int n = S.length(), m = T.length();
        for (int ind1 = 0;ind1 <= n;ind1++){
            for (int ind2 = 0;ind2 <= m; ind2++){
                //base case
                if (ind2 == 0) {
                    dp[ind1][ind2] = 1;
                    continue;
                }
                if(ind1 == 0) {
                    dp[ind1][ind2] = 0;
                    continue;
                }
                if(S.charAt(ind1 - 1) == T.charAt(ind2 - 1)){
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1] + dp[ind1 - 1][ind2];
                    continue;
                }
                dp[ind1][ind2] = dp[ind1 - 1][ind2];
            }
        }
       return dp[n][m];
    }
}
