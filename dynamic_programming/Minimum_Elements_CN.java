package dynamic_programming;

import java.util.Arrays;

public class Minimum_Elements_CN {
    public static void main(String[] args) {
     int[] ex1={1,2,3};
     int[] ex2={13,5,3};
        System.out.println(minimumElements(ex1,7));
        System.out.println(minimumElements(ex2,7));
    }

    //recursion
//    public static int minimumElements(int num[], int x) {
//        // Write your code here..
//        int n=num.length;
//        int ans=f(num,x,n-1);
//        if(ans >= (int)Math.pow(10,9)) {
//            return -1; //we can't form a sum, so we return -1
//        }
//        return ans;//else we return ans
//    }
//    static int f(int[] num,int x, int ind){
//        //base case
//        if(ind==0){
//            if(x%num[0]==0){
//                return x/num[0];
//            }
//            return (int)Math.pow(10,9); //we can't form a sum, so we return a very large number
//        }
//        int pick=Integer.MAX_VALUE;
//        int notPick=Integer.MAX_VALUE;
//        if(ind>0) {
//            if (x >= num[ind]) {
//                pick = 1 + f(num, x - num[ind], ind); // we count 1 element as picked
//            }
//           notPick= 0 + f(num, x, ind-1); //if x < num[ind], we count 0 element as picked
//        }
//        return Math.min(pick,notPick);
//    }


    //memoization
//    public static int minimumElements(int num[], int x) {
//        // Write your code here..
//        int n=num.length;
//        int[][] dp=new int[n][x+1];
//        for (int[] y:dp){
//            Arrays.fill(y,-1);
//        }
//
//        int ans=f(num,x,n-1,dp);
//
//        if(ans >= (int)Math.pow(10,9)) {
//            return -1; //we can't form a sum, so we return -1
//        }
//        return ans;//else we return ans
//    }
//    static int f(int[] num,int x, int ind,int[][] dp){
//        //base case
//        if(ind==0){
//            if(x%num[0]==0){
//                return x/num[0];
//            }
//            return (int)Math.pow(10,9); //we can't form a sum, so we return a very large number
//        }
//        if(dp[ind][x]!=-1){
//            return dp[ind][x];
//        }
//        int pick=Integer.MAX_VALUE;
//        int notPick=Integer.MAX_VALUE;
//        if(ind>0) {
//            if (x >= num[ind]) {
//                pick = 1 + f(num, x - num[ind], ind,dp); // we count 1 element as picked
//            }
//           notPick= 0 + f(num, x, ind-1,dp); //if x < num[ind], we count 0 element as picked
//        }
//        return dp[ind][x]=Math.min(pick,notPick);
//    }



    //tabulation
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n=num.length;
        int[][] dp=new int[n][x+1];
        for (int[] y:dp){
            Arrays.fill(y,-1);
        }

        int ans=f(num,x,dp); 

        if(ans >= (int)Math.pow(10,9)) {
            return -1; //we can't form a sum, so we return -1
        }
        return ans;//else we return ans
    }
    static int f(int[] num,int x,int[][] dp){
        int n=num.length;
        for (int ind=0;ind<n;ind++){
            for (int target=0;target<=x;target++){

                //base case
                if(ind==0){
                    if(target % num[0]==0){
                        dp[ind][target] = target / num[0];
                        continue;
                    }
                    dp[ind][target] = (int)Math.pow(10,9); //we can't form a sum, so we return a very large number
                    continue;
                }

                int pick=Integer.MAX_VALUE;
                int notPick=Integer.MAX_VALUE;
                if(ind>0) {
                    if (target >= num[ind]) {
                        pick = 1 + dp[ind][target-num[ind]];// we count 1 element as picked
                    }
                    notPick= 0 + dp[ind-1][target];//if x < num[ind], we count 0 element as picked
                }
                dp[ind][target]=Math.min(pick,notPick);
            }
        }
        return dp[n-1][x];
    }
}
