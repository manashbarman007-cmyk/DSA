package recursion_and_backtracking;
import java.util.*;

public class Rat_In_A_Maze_i_GFG {
    public static void main(String[] args) {
        int[][] ex1={{1,0,0,0},
                    {1,1,0,1},
                    {1,1,0,0},
                    {0,1,1,1}};
        Rat_In_A_Maze_i_GFG obj=new Rat_In_A_Maze_i_GFG();
        System.out.println(obj.ratInMaze(ex1));

    }
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n= maze.length; //number of rows
        int m= maze[0].length; //number of columns
        ArrayList<String> ans=new ArrayList<>();
        int[][] visited=new int[maze.length][maze[0].length];

        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                visited[i][j]=0;
            }
        }

        if(maze[0][0]==1) {
            solve(maze, visited, ans, "", 0, 0);
        }
        return ans;
    }
    static void solve(int[][] maze,int[][] visited,ArrayList<String> ans,String str,int row,int col){
        int n= maze.length; //number of rows
        int m= maze[0].length; //number of columns

        //base case
         if(row== n-1 && col==m-1){
             ans.add(str);
             return;
         }

         //down
        if (row + 1 < n && visited[row+1][col] == 0 && maze[row+1][col]==1) {
            visited[row][col]=1; //we mark the present cell as visited
            solve(maze,visited,ans,str+"D",row+1,col); //recursive call
            visited[row][col]=0; //we unmark it as visited while backtracking
        }
        //left
        if (col -1 >= 0 && visited[row][col-1] == 0 && maze[row][col-1]==1) {
            visited[row][col]=1; //we mark the present cell as visited
            solve(maze,visited,ans,str+"L",row,col-1); //recursive call
            visited[row][col]=0; //we unmark it as visited while backtracking
        }
        //right
        if (col + 1 < n && visited[row][col+1] == 0 && maze[row][col+1]==1) {
            visited[row][col]=1; //we mark the present cell as visited
            solve(maze,visited,ans,str+"R",row,col+1); //recursive call
            visited[row][col]=0; //we unmark it as visited while backtracking
        }
        //up
        if (row - 1 >= 0 && visited[row-1][col] == 0 && maze[row-1][col]==1) {
            visited[row][col]=1; //we mark the present cell as visited
            solve(maze,visited,ans,str+"U",row-1,col); //recursive call
            visited[row][col]=0; //we unmark it as visited while backtracking
        }
    }

}
