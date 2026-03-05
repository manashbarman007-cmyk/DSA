package dynamic_programming;

import java.util.Arrays;

public class Chocolate_Pickup_CN {
    public static void main(String[] args) {
        int[][] ex={{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        System.out.println(maximumChocolates(3,3,ex));

    }

    //recursion
//    public static int maximumChocolates(int r, int c, int[][] grid) {
//        // Write your code here.
//        int[] dx_AB={1,1,1,1,1,1,1,1,1};
//        int[] dy_A={0,0,0,-1,-1,-1,1,1,1};
//        int[] dy_B={0,-1,1,0,-1,1,0,-1,1};
//        return f(r,c,grid,0,0,c-1,dx_AB,dy_A,dy_B);
//
//    }
//
//    static int f(int r,int c,int[][] grid,int row_AB,int col_A,int col_B,int[] dx_AB,int[] dy_A,int[] dy_B) {
//        //base case
//        if (col_A < 0 || col_A > c - 1 || col_B < 0 || col_B > c - 1) { //out of index bound
//            return -10000000;
//        }
//        if (col_A >= 0 || col_A < c || col_B >= 0 || col_B < c) {
//            if (row_AB == r - 1) {//Alice and Bob have reached destination
//
//                if (col_A != col_B) { //Both are at different cols
//                    return grid[r - 1][col_A] + grid[r - 1][col_B];
//                } else { //both are at same cols
//                    return grid[r - 1][col_A]; //if col_A == col_B
//                }
//
//            }
//        }
//        int max_AB=Integer.MIN_VALUE;
//           for (int i = 0; i < 9; i++) {
//               int path_AB;
//               if(col_A == col_B){
//               path_AB = grid[row_AB][col_A] + f(r, c, grid, row_AB + dx_AB[i], col_A + dy_A[i], col_B + dy_B[i], dx_AB, dy_A, dy_B);
//               max_AB =Math.max(max_AB,path_AB);
//           }
//               else { //if col_A != col_B
//                 //for Alice and Bob
//                   path_AB = grid[row_AB][col_A] + grid[row_AB][col_B] + f(r, c, grid, row_AB + dx_AB[i], col_A + dy_A[i], col_B + dy_B[i], dx_AB, dy_A, dy_B);
//                   max_AB=Math.max(max_AB,path_AB);
//               }
//       }
//        return max_AB;
//    }


    //memoization
//    public static int maximumChocolates(int r, int c, int[][] grid) {
//        // Write your code here.
//        int[] dx_AB={1,1,1,1,1,1,1,1,1};
//        int[] dy_A={0,0,0,-1,-1,-1,1,1,1};
//        int[] dy_B={0,-1,1,0,-1,1,0,-1,1};
//        int[][][] dp =new int[r][c][c]; //3D dp
//        for(int[][] x:dp){
//            for (int[] y:x){
//                Arrays.fill(y,-1);
//            }
//        }
//        return f(r,c,grid,dp,0,0,c-1,dx_AB,dy_A,dy_B);
//
//    }
//
//    static int f(int r,int c,int[][] grid,int[][][] dp,int row_AB,int col_A,int col_B,int[] dx_AB,int[] dy_A,int[] dy_B) {
//        //base case
//        if (col_A < 0 || col_A > c - 1 || col_B < 0 || col_B > c - 1) { //out of index bound
//            return -10000000;
//        }
//        if (col_A >= 0 || col_A < c || col_B >= 0 || col_B < c) {
//            if (row_AB == r - 1) {//Alice and Bob have reached destination
//
//                if (col_A != col_B) { //Both are at different cols
//                    return grid[r - 1][col_A] + grid[r - 1][col_B];
//                } else { //both are at same cols
//                    return grid[r - 1][col_A]; //if col_A == col_B
//                }
//
//            }
//        }
//        if(dp[row_AB][col_A][col_B] != -1){
//            return dp[row_AB][col_A][col_B];
//        }
//        int max_AB=Integer.MIN_VALUE;
//           for (int i = 0; i < 9; i++) {
//               int path_AB;
//               if(col_A == col_B){
//               path_AB = grid[row_AB][col_A] + f(r, c, grid,dp, row_AB + dx_AB[i], col_A + dy_A[i], col_B + dy_B[i], dx_AB, dy_A, dy_B);
//               max_AB =Math.max(max_AB,path_AB);
//           }
//               else { //if col_A != col_B
//                 //for Alice and Bob
//                   path_AB = grid[row_AB][col_A] + grid[row_AB][col_B] + f(r, c, grid,dp, row_AB + dx_AB[i], col_A + dy_A[i], col_B + dy_B[i], dx_AB, dy_A, dy_B);
//                   max_AB=Math.max(max_AB,path_AB);
//               }
//       }
//        return dp[row_AB][col_A][col_B]=max_AB;
//    }


    //tabulation
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int[] dx_AB={1,1,1,1,1,1,1,1,1};
        int[] dy_A={0,0,0,-1,-1,-1,1,1,1};
        int[] dy_B={0,-1,1,0,-1,1,0,-1,1};
        int[][][] dp =new int[r][c][c]; //3D dp
        for(int[][] x:dp){
            for (int[] y:x){
                Arrays.fill(y,-1);
            }
        }
        return f(r,c,grid,dp,dx_AB,dy_A,dy_B);

    }

    static int f(int r,int c,int[][] grid,int[][][] dp,int[] dx_AB,int[] dy_A,int[] dy_B) {
        
        for(int row_AB=r-1;row_AB>=0;row_AB--){
            for (int col_A=c-1;col_A>=0;col_A--){
                for (int col_B=0;col_B<c;col_B++){

                    //base case
                        if (row_AB == r - 1) {//Alice and Bob have reached destination

                            if (col_A != col_B) { //Both are at different cols
                                dp[r-1][col_A][col_B] = grid[r - 1][col_A] + grid[r - 1][col_B];
                                continue;
                            } else { //both are at same cols
                                dp[r-1][col_A][col_B] = grid[r - 1][col_A]; //if col_A == col_B
                                continue;
                            }
                        }

                    int max_AB=Integer.MIN_VALUE;

                    for (int i = 0; i < 9; i++) {
                        int path_AB;
                            if (col_A == col_B) {
                                //for Alice and Bob
                                path_AB = grid[row_AB][col_A];

                            } else { //if col_A != col_B
                                //for Alice and Bob
                                path_AB = grid[row_AB][col_A] + grid[row_AB][col_B];
                            }
                            if((row_AB + dx_AB[i] >=r) || (col_A + dy_A[i] >= c) || (col_B + dy_B[i] >= c) || (col_A + dy_A[i] < 0) || (col_B + dy_B[i] < 0)){
                                //These are invalid states
                                path_AB += -1000000000; //take a very small value so that it is not considered in max

                            }else {
                                path_AB +=  dp[row_AB + dx_AB[i]][col_A + dy_A[i]][col_B + dy_B[i]];
                            }
                        max_AB=Math.max(max_AB,path_AB);
                    }
                    dp[row_AB][col_A][col_B]=max_AB;
                }
            }
        }
        return dp[0][0][c-1];
    }
}
