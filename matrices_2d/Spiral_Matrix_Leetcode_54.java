package matrices_2d;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_Leetcode_54 {
    public static void main(String[] args) {
        int[][] example1={{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        int[][] example2={{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12}};
        int[][] example3={{1,2},
                          {3,4}};
        Spiral_Matrix_Leetcode_54 obj=new Spiral_Matrix_Leetcode_54();
//        System.out.println(obj.spiralOrder(example1));
        System.out.println(obj.spiralOrder(example2));
//        System.out.println(obj.spiralOrder(example3));

    }
    public List<Integer> spiralOrder(int[][] matrix) { //ie we will return a list of int type
        List<Integer> res=new ArrayList<>(); //dynamic 1D array
         int m=matrix.length,n=matrix[0].length;
         int startRow=0,startCol=0,endRow=m-1,endCol=n-1; //we set 4 pointers
        while(startRow<=endRow && startCol<=endCol){
                // add start row
                for(int j=startCol;j<=endCol;j++) {
                    res.add(matrix[startRow][j]);
                }startRow+=1;
                //add end column
                for(int i=startRow;i<=endRow;i++){
                    res.add(matrix[i][endCol]);
                }endCol-=1;
                if(startRow<=endRow){
                    //add end row
                    for (int j=endCol;j>=startCol;j--){
                        res.add(matrix[endRow][j]);
                    }endRow-=1;
                }
                if(startCol<=endCol){
                    //add start column
                    for (int i=endRow;i>=startRow;i--){
                        res.add(matrix[i][startCol]);
                    }startCol+=1;
                }
        }
        return res;
    }

}
