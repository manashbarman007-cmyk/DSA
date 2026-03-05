package dynamic_programming;

import java.util.Arrays;

public class Subset_Sum_Equal_To_K {
    public static void main(String[] args) {
    int[] ex = {1,2,3,4};
        System.out.println(subsetSumToK(4,4,ex));
    }
//    public static boolean subsetSumToK(int n, int k, int arr[]){
//        // Write your code here.
//        return f(n,k,arr,n-1);
//    }
//
//    //recursion
//    static boolean f(int n,int k,int[] arr, int ind){
//        //base cass
//        if(k==0){
//            return true;
//        }
//        if(ind==0){ // If we have considered all elements but haven't reached the target, return false
//            return arr[ind]==k;
//        }
//        boolean pick=false; //initialize it as false
//        if(k>=arr[ind]){
//        pick=f(n,k-arr[ind],arr,ind-1);
//        }
//        boolean notPick=f(n,k,arr,ind-1);
//
//        return pick || notPick;
//    }

    //memoization
//    public static boolean subsetSumToK(int n, int k, int arr[]){
//        // Write your code here.
//        int[][] dp=new int[n][k+1]; //k+1, so that we can include target in the index
//        for (int[] x:dp){
//            Arrays.fill(x,-1);
//        }
//        return f(n,k,arr,n-1,dp);
//    }
//
//    static boolean f(int n,int k,int[] arr, int ind,int[][] dp){
//        //base cass
//        if(k==0){
//            return true;
//        }
//        if(ind==0){ // If we have considered all elements but haven't reached the target, return false
//            return arr[ind]==k;
//        }
//        if(dp[ind][k] != -1){
//          return dp[ind][k] == 1 ? true:false ;
//        }
//        boolean pick=false; //initialize it as false
//        if(k>=arr[ind]){
//        pick=f(n,k-arr[ind],arr,ind-1,dp);
//        }
//        boolean notPick=f(n,k,arr,ind-1,dp);
//
//        dp[ind][k] = (pick || notPick) ? 1:0;
//        return pick || notPick;
//    }


    //tabulation
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp=new boolean[n][k+1]; //k+1, so that we can include target in the index
                                            // all the elements are set to "false" by default

        //base cases
        for (int i=0;i<n;i++){
            //base case1
            dp[i][0]=true; //when k==0

            //base case2
            if(arr[0]<=k){
                dp[0][arr[0]]=true; //when arr[0] == k
            }
        }
        return f(n,k,arr,dp);
    }

    static boolean f(int n,int k,int[] arr,boolean[][] dp){
        //base cass
        for(int ind=1;ind<n;ind++){ //ind=0 is already considered in base case
            for (int target=1;target<=k;target++){ //target=0 is already considered in base case

                boolean pick=false; //initialize it as false

                if(target>=arr[ind]){
                    pick=dp[ind-1][target-arr[ind]];
                }
                boolean notPick=dp[ind-1][target];

                dp[ind][target] = (pick || notPick);
            }
        }
      return dp[n-1][k];
    }
}
