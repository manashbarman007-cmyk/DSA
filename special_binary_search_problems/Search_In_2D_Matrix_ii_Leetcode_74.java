package special_binary_search_problems;

public class Search_In_2D_Matrix_ii_Leetcode_74 {
    public static void main(String[] args) {
        Search_In_2D_Matrix_Leetcode_74 obj = new Search_In_2D_Matrix_Leetcode_74();
        int[][] example = {{1, 4, 7, 11, 15},
                           {2, 5, 8, 12, 19},
                           {3, 6, 9, 16, 22},
                           {10, 13, 14, 17, 24}
        };
        System.out.println(searchMatrix(example,81));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c =col-1;
        while (r<row && c>-1){
            if(matrix[r][c]==target) return true;  //we start search from the top right element
            else if(target<matrix[r][c]) c=c-1; // move left ie in the previous column

            else r=r+1; //if target>matrix[r][c] we move bottom ie in the next row

        }
        //return false if element is not found
        return false;
    }
}