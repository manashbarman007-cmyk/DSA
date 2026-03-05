package dynamic_programming;

import java.util.Arrays;

public class Wildcard_Pattern_Matching_CN {
    public static void main(String[] args) {
        System.out.println(wildcardMatching("?ay", "ray"));
        System.out.println(wildcardMatching("ab*cd", "abdefcd"));
        System.out.println(wildcardMatching("ab?d", "abcc"));
    }


    //recursion
//    public static boolean wildcardMatching(String pattern, String text) {
//        // Write your code here.
//        int n = pattern.length(), m = text.length();
//        return f(pattern, text,  n - 1, m - 1);
//    }
//
//    static boolean f(String pattern, String text, int ind1, int ind2) {
//        int n = pattern.length(), m = text.length();
//        //base case
//        if (ind1 < 0 && ind2 < 0) { //both strings are exhausted
//            return true;
//        }
//        if (ind1 < 0) { // if String pattern is exhausted
//            return false;
//        }
//        if (ind2 < 0) { // if String text is exhausted
//            for (int i = 0; i <= ind1; i++) {
//                if (pattern.charAt(i) != '*') { //as only '*' can be of length = 0
//                    return  false;
//                }
//                return true;
//            }
//        }
//
//
//        if (pattern.charAt(ind1) == text.charAt(ind2) || pattern.charAt(ind1) == '?') {  //then they are matching
//            return f(pattern, text, ind1 - 1, ind2 - 1);
//        }
//        if (pattern.charAt(ind1) == '*') {
//            return f(pattern, text, ind1 - 1, ind2) || f(pattern, text, ind1, ind2 - 1);
//        }
//        return false; //if no characters are matched
//    }


    //memoization
    public static boolean wildcardMatching(String pattern, String text) {
        // Write your code here.
        int n = pattern.length(), m = text.length();
        int[][] dp = new int[n][m];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return f(pattern, text,  n - 1, m - 1,dp);
    }

    static boolean f(String pattern, String text, int ind1, int ind2,int[][] dp) {
        int n = pattern.length(), m = text.length();
        //base case
        if (ind1 < 0 && ind2 < 0) { //both strings are exhausted
            return true;
        }
        if (ind1 < 0 ) { // if String pattern is exhausted
            return false;
        }
        if (ind2 < 0 ) { // if String text is exhausted
            for (int i = 0; i <= ind1; i++) {
                if (pattern.charAt(i) != '*') { //as only '*' can be of length = 0
                    return  false;
                }
                return true; //else we return true
            }
        }
        if (dp[ind1][ind2] != -1) {
            return (dp[ind1][ind2] == 2)? true : false;
        }
        if (pattern.charAt(ind1) == text.charAt(ind2) || pattern.charAt(ind1) == '?') {  //then they are matching
            dp[ind1][ind2] = f(pattern, text, ind1 - 1, ind2 - 1, dp) ? 2 : 1;
            return f(pattern, text, ind1 - 1, ind2 - 1, dp);
        }
        if (pattern.charAt(ind1) == '*') {
            dp[ind1][ind2] = f(pattern, text, ind1 - 1, ind2, dp) ||
                    f(pattern, text, ind1, ind2 - 1, dp) ? 2 : 1;
            return f(pattern, text, ind1 - 1, ind2, dp) || f(pattern, text, ind1, ind2 - 1, dp);
        }
        return false; //if no characters are matched
    }
}
