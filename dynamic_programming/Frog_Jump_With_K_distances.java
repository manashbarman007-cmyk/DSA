package dynamic_programming;

import java.util.Arrays;

public class Frog_Jump_With_K_distances {
    public static void main(String[] args) {
        int[] ex1 = {30, 20, 50, 10, 40};
        int[] ex2 = {17, 6, 12, 10, 3, 13, 17, 20, 8};
        Frog_Jump_With_K_distances obj=new Frog_Jump_With_K_distances();
        System.out.println(obj.minCost(ex1));
        System.out.println(obj.minCost(ex2));

    }

    //recursive solution
//    int minCost(int[] height){
//         return possibleWays(height, height.length-1,20 );
//    }
//
//    static int possibleWays(int[] heights,int ind,int k){
//        //base case
//        if(ind==0){
//            return 0;
//        }
//        int minEnergy=Integer.MAX_VALUE;
//        for(int i=1;i<=k;i++){
//            if(ind>i-1){
//              int jumpEnergy= possibleWays(heights,ind-i,k)+Math.abs(heights[ind]-heights[ind-i]);
//              minEnergy=Math.min(jumpEnergy,minEnergy);
//            }
//        }
//        return minEnergy;
//    }


    //memoization
//    int minCost(int[] height){
//        int[] dp=new int[height.length];
//        Arrays.fill(dp,-1);
//
//        return possibleWays(height,dp,height.length-1,2);
//    }
//
//    static int possibleWays(int[] heights,int[] dp,int ind,int k){
//        //base case
//        if(ind==0){
//            return 0;
//        }
//        int minEnergy=Integer.MAX_VALUE;
//        if(dp[ind]!=-1){
//            return dp[ind];
//        }
//        for(int i=1;i<=k;i++){
//            if(ind>i-1){
//              int jumpEnergy= possibleWays(heights,dp,ind-i,k)+Math.abs(heights[ind]-heights[ind-i]);
//              minEnergy=Math.min(jumpEnergy,minEnergy);
//            }
//        }
//        return dp[ind]=minEnergy;
//    }


    //tabulation
    int minCost(int[] height){
        int[] dp=new int[height.length];
        Arrays.fill(dp,-1);
        return possibleWays(height,dp,2);
    }

    static int possibleWays(int[] heights,int[] dp,int k){
        //base case
        dp[0]=0;

        for(int i=1;i< dp.length;i++){  //this for loop plays the role of recursion

           int minEnergy=Integer.MAX_VALUE;

          // Loop to try all possible jumps from '1' to 'k'
          for(int j=1;j<=k;j++){
              if(i-j>=0){
                  int jumpEnergy=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                  minEnergy=Math.min(minEnergy,jumpEnergy);
              }
              dp[i]=minEnergy;
          }
        }

        return dp[dp.length-1];  //result is stored in the last index of dp
    }
}
