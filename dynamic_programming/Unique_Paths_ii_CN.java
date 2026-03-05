package dynamic_programming;
import java.lang.reflect.Array;
import java.util.*;

public class Unique_Paths_ii_CN {
    public static void main(String[] args) {
        ArrayList<Integer> subList1=new ArrayList<>();
        subList1.add(0);
        subList1.add(-1);
        ArrayList<Integer> subList2=new ArrayList<>();
        subList2.add(-1);
        subList2.add(0);

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(subList1);
        list.add(subList2);

        System.out.println(mazeObstacles(2,2,list));

    }

    //recurion
//    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//        // Write your code here.
//        if(mat.get(n-1).get(m-1)==-1){  //if the bottom right cell is blocked
//            return 0;
//        }
//        return f(n-1,m-1,mat);
//    }
//
//    static int f(int n,int m,ArrayList<ArrayList<Integer>> mat){
//        //base case
//        int mod = 1000000007;
//        if(n==0 && m==0){  //ie we have reached the destination
//            return 1;
//        }
//        if(n>=0 && m>=0 && mat.get(n).get(m)==-1){
//            return 0; //as it is not a valid path (since it has an obstacle) and thus we won't count it
//        }
//        if(n<0 || m<0){
//            return 0;
//        }
//          int moveLeft=f(n,m-1,mat);
//          int moveUp=f(n-1,m,mat);
//          return (moveLeft+moveUp) % mod;
//    }


    //memoization
//    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//        // Write your code here.
//        if(mat.get(n-1).get(m-1)==-1){  //if the bottom right cell is blocked
//            return 0;
//        }
//        int[][] dp=new int[n][m];
//        for(int i=0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return f(n-1,m-1,mat,dp);
//    }
//
//    static int f(int n,int m,ArrayList<ArrayList<Integer>> mat,int[][] dp){
//        //base case
//        int mod = 1000000007;
//        if(n==0 && m==0){  //ie we have reached the destination
//            return 1;
//        }
//        if(n>=0 && m>=0 && mat.get(n).get(m)==-1){
//            return 0; //as it is not a valid path (since it has an obstacle) and thus we won't count it
//        }
//        if(n<0 || m<0){
//            return 0;  //not valid
//        }
//        if(dp[n][m]!=-1){
//            return dp[n][m];
//        }
//          int moveLeft=f(n,m-1,mat,dp);
//          int moveUp=f(n-1,m,mat,dp);
//
//          return dp[n][m]=(moveLeft+moveUp) % mod;
//    }


    //tabulation
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        if(mat.get(n-1).get(m-1)==-1){  //if the bottom right cell is blocked
            return 0;
        }
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n,m,mat,dp);
    }

    static int f(int n,int m,ArrayList<ArrayList<Integer>> mat,int[][] dp){
        //base cases']]

        int mod = 1000000007;
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1; //base case, ie we have reached the destination
                    continue; //we skip further and move to the next iteration in j
                }
                if(i>=0 && j>=0 && mat.get(i).get(j)==-1){
                    dp[i][j]=0; //as it is not a valid path (since it has an obstacle) and thus we won't count it
                    continue; //we skip further and move to the ned=xt iteration
                }
                int moveUp=0;
                int moveLeft=0;
                if(i>0) { //check if moving up is possible
                   moveUp = dp[i - 1][j];
                }
                if(j>0){ //check if moving left is possible
                    moveLeft = dp[i][j - 1];
                }
                dp[i][j]=(moveLeft+moveUp) % mod;
            }
        }
        return dp[n-1][m-1]; //result is stored in the last element of the dp
    }
}
