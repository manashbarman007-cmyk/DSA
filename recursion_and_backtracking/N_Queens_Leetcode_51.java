package recursion_and_backtracking;
import java.util.*;

public class N_Queens_Leetcode_51 {
    public static void main(String[] args) {
        N_Queens_Leetcode_51 obj=new N_Queens_Leetcode_51();
        System.out.println(obj.solveNQueens(4));
        System.out.println(obj.solveNQueens(1));

    }
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> list=new ArrayList<>();
       char[][] board=new char[n][n];
       for(int i=0;i<n;i++){
           for (int j=0;j<n;j++){
               board[i][j]='.';
           }
       }
       func(0,n,list,board);
       return list;
    }

    static void func(int col,int n,List<List<String>> list,char[][] board){
        // base case
        if(col==n){ // we have done for all possible columns
            list.add(construc(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){ //we will place the queens
               board[row][col]='Q';
               func(col+1,n,list,board); //recursive call
               board[row][col]='.'; //for proper backtracking
            }
        }

    }

    static boolean isSafe(int row,int col,char[][] board,int n){
        int copyRow1=row,copyRow2=row,copyCol1=col,copyCol2=col;

        //check diagonally back and up
        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }

        //check straight back
        while (copyCol1>=0){
            if (board[copyRow1][copyCol1]=='Q'){
                 return false;
            }
            copyCol1--;
        }

        //check diagonally back and down
        while (copyRow2<n && copyCol2>=0){
            if (board[copyRow2][copyCol2]=='Q'){
                 return false;
            }
            copyRow2++;
            copyCol2--;
        }
        return true; //else
    }

    static List<String> construc(char[][] board){
        List<String> sublist=new ArrayList<>();
        for (int i=0;i< board.length;i++){
            String s=new String(board[i]);
            sublist.add(s);
        }
        return sublist;
    }
}
