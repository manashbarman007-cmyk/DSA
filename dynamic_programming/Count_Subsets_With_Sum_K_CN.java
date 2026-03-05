package dynamic_programming;

import java.util.Arrays;

public class Count_Subsets_With_Sum_K_CN {
    public static void main(String[] args) {
        int[] ex1={1,1,4,5};
        int[] ex2={0,0,1};
        int[] ex3={1,2,2,3};
        System.out.println(findWays(ex1,5));
        System.out.println(findWays(ex2,1));
        System.out.println(findWays(ex3,3));
    }

    //recursion
//    public static int findWays(int num[], int tar) {
//        // Write your code here.
//        int n=num.length;
//        return count+f(num,tar,n-1);
//    }
//    static int f(int[] num,int tar,int ind){
//        base case
//        if(ind==0){ //we have to check till the first element as 0 is present
//           if(tar==0 && num[0]==0){
//            return 2; //as we can either take the 0 or not take the 0 as it won't affect the sum
//           }
//           if(tar==0 || tar==num[0]){
//             return 1;
//           }
//             return 0; //else we return 0
//        }
//        int pick=0;
//        int mod=(int)Math.pow(10,9)+7;
//        if(tar>=num[ind]) {
//          pick = f(num, tar - num[ind], ind - 1); //we pick and move one index back
//        }
//         int notPick = f(num,tar,ind-1); //we don't pick and move one index back
//
//        return (pick+notPick)%mod;
//    }


    //memoization
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int n=num.length;
        int[][] dp=new int[n][tar+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(num,tar,n-1,dp);
    }
    static int f(int[] num,int tar,int ind,int[][] dp){
        //base case
        if(ind==0){ //we have to check till the first element as 0 is present
             if(tar==0 && num[0]==0){
                 return 2; //as we can either take the 0 or not take the 0 as it won't affect the sum
             }
             if(tar==0 || tar==num[0]){
                 return 1;
             }
             return 0; //else we return 0
        }
        if(dp[ind][tar] != -1){
            return dp[ind][tar];
        }
        int pick=0;
        int mod=(int)Math.pow(10,9)+1;
        if(tar>=num[ind]) {
          pick = f(num, tar - num[ind], ind - 1,dp); //we pick and move one index back
        }
         int notPick = f(num,tar,ind-1,dp); //we don't pick and move one index back

        return dp[ind][tar]=(pick+notPick)%mod;
    }


    //tabulation
//    public static int findWays(int num[], int tar) {
//        // Write your code here.
//        int n=num.length;
//        int count=0;
//        int[][] dp=new int[n][tar+1];
//        for (int i=0;i<n;i++){
//            if(num[i]==0) {
//                count++; //count the number of zeros in nums
//            }
//            Arrays.fill(dp[i],-1);
//        }
//        return count+f(num,tar,dp);
//    }
//    static int f(int[] num,int tar,int[][] dp){
//        //base case
//        int n=num.length;
//        for(int ind=0;ind<n;ind++){
//            for (int k=0;k<=tar;k++){
//                //base cases
//                if(k==0){
//                    dp[ind][0]=1;
//                    continue;
//                }
//                if(ind==0){
//                    dp[0][k]=(num[0]==k)? 1:0; //if num[0] != k we store 0, as it is not a valid subset
//                    continue;
//                }
//                int pick=0;
//                int mod=(int)Math.pow(10,9)+1;
//                if(k>=num[ind]) {
//                    pick = dp[ind-1][k-num[ind]]; //we pick and move one index back
//                }
//                int notPick =dp[ind-1][k]; //we don't pick and move one index back
//                dp[ind][k]=(pick+notPick)%mod;
//            }
//        }
//        return dp[n-1][tar];
//    }
}
