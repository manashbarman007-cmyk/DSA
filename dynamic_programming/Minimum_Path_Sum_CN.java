package dynamic_programming;

import java.util.Arrays;

public class Minimum_Path_Sum_CN {
    public static void main(String[] args) {
     int[][] ex1={{5,9,6},
                 {11,5,2}};
        System.out.println(minSumPath(ex1));
    }

    //recursive
//    public static int minSumPath(int[][] grid) {
//        // Write your code here.
//        int n= grid.length;
//        int m=grid[0].length;
//        return f(n-1,m-1,grid);
//    }
//    static int f(int row,int col,int[][] grid){
//        //base case
//        if(row==0 && col == 0){ //at destination
//            return grid[0][0];
//        }
//        if(row<0 || col<0){ //since out of index bound
//            return (int)Math.pow(10,9); //return such a huge number that it never gets considered in the min value
//        }
//
//        //do all the possible tasks on the indices
//        int left=grid[row][col]+f(row,col-1,grid);
//        int up=grid[row][col]+f(row-1,col,grid);
//
//        return Math.min(left,up);
//    }


    //memoization
//    public static int minSumPath(int[][] grid) {
//        // Write your code here.
//        int n= grid.length;
//        int m=grid[0].length;
//        int[][] dp=new int[n][m];
//        for (int[] i:dp){
//            Arrays.fill(i,-1);
//        }
//
//        return f(n-1,m-1,grid,dp);
//    }
//    static int f(int row,int col,int[][] grid,int[][] dp){
//        //base case
//        if(row==0 && col == 0){ //at destination
//            return grid[0][0];
//        }
//        if(row<0 || col<0){ //since out of index bound
//            return (int)Math.pow(10,9);
//        }
//        if(dp[row][col]!=-1){
//            return dp[row][col];
//        }
//
//        //do all the possible tasks on the indices
//        int left=grid[row][col]+f(row,col-1,grid,dp);
//        int up=grid[row][col]+f(row-1,col,grid,dp);
//
//        return dp[row][col]=Math.min(left,up);
//    }


    //tabulation
    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int n= grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for (int[] i:dp){
            Arrays.fill(i,-1);
        }

        return f(n-1,m-1,grid,dp);
    }
    static int f(int row,int col,int[][] grid,int[][] dp){

        for(int i=0;i<=row;i++){
            for (int j=0;j<=col;j++){

                //base case
                if(i==0 && j==0){ //destination
                    dp[i][j]=grid[i][j];
                    continue;
                }

                int left=Integer.MAX_VALUE;
                int up=Integer.MAX_VALUE;

                if(j>0){ //if we can move left
                    left=grid[i][j]+dp[i][j-1];
                }
                if(i>0){ //if we can move up
                    up=grid[i][j]+dp[i-1][j];
                }
                dp[i][j]=Math.min(left,up);
            }
        }
        return dp[dp.length-1][dp[0].length-1]; //the ans is stored in the last element of dp
    }
}
