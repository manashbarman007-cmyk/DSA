package matrices_2d;

public class Rotate_90_Degrees_Clockwise_Leetcode_48 {
    public static void main(String[] args) {
        int[][] ex1={{1,2,3},
                     {4,5,6},
                     {7,8,9}
                    };
        Rotate_90_Degrees_Clockwise_Leetcode_48 obj= new Rotate_90_Degrees_Clockwise_Leetcode_48();
        obj.rotate(ex1);
    }
    public void rotate(int[][] matrix) {
      int n=matrix.length; //here m=n

        //find the transpose of the matrix
        for(int i=0;i<n;i++){ //we swap the matrix elements if they are off-diagonals
            for(int j=i;j<n;j++){
                if(i!=j){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }

        //swap the columns
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }

      //print the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]);
                if(j<n-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
