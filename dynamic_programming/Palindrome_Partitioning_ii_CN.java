package dynamic_programming;

import java.util.Arrays;

public class Palindrome_Partitioning_ii_CN {
    public static void main(String[] args) {
       String str = "aaccb";
        System.out.println(palindromePartitioning(str));
    }


    // recursion
//    public static int palindromePartitioning(String str) {
//        // Write your code here
//        return f(str, 0) - 1;
//    }
//    static int f(String str, int ind) {
//        int n = str.length();
//        //base case
//        if (ind == n) { //the whole string is checked
//          return 0; // as we cannot make a partition
//        }
//        int minPartition = (int) Math.pow(10,9);
//        for (int k = ind; k < n; k++) {
//            if (isPalindrome(str, ind, k)) {
//                int partition = 1 + f(str, k + 1);
//                minPartition = Math.min(minPartition, partition);
//            }
//        }
//        return minPartition;
//    }
//
//    //two pointer method to check palindrome
//    static boolean isPalindrome (String str, int start, int end) {
//        while (start <= end) {
//            if (str.charAt(start) != str.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true; // else we return true
//    }


    // memoization
    public static int palindromePartitioning(String str) {
        // Write your code here
        int n = str.length();
        int[] dp =new int[n];
        Arrays.fill(dp, -1);
        return f(str, 0, dp) - 1;
    }
    static int f(String str, int ind, int [] dp) {
        int n = str.length();
        //base case
        if (ind == n) { //the whole string is checked
          return 0; // as we cannot make a partition
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int minPartition = (int) Math.pow(10,9);
        for (int k = ind; k < n; k++) {
            if (isPalindrome(str, ind, k)) {
                int partition = 1 + f(str, k + 1, dp);
                minPartition = Math.min(minPartition, partition);
            }
        }
        return dp[ind] = minPartition;
    }

    //two pointer method to check palindrome
    static boolean isPalindrome (String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true; // else we return true
    }
}
