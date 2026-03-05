package matrices_2d;

public class Spiral_Matrix_ii_Leetcode_59 {
    public static void main(String[] args) {
        Spiral_Matrix_Leetcode_54 obj1=new Spiral_Matrix_Leetcode_54();
        int[][] newMatrix=generateMatrix(3);
        int n=newMatrix.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(newMatrix[i][j]);
                if(j<newMatrix[i].length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
    static int[][] generateMatrix(int n) { //returning a matrix
       int startRow=0,startCol=0,endRow=n-1,endCol=n-1;
       int val=1;
       int[][] matrix= new int[n][n]; //creating an n*n matrix
       while(startCol<=endCol && startRow<=endRow){
           //filling starting row
           for(int j=startCol;j<=endCol;j++){
               matrix[startRow][j]=val;
               val++;
           }startRow+=1;
           //filling ending column
           for(int i=startRow;i<=endRow;i++){
               matrix[i][endCol]=val;
               val++;
           }endCol-=1;
           if(startRow<=endRow){
               //filling ending row
               for(int j=endCol;j>=startCol;j--){
                   matrix[endRow][j]=val;
                   val++;
               }endRow-=1;
           }
           if(startCol<=endCol){
               //filling starting column
               for(int i=endRow;i>=startRow;i--){
                   matrix[i][startCol]=val;
                   val++;
               }startCol+=1;
           }
       }
       return matrix;
    }
}
