package dynamic_programming;

import java.util.Arrays;

public class Fibonacci_Seq_By_Tabulation {
    public static void main(String[] args) {
        int n=7;
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
//        System.out.println(f(n,dp));
        System.out.println(f2(7));
    }

    //tabulation
//    static int f(int n, int[] dp){
//        dp[0]=0; //define the base case
//        dp[1]=1; //define the base case
//        for(int i=2;i<=n;i++){ //this for loop plays the role of recursion
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];  //result is stored in the last index of dp
//    }


    //Space optimization
    static int f2(int n){
        int prev2=0; //base case1 for n=0
        int prev1=1; //base case2 for n=1
        for (int i=2;i<=n;i++){
            int cur_i=prev2+prev1;
            prev2=prev1;
            prev1=cur_i;
        }
        return prev1;
    }
}