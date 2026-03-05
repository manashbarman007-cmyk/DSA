package recursion_and_backtracking;

import java.util.Arrays;

public class The_Knight_Tour_Problem_GFG {
    public static void main(String[] args) {
        The_Knight_Tour_Problem_GFG obj=new The_Knight_Tour_Problem_GFG();
        obj.allSteps(5);
    }

    public void allSteps(int n){
        int[][] stepsMatrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                stepsMatrix[i][j] = -1;
            }
        }
        stepsMatrix[0][0] = 0; // as the (0,0) is the starting position,so it is the 0-th move
        int[] dx={2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy={1, 2, 2, 1, -1, -2, -2, -1};
        if(func(stepsMatrix,dx,dy,n,0,0,1)) { // the initial stepCount=1, as we have
                                                                 // already set 0 for (0,0) coordinate
           printMatrix(stepsMatrix, n);
        }else {
            System.out.println("-1");
        }

    }

    public boolean isSafe(int[][] solutionMatrix, int row, int col, int n){
        if (row < 0 || row >= n || col < 0 || col >= n || solutionMatrix[row][col] != -1){
            return false;  //ie we won't make the recursive call
        }
        return true; //when else condition is satisfied
    }

    public boolean func(int[][] stepsMatrix, int[] dx, int[] dy, int n, int row, int col, int stepsCount){
        //base case
        if(stepsCount == n * n){
            return true; //ie we get a solution
        }
        for(int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isSafe(stepsMatrix, nextRow, nextCol, n)) { //if isSafe is true
                stepsMatrix[nextRow][nextCol]=stepsCount;
                if (func(stepsMatrix, dx, dy, n, nextRow, nextCol, stepsCount + 1)) { //ie if we find the solution we
                                                                                  // end the recursion and return
                                                                                  //true to the caller method
                    return true; // if the solution is obtained then we return 'true' to all the previous calls
                }else { // if we can't find the solution we backtrack
                    stepsMatrix[nextRow][nextCol] = -1; // for backtracking, we reset it as -1
                }
            }
        }
        return false; //if a move is not possible
    }

    public void printMatrix(int[][] mat, int n){
        for(int i = 0;i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
