package dynamic_programming;

public class Longest_Palindromic_Subsequence_CN {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubsequence("bbabcbcab"));
    }
    public static int longestPalindromeSubsequence(String s) {
        // Write your code here.
        int n = s.length();
        char[] ch = new char[n];
        for(int i = 0;i < n;i++){
            ch[i] = s.charAt(i);
        }
        //now we reverse the char array
        for(int i = 0;i < n / 2;i++){
            char temp = ch[i];
            ch[i] = ch[n - 1 - i];
            ch[n - 1 - i] = temp;
        }
        String reverseS = new String(ch);
        int[][] dp = new int[n + 1][n + 1];
        return f(s,reverseS,dp);
    }
    static int f(String s,String reverseS,int[][] dp) {
        int n = s.length();
        for (int ind1 = 0; ind1 <= n;ind1++){
            for (int ind2 = 0;ind2 <= n;ind2++){
                //base case
                if (ind1 == 0 || ind2 == 0){
                    dp[ind1][ind2] = 0;
                    continue;
                }
                if(s.charAt(ind1 - 1) == reverseS.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2],dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
