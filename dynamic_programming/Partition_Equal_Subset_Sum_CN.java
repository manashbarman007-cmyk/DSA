package dynamic_programming;

public class Partition_Equal_Subset_Sum_CN {
    public static void main(String[] args) {
       int[] ex1={3,1,1,2,2,1};
       int[] ex2={2,3,3,3,4,5};
       int[] ex3={2,3,3};
        System.out.println(canPartition(ex1,6));
        System.out.println(canPartition(ex2,6));
        System.out.println(canPartition(ex3,3));
    }

    //recursive
//    public static boolean canPartition(int[] arr, int n) {
//        // Write your code here.
//        int sum=0;
//        for(int i=0;i<n;i++){
//           sum+=arr[i];
//        }
//        if(sum % 2 == 0) {
//            return f(arr, n, n - 1, sum / 2);
//        }
//        return false; //if sum is odd
//    }
//
//    static boolean f(int[] arr, int n,int ind, int target){ //target=sum/2
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

    //tabulation
    public static boolean canPartition(int[] arr, int n) {
        // Write your code here.
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=arr[i];
        }
        int target=sum/2;

        boolean[][] dp=new boolean[n][target+1]; //all the elements are set to 0 by default

        for(int i=0;i<n;i++){
            //base case
            dp[i][0]=true; //if target==0 we return true
            if(arr[0] <= target){
                dp[0][arr[0]]=true;
            }
        }
        if(sum % 2 == 0) {
            return f(arr, n, target,dp);
        }
        return false; //if sum is odd
    }

    static boolean f(int[] arr, int n,int target, boolean[][] dp){ //target=sum/2
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
