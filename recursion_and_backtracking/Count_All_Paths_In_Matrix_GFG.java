package recursion_and_backtracking;

public class Count_All_Paths_In_Matrix_GFG {
    public static void main(String[] args) {
        Count_All_Paths_In_Matrix_GFG obj=new Count_All_Paths_In_Matrix_GFG();
        System.out.println(obj.numberOfPaths(3,3));
    }

    int numberOfPaths(int m, int n) {
        // code here

        //initially
        //to move right in matrix (row,col) -> (row,col+1)
        //to move down in the matrix (row,col) -> (row+1,col)

        // to move left in matrix (row,col) -> (row,col-1)
        //to move up in the matrix (row,col) -> (row-1,col)

        //base case (The simplest case of the function parameters)
        if(m==1 || n==1){
            return 1;
        }

       return numberOfPaths(m-1,n)+numberOfPaths(m,n-1);
    }
}
