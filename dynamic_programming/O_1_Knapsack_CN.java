package dynamic_programming;

import java.util.Arrays;

public class O_1_Knapsack_CN {
    public static void main(String[] args) {
      int weight[] ={1,2,4,5};
      int value[] ={5,4,8,6};
        System.out.println(knapsack(weight,value,4,5));
    }


    //recursion
//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//
//        /* Your class should be named Solution
//         * Don't write main().
//         * Don't read input, it is passed as function argument.
//         * Change in the given tree itself.
//         * No need to return or print the output.
//         * Taking input and printing output is handled automatically.
//         */
//        return f(weight,value,maxWeight,n-1);
//
//    }
//    static int f(int[] weight, int[] value, int maxWeight,int ind){
//     //base case
//        if(ind==0){
//            return (maxWeight>=weight[0])? value[0]:0;
//        }
//        if(ind<0){
//            return -1000000; //return a very small number so that it is never considered in max
//        }
//        int pick= Integer.MIN_VALUE;
//        int notPick=Integer.MIN_VALUE;
//        if(ind>0){
//            notPick=f(weight,value,maxWeight,ind-1);
//            if(maxWeight>=weight[ind]){
//                pick=value[ind]+f(weight,value,maxWeight-weight[ind],ind-1);
//            }
//        }
//        return Math.max(pick,notPick);
//    }



    //memoization
//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//
//        /* Your class should be named Solution
//         * Don't write main().
//         * Don't read input, it is passed as function argument.
//         * Change in the given tree itself.
//         * No need to return or print the output.
//         * Taking input and printing output is handled automatically.
//         */
//        int [][] dp=new int[n][maxWeight+1];
//        for (int[] x:dp){
//            Arrays.fill(x,-1);
//        }
//        return f(weight,value,maxWeight,n-1,dp);
//
//    }
//    static int f(int[] weight, int[] value, int maxWeight,int ind,int[][] dp){
//     //base case
//        if(ind==0){
//            return (maxWeight>=weight[0])? value[0]:0;
//        }
//        if(ind<0){
//            return -1000000; //return a very small number so that it is never considered in max
//        }
//        if(dp[ind][maxWeight]!=-1){
//            return dp[ind][maxWeight];
//        }
//        int pick= Integer.MIN_VALUE;
//        int notPick=Integer.MIN_VALUE;
//        if(ind>0){
//            notPick=f(weight,value,maxWeight,ind-1,dp);
//            if(maxWeight>=weight[ind]){
//                pick=value[ind]+f(weight,value,maxWeight-weight[ind],ind-1,dp);
//            }
//        }
//        return dp[ind][maxWeight]=Math.max(pick,notPick);
//    }


    //tabulation
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */
        int [][] dp=new int[n][maxWeight+1];
        for (int[] x:dp){
            Arrays.fill(x,-1);
        }
        return f(weight,value,maxWeight,dp);

    }
    static int f(int[] weight, int[] value, int maxWeight,int[][] dp){
        int n=weight.length;
        for(int ind=0;ind<n;ind++){
           for (int k=0;k<=maxWeight;k++){
               //base case
               if(ind==0){
                   dp[0][k]= (k>=weight[0])? value[0]:0;
                   continue;
               }
               int pick= Integer.MIN_VALUE;
               int notPick=Integer.MIN_VALUE;
               if(ind>0){
                   notPick=dp[ind-1][k];
                   if(k>=weight[ind]){
                       pick=value[ind]+dp[ind-1][k-weight[ind]];
                   }
               }
               dp[ind][k]=Math.max(pick,notPick);
           }
        }
        return dp[n-1][maxWeight];
    }
}
