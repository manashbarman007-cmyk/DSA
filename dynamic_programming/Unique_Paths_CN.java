package dynamic_programming;

import java.util.Arrays;

public class Unique_Paths_CN {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
        System.out.println(uniquePaths(2,2));
    }

//    //using recursion
//    public static int uniquePaths(int m, int n) {
//        // Write your code here.
//        return f(m-1,n-1);
//    }
//
//    static int f(int row,int col){
//        //base case
//        if(row==0 && col==0){ //we have reached the destination
//            return 1;  //if conditions are satisfied
//        }
//        if(row<0 || col<0){
//            return 0;  //we won't count this path as it is not valid
//        }
//
//        //do all possible stuffs on the index
//        int moveUp=f(row-1,col);
//        int moveLeft=f(row,col-1);
//
//        //to count the all possible ways simply add and return the all possible stuffs
//        return moveLeft+moveUp;
//    }


    //memoization
//    public static int uniquePaths(int m, int n) {
//        // Write your code here.
//        int[][] dp=new int[m][n];
//        for (int i=0;i<dp.length;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return f(m-1,n-1,dp);
//    }
//
//    static int f(int row,int col,int[][] dp){
//        //base case
//        if(row==0 && col==0){ //we have reached the destination
//            return 1;  //if conditions are satisfied
//        }
//          if(row<0 || col<0){
//              return 0;
//        }
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//        //do all possible stuffs on the indices
//        int moveUp=f(row-1,col,dp);
//        int moveLeft=f(row,col-1,dp);
//
//        //to count the all possible ways simply add and return the all possible stuffs
//        return dp[row][col]=moveLeft+moveUp; //if the subproblem has not been calculated before, we calculate it now,
//                                             //store it for further use and then return it
//    }

    //tabulation
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp=new int[m][n];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(m-1,n-1,dp);
    }

    static int f(int row,int col,int[][] dp){
        //base case
        for(int i=0;i<=row;i++){ //expressing all the states in for loop
            for (int j=0;j<=col;j++){
                if(i==0 && j==0){ // ie if we are at the 0th row or 0th col

                    dp[i][j]=1; //this is the base case
                    continue;  //we will skip the iteration in j and move forward to the next iteration in j

                }
                //do all possible stuffs on the indices
                int moveUp=0;
                int moveLeft=0;
               if(i>0){
                   moveUp=dp[i-1][j];
               }
               if(j>0){
                   moveLeft=dp[i][j-1];
               }
             dp[i][j]=moveUp+moveLeft;
            }
        }

        return dp[row][col]; // the answer is stored in the last element of dp
    }
}
