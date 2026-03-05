package dynamic_programming;

import java.util.Arrays;

public class Print_LCS_CN {
    public static void main(String[] args) {
        String s1 = "abcde", s2= "bdgek";
        System.out.println(findLCS(5,5,s1,s2));
    }


    //main
    public static String findLCS(int n, int m, String s1, String s2){
        // Write your code here.
        int[][] dp = new int[n + 1][m + 1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(s1,s2,dp);
    }
    static String f(String s1,String s2,int[][] dp) {
        int n = s1.length(),m = s2.length();
        for(int ind1 = 0;ind1 <= n;ind1++){
            for (int ind2 = 0;ind2 <= m;ind2++){
                //base case
                if(ind1 == 0 || ind2 == 0){
                    dp[ind1][ind2] = 0; //else we return 0, ie no common subsequence
                    continue;
                }
                if(ind1 > 0 && ind2 > 0) {
                    if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                        continue;
                    }
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]); //else we return this
                }
            }
        }
        int length = dp[n][m]; //this is the length of the lcs
        char[] ch = new char[length];
        int ind1 = n,ind2 = m;
        while (ind1 > 0 && ind2 > 0){
            if (s1.charAt(ind1 -1) == s2.charAt(ind2 - 1)){
                ch[length - 1] = s1.charAt(ind1 -1);
                length--;
                ind1--;
                ind2--;
            }
            else{
                if(dp[ind1 - 1][ind2] > dp[ind1][ind2 - 1]){
                    ind1--; //move up
                }
                else { // dp[ind1 - 1][ind2] <= dp[ind1][ind2 - 1]
                    ind2--; //move left
                }
            }
        }
        return new String(ch);
    }
}
