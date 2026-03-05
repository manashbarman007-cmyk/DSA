package dynamic_programming;

import java.util.Arrays;

public class Longest_Common_Substring_CN {
    public static void main(String[] args) {
        System.out.println(lcs("abcjklp","acjkp"));
    }
    //recursive code
    public static int lcs(String str1, String str2) {
        // Write your code here.
        int n = str1.length(),m = str2.length();

        return f(str1,str2,n - 1,m - 1,0);
    }
    static int f(String str1,String str2,int ind1,int ind2,int res) {
        //base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            res = f(str1, str2, ind1 - 1, ind2 - 1, res + 1);
        }
        return Math.max(res,Math.max(f(str1, str2, ind1, ind2 - 1, 0 ),f(str1, str2, ind1 - 1, ind2 , 0)));
    }

    //using tabulation
//    public static int lcs(String str1, String str2) {
//        // Write your code here.
//        int n = str1.length(),m = str2.length();
//        int[][] dp = new int[n + 1][m + 1];
//        for (int[] x : dp){
//            Arrays.fill(x,-1);
//        }
//        return f(str1,str2,dp);
//    }
//    static int f(String str1,String str2,int[][] dp){
//        int n = str1.length(),m = str2.length();
//        int ans = 0; //we will store the longest common substring here
//
//        for (int ind1 = 0;ind1 <= n;ind1++){
//            for (int ind2 = 0;ind2 <= m;ind2++){
//
//                //base case
//                if (ind1 == 0 || ind2 == 0){ //ie if either of the string is exhausted
//                    dp[ind1][ind2] = 0;
//                    continue;
//                }
//                if(str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)){
//                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
//                    ans = Math.max(ans,dp[ind1][ind2]);
//                }
//                else {
//                    dp[ind1][ind2] = 0;
//                }
//            }
//        }
//        return ans;
//    }

}
