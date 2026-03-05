package special_binary_search_problems;

public class Search_In_2D_Matrix_Leetcode_74 {
    public static void main(String[] args) {
        int[][] example1={{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}
                         };
        Search_In_2D_Matrix_Leetcode_74 obj=new Search_In_2D_Matrix_Leetcode_74();
        System.out.println(obj.searchMatrix(example1,60));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r= matrix.length,c=matrix[0].length; //r:no. of rows, c:no. of columns
        int start=0,end=r*c-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(matrix[mid/c][mid%c]==target){
                return true;
            }
            else if (target<matrix[mid/c][mid%c]) end=mid-1; //move left
            else start=mid+1; //move right if target>mid
            }
       // will return false if the target does not exist
        return false;
        }
    }
