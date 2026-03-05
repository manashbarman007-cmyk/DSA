package dynamic_programming;

import java.util.Arrays;

public class Triangle_CN {
    public static void main(String[] args) {
        int[][] ex={{2},
                    {3,4},
                    {6,5,7},
                    {4,1,8,3}};
        System.out.println(minimumPathSum(ex,4));
}

    //recursion
//    public static int minimumPathSum(int[][] triangle, int n) {
//        // Write your code here.
//        return f(triangle,n,0,0);
//    }
//    static int f(int[][] triangle,int n,int row,int col){
//        //base case
//        if(row==n-1){ //destination
//            return triangle[n-1][col];
//        }
//        if(row>n-1 || col>triangle[row].length - 1){
//            return (int)Math.pow(10,9); //returning a very large value so that it is not considered in the
//                                        //min value
//        }
//
//        //do all possible tasks on the indices
//
//        int down=triangle[row][col]+f(triangle,n,row+1,col);
//        int diagonal=triangle[row][col]+f(triangle,n,row+1,col+1);
//
//        return Math.min(down,diagonal);
//    }

//    memoization
//    public static int minimumPathSum(int[][] triangle, int n) {
//        // Write your code here.
//        int dp[][]=new int[n][n]; //as the (n-1)th row has (n-1) columns
//        for(int[] x:dp){
//            Arrays.fill(x,-1);
//        }
//        return f(triangle,n,0,0,dp);
//    }
//
//    static int f(int[][] triangle,int n,int row,int col,int[][] dp){
//        //base case
//        if(row==n-1){ //destination
//            return triangle[n-1][col];
//        }
//        if(row>n-1 || col>triangle[row].length - 1){
//            return (int)Math.pow(10,9); //returning a ver large value so that it is not considered in the
//                                        //min value
//        }
//        if(dp[row][col]!=-1){
//            return dp[row][col];
//        }
//        //do all possible tasks on the indices
//
//        int down=triangle[row][col]+f(triangle,n,row+1,col,dp);
//        int diagonal=triangle[row][col]+f(triangle,n,row+1,col+1,dp);
//
//        return dp[row][col]=Math.min(down,diagonal);
//    }


    //tabulation
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int dp[][]=new int[n][n]; //as the (n-1)th row has (n-1) columns
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return f(triangle,n,dp);
    }

    static int f(int[][] triangle,int n,int[][] dp){
        for(int i=n-1;i>=0;i--){ //since we have moved from start to end in this problem
                                 //so, we have to start the for loop from the end
            for(int j=i;j>=0;j--){ //j will start from i (think logically)
                //base case
                if(i==n-1){ //destination
                    dp[i][j]=triangle[i][j];
                    continue;
                }
                int down=Integer.MAX_VALUE;
                int diagonal=Integer.MAX_VALUE;

                if(i<n-1){ //check if we can move down and diagonally
                    down=triangle[i][j]+dp[i+1][j];
                    diagonal=triangle[i][j]+dp[i+1][j+1];
                }
                dp[i][j]=Math.min(down,diagonal);
            }
        }

        return dp[0][0]; //the ans will be stored in the first index of dp
    }
}
