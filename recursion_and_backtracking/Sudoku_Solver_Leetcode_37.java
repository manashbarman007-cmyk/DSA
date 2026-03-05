package recursion_and_backtracking;

public class Sudoku_Solver_Leetcode_37 {
    public static void main(String[] args) {
    char[][] ex1= {   {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                     {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                     {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                     {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                     {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                     {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                     {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                     {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                     {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
                 };
    Sudoku_Solver_Leetcode_37 obj=new Sudoku_Solver_Leetcode_37();
    obj.solveSudoku(ex1);
    for(char[] ch:ex1){
        for (char c:ch){
            System.out.print(c+" ");
        }
        System.out.println();
    }
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {    //we iterate through the board
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;

                            if (solve(board)) { //we call the method recursively and return true to all the
                                //previous recursive calls when a valid solution is obtained
                                return true;
                            } else {
                                board[i][j] = '.'; //backtrack if the config is not valid
                            }
                        }
                    }
                    return false; //if none of the characters can be placed
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            //to check if the same element exists in a row
            if (board[row][i] == ch) {
                return false;
            }

            //to check if the same element exists in a col
            if (board[i][col] == ch) {
                return false;
            }

            //to check if the same element exists in a 3*3 subgrid
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]==ch){
                return false;
            }

        }
        return true; //if the configuration is valid we return true
    }
}
