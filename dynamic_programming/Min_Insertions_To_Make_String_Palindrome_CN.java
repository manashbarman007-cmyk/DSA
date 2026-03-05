package dynamic_programming;

import java.util.Arrays;

public class Min_Insertions_To_Make_String_Palindrome_CN {
    public static void main(String[] args) {
        System.out.println(minInsertion("abca"));
        System.out.println(minInsertion("aaaaa"));
        System.out.println(minInsertion("abcdefg"));
    }
    public static int minInsertion(String str) {
        // Write your code here.
        int n = str.length();
        char[] ch = new char[n];
        for(int i = 0;i < n;i++){
            ch[i] = str.charAt(i);
        }
        //now we reverse the char array
        for(int i = 0;i < n / 2;i++){
            char temp = ch[i];
            ch[i] = ch[n - 1 - i];
            ch[n - 1 - i] = temp;
        }
        String reverseS = new String(ch);
        int[][] dp = new int[n + 1][n + 1];
        for (int[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(str,reverseS,dp);
    }
    static int f(String str,String reverseS,int[][] dp) {
        int n = str.length();
        for (int ind1 = 0; ind1 <= n;ind1++){
            for (int ind2 = 0;ind2 <= n;ind2++){
                //base case
                if (ind1 == 0 || ind2 == 0){
                    dp[ind1][ind2] = 0;
                    continue;
                }
                if(str.charAt(ind1 - 1) == reverseS.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2],dp[ind1][ind2 - 1]);
                }
            }
        }
        return n - dp[n][n];
    }
}
