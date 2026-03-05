package dynamic_programming;


import java.util.Arrays;

public class Edit_Distance_CN {
    public static void main(String[] args) {
        System.out.println(editDistance("abc","dc"));
        System.out.println(editDistance("whgtdwhgtdg","aswcfg"));
    }


    //recursion
//    public static int editDistance(String str1, String str2) {
//        //Your code goes here
//        int n = str1.length(),m = str2.length();
//        return f(str1,str2,n - 1, m - 1);
//    }
//    static int f(String  str1, String  str2,int ind1,int ind2) {
//        int n = str1.length(),m = str2.length();
//
//        //base case
//        if(ind1 < 0) { //if str1 gets exhausted
//            return ind2 + 1;
//        }
//        if (ind2 < 0) { //if str2 gets exhausted
//            return ind1 + 1;
//        }
//        if (str1.charAt(ind1) == str2.charAt(ind2)) { //no changes have to be made
//            return f(str1, str2, ind1 - 1, ind2 - 1);
//        }
//        //in case of miss match
//        int notMatch = 1 + Math.min(f(str1, str2, ind1, ind2 - 1),
//                                    Math.min(f(str1, str2, ind1 - 1, ind2),f(str1, str2, ind1 - 1, ind2 - 1)));
//
//        return notMatch;
//    }


    //memoization
    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int n = str1.length(),m = str2.length();
        int[][] dp = new int[n][m];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(str1,str2,n - 1, m - 1,dp);
    }
    static int f(String  str1, String  str2,int ind1,int ind2,int[][] dp) {
        int n = str1.length(),m = str2.length();

        //base case
        if(ind1 < 0) { //if str1 gets exhausted
            return ind2 + 1;
        }
        if (ind2 < 0) { //if str2 gets exhausted
            return ind1 + 1;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (str1.charAt(ind1) == str2.charAt(ind2)) { //no changes have to be made
            return dp[ind1][ind2] = f(str1, str2, ind1 - 1, ind2 - 1,dp);
        }
        //in case of miss match
        int notMatch = 1 + Math.min(f(str1, str2, ind1, ind2 - 1,dp),
                                    Math.min(f(str1, str2, ind1 - 1, ind2,dp),f(str1, str2, ind1 - 1, ind2 - 1,dp)));

        return dp[ind1][ind2] = notMatch;
    }
}
