package dynamic_programming;

import java.util.Arrays;

public class Min_Num_Of_Deletions_And_Insertions_CN {
    public static void main(String[] args) {
        System.out.println(canYouMake("abcd","anc"));
    }
    public static int canYouMake(String s1, String s2) {
        // Write your code here.
        int n = s1.length(),m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(s1,s2,dp);
    }
    static int f(String s1,String s2,int[][] dp) {
        int n = s1.length();
        int m = s2.length();
        for (int ind1 = 0; ind1 <= n;ind1++){
            for (int ind2 = 0;ind2 <= m;ind2++){
                //base case
                if (ind1 == 0 || ind2 == 0){
                    dp[ind1][ind2] = 0;
                    continue;
                }
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2],dp[ind1][ind2 - 1]);
                }
            }
        }
        return n + m - (2 * dp[n][m]);
    }
}
