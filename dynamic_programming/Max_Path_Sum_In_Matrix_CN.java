package dynamic_programming;

import java.util.Arrays;

public class Max_Path_Sum_In_Matrix_CN {
    public static void main(String[] args) {
       int[][] ex1={{1,2,10,4},
                    {100,3,2,1},
                    {1,1,20,2},
                    {1,2,2,1}};
        System.out.println(getMaxPathSum(ex1));
    }

    //recursion
//    public static int getMaxPathSum(int[][] matrix) {
//        // Write your code here
//        int n=matrix.length, m=matrix[0].length;
//        int max= Integer.MIN_VALUE;
//        for(int i=0;i<m;i++){
//            max=Math.max(max,f(matrix,0,i,n,m)); //as we don't know from which col we will start
//        }
//        return max;
//    }
//
//    static int f(int[][] matrix,int row,int col,int n,int m){
//        //base case
//        if(col>=0 && row<n && col<m) {
//            if (row == n - 1) { //destination (we don't know the ending col)
//                return matrix[n - 1][col];
//            }
//        }
//        if(row>n-1 || col>m-1 || col<0){ //out of index bound
//            return -1000000; // return a small value so that it is not considered in the max
//        }
//
//        //do all possible tasks on the indices
//        int down=matrix[row][col]+f(matrix,row+1,col,n,m);
//        int botLeftDia=matrix[row][col]+f(matrix,row+1,col-1,n,m);
//        int botRightDia=matrix[row][col]+f(matrix,row+1,col+1,n,m);
//
//        return Math.max(down,Math.max(botLeftDia,botRightDia));
//    }


    //memoization
//    public static int getMaxPathSum(int[][] matrix) {
//        // Write your code here
//        int n=matrix.length, m=matrix[0].length;
//        int[][] dp=new int[n][m];
//        for (int[] x:dp){
//            Arrays.fill(x,-1);
//        }
//        int max= Integer.MIN_VALUE;
//        for(int i=0;i<m;i++){
//            max=Math.max(max,f(matrix,0,i,n,m,dp)); //as we don't know from which col we will start
//        }
//        return max;
//    }
//
//    static int f(int[][] matrix,int row,int col,int n,int m,int[][] dp){
//        //base case
//        if(col>=0 && row<n && col<m) {
//            if (row == n - 1) { //destination (we don't know the ending col)
//                return matrix[n - 1][col];
//            }
//        }
//        if(row>n-1 || col>m-1 || col<0){ //out of index bound
//            return -1000000; // return a small value so that it is not considered in the max
//        }
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//
//        //do all possible tasks on the indices
//        int down=matrix[row][col]+f(matrix,row+1,col,n,m,dp);
//        int botLeftDia=matrix[row][col]+f(matrix,row+1,col-1,n,m,dp);
//        int botRightDia=matrix[row][col]+f(matrix,row+1,col+1,n,m,dp);
//
//        return dp[row][col] = Math.max(down,Math.max(botLeftDia,botRightDia));
//    }

    //tabulation
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int n=matrix.length, m=matrix[0].length;
        int[][] dp=new int[n][m];
        for (int[] x:dp){
            Arrays.fill(x,-1);
        }

        return f(matrix,n,m,dp);
    }

    static int f(int[][] matrix,int n,int m,int[][] dp){

        for(int i=n-1;i>=0;i--){
            for (int j=m-1;j>=0;j--){

                //base case
                if(j>=0 && i<n && j<m){
                    if(i==n-1){
                        dp[i][j] = matrix[i][j]; //where i=n-1
                        continue;
                    }
                }
                int down=Integer.MIN_VALUE;
                int botLeftDia=Integer.MIN_VALUE;
                int botRightDia=Integer.MIN_VALUE;

                if(i<n-1) { //check if we can go down
                    down = matrix[i][j] + dp[i + 1][j];
                }
                if(i<n-1 && j>0) { //check if we can go botLeftDia
                    botLeftDia = matrix[i][j] + dp[i + 1][j - 1];
                }
                if(i<n-1 && j<m-1) { //check if we can go botRightDia
                    botRightDia = matrix[i][j] + dp[i + 1][j + 1];
                }
                dp[i][j]=Math.max(down,Math.max(botLeftDia,botRightDia));
            }
        }

        int max= Integer.MIN_VALUE;
        for(int i=m-1;i>=0;i--){
            max=Math.max(max,dp[0][i]); //as we don't know from which col we will start
        }
        return max;
    }
}
