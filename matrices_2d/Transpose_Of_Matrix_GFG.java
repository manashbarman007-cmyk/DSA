package matrices_2d;

public class Transpose_Of_Matrix_GFG {
    public static void main(String[] args) {
        int[][] ex1={{1,1,1,1},
                    {2,2,2,2},
                    {3,3,3,3},
                    {4,4,4,4}
        };
        int[][] ex2={{1,2,3},
                    {4,5,6},
                    {7,8,9}
        };
        int[][] ex3={{1,2,3,4,5},
                    {6,7,8,9,10},
                    {11,12,13,14,15},
                    {16,17,18,19,20},
                    {21,22,23,24,25}
        };


        Transpose_Of_Matrix_GFG obj=new Transpose_Of_Matrix_GFG();
        obj.transpose(4,ex1);
//        obj.transpose(3,ex2);
//        obj.transpose(5,ex3);
    }
    public void transpose(int n, int mat[][]) {
      //n is the order of the square matrix
        for(int i=0;i<n;i++){ //we swap the matrix elements if they are off-diagonals
            for(int j=i;j<n;j++){
                if(i!=j){
                    int temp=mat[i][j];
                    mat[i][j]=mat[j][i];
                    mat[j][i]=temp;
                }
            }
        }
        //we print the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]);
                if(j<n-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
