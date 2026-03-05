package dynamic_programming;

import java.util.Arrays;

public class Longest_Common_Subsequence_CN {
    public static void main(String[] args) {
        System.out.println(getLengthOfLCS("abcde","bdgek"));
    }

    //recursion
//    public static int getLengthOfLCS(String  str1, String  str2)
//    {
//        // Write your code here.
//        int n = str1.length();
//        int m = str2.length();
//        return f(str1,str2,n - 1,m - 1);
//    }
//    static int f(String  str1, String  str2,int ind1,int ind2){
//        // base case
//        if(ind1 < 0 || ind2 < 0){
//            return 0;
//        }
//        if(str1.charAt(ind1) == str2.charAt(ind2)){
//            return 1 + f(str1,str2,ind1 - 1,ind2 - 1);
//        }
//        return Math.max(f(str1,str2,ind1,ind2 - 1),f(str1,str2,ind1 - 1,ind2)); //else we return this
//    }


    //memoization
//    public static int getLengthOfLCS(String  str1, String  str2)
//    {
//        // Write your code here.
//        int n = str1.length();
//        int m = str2.length();
//        int[][] dp = new int[n][m];
//        for (int[] x : dp){
//            Arrays.fill(x,-1);
//        }
//        return f(str1,str2,n - 1,m - 1,dp);
//    }
//    static int f(String  str1, String  str2,int ind1,int ind2,int[][] dp){
//        // base case
//        if(ind1 < 0 || ind2 < 0){
//            return 0;
//        }
//        if(dp[ind1][ind2] != -1){
//            return dp[ind1][ind2];
//        }
//        if(str1.charAt(ind1) == str2.charAt(ind2)){
//            return 1 + f(str1,str2,ind1 - 1,ind2 - 1,dp);
//        }
//        return dp[ind1][ind2] = Math.max(f(str1,str2,ind1,ind2 - 1,dp),f(str1,str2,ind1 - 1,ind2,dp)); //else we return this
//    }


    //tabulation
    public static int getLengthOfLCS(String  str1, String  str2)
    {
        // Write your code here.
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(str1,str2,dp);
    }
    static int f(String  str1, String  str2,int[][] dp){
        int n = str1.length(),m = str2.length();
        for(int ind1 = 0;ind1 <= n;ind1++){
            for (int ind2 = 0;ind2 <= m;ind2++){
                //base case
                if(ind1 == 0 || ind2 == 0){
                    dp[ind1][ind2] = 0; //else we return 0, ie no common subsequence
                    continue;
                }
                if(ind1 > 0 && ind2 > 0) {
                    if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                        continue;
                    }
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]); //else we return this
                }
            }
        }
        return dp[n][m];
    }
}
