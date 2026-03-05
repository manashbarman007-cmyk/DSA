package dynamic_programming;

import java.util.Arrays;

public class Climbing_Stairs_Leetcode_70 {
    public static void main(String[] args) {
        Climbing_Stairs_Leetcode_70 obj=new Climbing_Stairs_Leetcode_70();
        System.out.println(obj.climbStairs(3));
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);
    }
    static int func(int ind,int[] dp){
        //base case
      dp[0]=1;
      dp[1]=1;
      if(dp[ind]!=-1) return dp[ind];

      return dp[ind]=func(ind-1,dp)+func(ind-2,dp);
    }

}
