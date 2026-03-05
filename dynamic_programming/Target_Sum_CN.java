package dynamic_programming;

import java.util.Arrays;

public class Target_Sum_CN {
    public static void main(String[] args) {
        int[] ex1 = {1,1,1,1,1};
        int[] ex2 = {5,13,10,25,16,21,7,13,7};
        System.out.println(targetSum(5,3,ex1));
        System.out.println(targetSum(9,34,ex2));

    }

    //recursion
//    public static int targetSum(int n, int target, int[] arr) {
//        // Write your code here.
//        int sum = 0;
//        for (int i=0;i<n;i++){
//            sum += arr[i];
//        }
//        if(((((double)target+sum)/2) % 1) == 0){ //the quantity must be an integer
//            int s1 = (target+sum)/2;
//            return f(s1,arr,n-1);
//        }
//        return 0; //else return 0
//    }
//    static int f(int target,int[] arr,int ind){
//        //base cases (if we have reached the first element)
//        if(ind==0){
//            if(target==0 && arr[0] == 0){
//                return 2; //as we can either pick the element or not pick it
//            }
//            if(target == arr[0] || target == 0){
//                return 1; //as we pick it
//            }
//            return 0; //else always return 0
//        }
//        int notPick = f(target,arr,ind-1);
//        int pick = 0;
//        if(target >= arr[ind]){
//            pick = f(target-arr[ind],arr,ind-1);
//        }
//        return pick+notPick;
//    }

    //memoization
//    public static int targetSum(int n, int target, int[] arr) {
//        // Write your code here.
//        int sum = 0;
//        for (int i=0;i<n;i++){
//            sum += arr[i];
//        }
//        if(((((double)target+sum)/2) % 1) == 0){ //the quantity must be an integer
//            int s1 = (target+sum)/2;
//            int[][] dp= new int[n][s1+1];
//            for (int[] x:dp){
//                Arrays.fill(x,-1);
//            }
//            return f(s1,arr,n-1,dp);
//        }
//        return 0; //else return 0
//    }
//    static int f(int target,int[] arr,int ind,int[][] dp){
//        //base cases (if we have reached the first element)
//        if(ind==0){
//            if(target==0 && arr[0] == 0){
//                return 2; //as we can either pick the element or not pick it
//            }
//            if(target == arr[0] || target == 0){
//                return 1; //as we pick it
//            }
//            return 0; //else always return 0
//        }
//        if(dp[ind][target] != -1){
//            return dp[ind][target];
//        }
//        int notPick = f(target,arr,ind-1,dp);
//        int pick = 0;
//        if(target >= arr[ind]){
//            pick = f(target-arr[ind],arr,ind-1,dp);
//        }
//        return dp[ind][target] = pick+notPick;
//    }


    //tabulation
    public static int targetSum(int n, int target, int[] arr) {
        // Write your code here.
        int sum = 0;
        for (int i=0;i<n;i++){
            sum += arr[i];
        }
        if(((((double)target+sum)/2) % 1) == 0){ //the quantity must be an integer
            int s1 = (target+sum)/2;
            int[][] dp= new int[n][s1+1];
            for (int[] x:dp){
                Arrays.fill(x,-1);
            }
            return f(s1,arr,dp);
        }
        return 0; //else return 0
    }
    static int f(int target,int[] arr,int[][] dp){
        int n=arr.length;
        for (int ind=0;ind<n;ind++){
            for (int k=0;k<=target;k++){
                //base cases (if we have reached the first element)
                if(ind==0){
                    if(k==0 && arr[0]==0){
                        dp[ind][k]=2;
                        continue;
                    }
                    if (k==0 || k==arr[0]){
                        dp[ind][k]=1;
                        continue;
                    }
                    dp[ind][k]=0;
                    continue;
                }
                int notPick = dp[ind-1][k];
                int pick = 0;
                if(k >= arr[ind]){
                    pick = dp[ind-1][k-arr[ind]];
                }
                dp[ind][k] = pick+notPick;
            }
        }
        return dp[n-1][target];
    }
}
