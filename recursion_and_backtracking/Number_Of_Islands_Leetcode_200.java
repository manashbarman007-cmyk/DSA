package recursion_and_backtracking;

public class Number_Of_Islands_Leetcode_200 {
    public static void main(String[] args) {
        Number_Of_Islands_Leetcode_200 obj=new Number_Of_Islands_Leetcode_200();
        char[][] ex1={{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        char[][] ex2={{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(obj.numIslands(ex1));
        System.out.println(obj.numIslands(ex2));

    }
    public int numIslands(char[][] grid) {
       int n=grid.length,m=grid[0].length;
       int counter=0;
       int[] dx={-1,1,0,0};
       int[] dy={0,0,-1,1};
       for(int i=0;i<n;i++){
           for (int j=0;j<m;j++){
               if(grid[i][j]=='1'){
                   func(grid,dx,dy,i,j);
                   counter++;
               }
           }
       }
       return counter;
    }

    static void func(char[][] grid,int[] dx,int[] dy,int row,int col){
        int n=grid.length,m=grid[0].length;
        //base case (dead ends)
        if(row<0 || col<0 || row>n-1 || col>m-1 || grid[row][col]=='0' || grid[row][col]=='2' ){
          return; //returns the flow of program to the caller method
        }
        grid[row][col]='2'; //ie we mark them as visited

        //call optimization
        for (int ind=0;ind<4;ind++){
            func(grid,dx,dy,row+dx[ind],col+dy[ind]);
        }
//        //up
//        func(grid,row-1,col);
//        //down
//        func(grid,row+1,col);
//        //left
//        func(grid,row,col-1);
//        //right
//        func(grid,row,col+1);
    }
}
