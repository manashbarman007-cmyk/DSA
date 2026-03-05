package dynamic_programming;

import java.util.Arrays;

public class Array_Partition_With_Min_Diff_CN {
    public static void main(String[] args) {
      int[] ex1={3,1,5,2,8};
      int[] ex2={8,6,5};
        System.out.println(minSubsetSumDifference(ex1,5));
        System.out.println(minSubsetSumDifference(ex2,3));
    }

    //recursion
//    public static int minSubsetSumDifference(int []arr, int n) {
//        // Write your code here.
//        int sum=0;
//        for (int i=0;i<n;i++){
//            sum+=arr[i];
//        }
//        int target=sum/2;
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<=target;i++){
//           if(f(arr,n,n-1,i)){
//               min=Math.min(min,sum-(2*i));
//           }
//        }
//       return min;
//    }
//    static boolean f(int[] arr,int n,int ind, int target){
//        //base case
//        if(target==0){
//            return true;
//        }
//        if(ind==0){
//            return arr[0]==target;
//        }
//        boolean notPick=f(arr,n,ind-1,target);
//        boolean pick=false;
//        if(target>=arr[ind]){
//            pick=f(arr,n,ind-1,target-arr[ind]);
//        }
//        return pick||notPick;
//    }

    //memoization
//    public static int minSubsetSumDifference(int []arr, int n) {
//        // Write your code here.
//        int sum=0;
//        for (int i=0;i<n;i++){
//            sum+=arr[i];
//        }
//        int target=sum/2;
//        int dp[][]=new int[n][target+1];
//        for(int[] x:dp){
//            Arrays.fill(x,-1);
//        }
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<=target;i++){
//           if(f(arr,n,n-1,i,dp)){
//               min=Math.min(min,sum-(2*i));
//           }
//        }
//       return min;
//    }
//    static boolean f(int[] arr,int n,int ind, int target,int[][] dp){
//        //base case
//        if(target==0){
//            return true;
//        }
//        if(ind==0){
//            return arr[0]==target;
//        }
//        if(dp[ind][target]!=-1){
//            return dp[ind][target]==1?true:false;
//        }
//        boolean notPick=f(arr,n,ind-1,target,dp);
//        boolean pick=false;
//        if(target>=arr[ind]){
//            pick=f(arr,n,ind-1,target-arr[ind],dp);
//        }
//        dp[ind][target]=(pick||notPick)?1:0;
//        return pick||notPick;
//    }


    //tabulation
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
        }
        int target=sum/2;
        boolean dp[][]=new boolean[n][target+1]; //all elements are set to false by default

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            //base case
            dp[i][0]=true; //if target==0 we return true
            if(arr[0] <= target){
                dp[0][arr[0]]=true;
            }
        }

        for(int i=0;i<=target;i++){
           if(f(arr,n,i,dp)){
               min=Math.min(min,sum-(2*i));
           }
        }
       return min;
    }
    static boolean f(int[] arr,int n, int target,boolean[][] dp){
        for(int ind=1; ind<n;ind++){
            for (int k=1;k<=target;k++){
                boolean notPick=dp[ind-1][k];
                boolean pick=false;
                if(k>=arr[ind]){
                    pick=dp[ind-1][k-arr[ind]];
                }
                dp[ind][k]=pick||notPick;
            }
        }

        return dp[n-1][target];
    }
}
