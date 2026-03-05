package dynamic_programming;

import java.util.Arrays;

public class Shortest_Common_Supersequence {
    public static void main(String[] args) {
        System.out.println(shortestSupersequence("brute","groot"));
    }
    public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        int n = a.length(),m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(a,b,dp);
    }
    static String f(String  str1, String  str2,int[][] dp){
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
        int length = (n + m) - dp[n][m];
        char[] ch = new char[length];
        int ind1 = n,ind2 = m;
        while (ind1 > 0 && ind2 > 0){
            if (str1.charAt(ind1 - 1) != str2.charAt(ind2 - 1)){
                if(dp[ind1][ind2] > dp[ind1][ind2 - 1]){
                    ch[length - 1] = str1.charAt(ind1 - 1);
                    ind1--; //move up
                }
                else { // if (dp[ind1][ind2] <= dp[ind1][ind2 - 1])
                    ch[length - 1] = str2.charAt(ind2 - 1);
                    ind2--; //move left
                }
            }
            else { //if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1))
                ch[length - 1] = str1.charAt(ind1 - 1); //store the common letter once
                ind1--;
                ind2--;
            }
            length--;
        }

        //to add the remaining characters
        while (ind1 > 0){ //if str2 is exhausted
          ch[length - 1] = str1.charAt(ind1 - 1);
          length--;
          ind1--;
        }
        while (ind2 > 0){ //if str1 is exhausted
          ch[length - 1] = str2.charAt(ind2 - 1);
          length--;
          ind2--;
        }
        return new String(ch);
    }
}
