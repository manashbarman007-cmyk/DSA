package dynamic_programming;

import java.util.Arrays;

public class Partition_With_Given_Diff_CN {
    public static void main(String[] args) {
        int[] ex1={5,2,5,1};
        int[] ex2={5,2,6,4};
        int[] ex3={8,1};
        System.out.println(countPartitions(4,3,ex1));
        System.out.println(countPartitions(4,3,ex2));
        System.out.println(countPartitions(2,21,ex3));

    }

    //recursion
//    public static int countPartitions(int n, int d, int[] arr) {
//        // Write your code here.
//        int sum=0;
//        for(int i=0;i<n;i++){
//            sum+=arr[i];
//        }
//        int target=0;
//        if((sum-d)%2 == 0 && (sum-d)/2 > 0 ){
//            target=(sum-d)/2;
//            int dp[][]=new int[n][target+1];
//            for(int[] x:dp){
//               Arrays.fill(x,-1);
//             }
//            return f(arr,n-1,target,dp);
//         }
//         return 0;
//    }
//
//    static int f(int[] arr, int ind,int target){
//        //base case
//        if(ind==0){
//            if(target==0 && arr[0]==0){
//                return 2; //as we can either pick or not pck the 0 as it will not affect the sum
//            }
//            if(target==0 || target==arr[0]){
//                return 1;
//            }
//            return 0; //else we return 0
//        }
//        int mod=(int)Math.pow(10,9)+7;
//        int notPick=f(arr,ind-1,target);
//        int pick=0;
//        if(target>=arr[ind]){
//            pick=f(arr,ind-1,target-arr[ind]);
//        }
//        return (pick+notPick)%mod;
//    }

    //memoization
//    public static int countPartitions(int n, int d, int[] arr) {
//        // Write your code here.
//        int sum=0;
//        for(int i=0;i<n;i++){
//            sum+=arr[i];
//        }
//        int target=0;
//        if((sum-d)%2 == 0 && (sum-d)/2 > 0 ){
//            target=(sum-d)/2;
//            int dp[][]=new int[n][target+1];
//            for(int[] x:dp){
//                Arrays.fill(x,-1);
//            }
//            return f(arr,n-1,target,dp);
//        }
//      return 0;
//    }
//
//    static int f(int[] arr, int ind,int target,int[][] dp){
//        //base case
//        if(ind==0){
//            if(target==0 && arr[0]==0){
//                return 2; //as we can either pick or not pck the 0 as it will not affect the sum
//            }
//            if(target==0 || target==arr[0]){
//                return 1;
//            }
//            return 0; //else we return 0
//        }
//        if(dp[ind][target]!=-1){
//            return dp[ind][target];
//        }
//        int mod=(int)Math.pow(10,9)+7;
//        int notPick=f(arr,ind-1,target,dp);
//        int pick=0;
//        if(target>=arr[ind]){
//            pick=f(arr,ind-1,target-arr[ind],dp);
//        }
//        return dp[ind][target]=(pick+notPick)%mod;
//    }

    //tabulation
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int target=0;
        if((sum-d)%2 == 0 && (sum-d)/2 > 0 ){
            target=(sum-d)/2;
            int dp[][]=new int[n][target+1];
            for(int[] x:dp){
                Arrays.fill(x,-1);
            }
            return f(arr,target,dp);
        }
      return 0;
    }

    static int f(int[] arr,int target,int[][] dp){
        int n=arr.length;
        for(int ind=0;ind<n;ind++){
            for (int k=0;k<=target;k++){
                //base cases
                if(ind==0){
                    if(k==0 && arr[0]==0){
                        dp[ind][k]=2;
                        continue;
                    }
                    if (k==0 || k==arr[0]){
                        dp[ind][k]=1;
                        continue;
                    }
                    dp[ind][k]=0; //else condition
                    continue;
                }
                int mod=(int)Math.pow(10,9)+7;
                int notPick=dp[ind-1][k];
                int pick=0;
                if(k>=arr[ind]){
                    pick=dp[ind-1][k-arr[ind]];
                }
                dp[ind][k]=(pick+notPick)%mod;
            }
        }
        return dp[n-1][target];
    }
}
