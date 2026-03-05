package dynamic_programming;

import java.util.Arrays;

public class Fibonacci_Seq_By_Memoization {
    public static void main(String[] args) {
        int n=7;
        int[] dp=new int[n+1]; //Step1: create a dp array
        Arrays.fill(dp,-1);
        System.out.println(f(n,dp));
    }
    static int f(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n]; //Step2: check if the subproblem is calculated, if calculated the return it
        return dp[n]=f(n-1,dp)+f(n-2,dp); //Step3: if not calculated then calculate it then store and then return
    }
}
