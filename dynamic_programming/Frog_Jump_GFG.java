package dynamic_programming;
import java.util.*;

public class Frog_Jump_GFG {
    public static void main(String[] args) {
        Frog_Jump_GFG obj = new Frog_Jump_GFG();
        int[] ex1 = {30, 20, 50, 10, 40};
        int[] ex2 = {17, 6, 12, 10, 3, 13, 17, 20, 8};
        System.out.println(obj.minCost(ex1));
        System.out.println(obj.minCost(ex2));
    }
//    Using recursion
//    int minCost(int[] height) {
//        // code here
//
//        int min = possibleWays(height, height.length - 1);
//        return min;
//    }
//
//    static int possibleWays(int[] height, int ind) {
//        //base case
//        if (ind == 0) {
//            return 0;
//        }
//        int jumpTwo = Integer.MAX_VALUE; //initialize it as this
//
//        int jumpOne = possibleWays(height, ind - 1) + Math.abs(height[ind] - height[ind - 1]);
//
//        if (ind > 1){
//            jumpTwo = possibleWays(height, ind - 2) + Math.abs(height[ind] - height[ind - 2]);
//        }
//
//        return Math.min(jumpOne, jumpTwo);
//    }

    //using memoisation
//    int minCost(int[] height) {
//        // code here
//        int[] dp= new int[height.length];
//        Arrays.fill(dp,-1);
//        int min = possibleWays(height, height.length - 1,dp);
//        return min;
//    }
//
//    static int possibleWays(int[] height, int ind,int[] dp) {
//        //base case
//        if(ind==0) return 0;
//        if(dp[ind]!=-1) return dp[ind]; //if result is already present
//        int jumpTwo = Integer.MAX_VALUE; //initialize it as this
//
//        int jumpOne = possibleWays(height, ind - 1,dp) + Math.abs(height[ind] - height[ind - 1]);
//
//        if (ind > 1){
//            jumpTwo = possibleWays(height, ind - 2,dp) + Math.abs(height[ind] - height[ind - 2]);
//        }
//        return dp[ind]=Math.min(jumpOne, jumpTwo);  //we store and return the result if the result is not calculated
//                                                    //previously
//    }


    //using tabulation (bottom up)
//    int minCost(int[] height) {
//        // code here
//        int[] dp= new int[height.length];
//        Arrays.fill(dp,-1);
//        int min = possibleWays(height,dp);
//        return min;
//    }
//    static int possibleWays(int[] height,int[] dp) {
//        //base case
//         dp[0]=0;
//         for(int i=1;i<dp.length;i++){  //this for loop plays the role of recursion
//             int minEnergy=Integer.MAX_VALUE;

//             int jumpOne=dp[i-1]+Math.abs(height[i]-height[i-1]);
//             if(i>1){
//                 jumpTwo=dp[i-2]+Math.abs(height[i]-height[i-2]);
//             }
//             dp[i]=Math.min(jumpOne,jumpTwo);
//         }
//         return dp[dp.length-1]; //result is stored in the last index of dp
//    }

    //space optimization
    int minCost(int[] height) {
        // code here
        int min = possibleWays(height);
        return min;
    }
    static int possibleWays(int[] height) {
        //base case
         int prev1=0;
         int prev2=0;

         for(int i=1;i<height.length;i++){
             int jumpTwo=Integer.MAX_VALUE;
             int jumpOne=prev1+Math.abs(height[i]-height[i-1]);

             if(i>1){
                 jumpTwo=prev2+(Math.abs(height[i]-height[i-2]));
             }

            int cur_i=Math.min(jumpOne,jumpTwo);
            prev2=prev1;
            prev1=cur_i;
         }
         return prev1;
    }
}