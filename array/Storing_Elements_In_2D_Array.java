package array;

public class Storing_Elements_In_2D_Array {

    //STORING ELEMENTS INSIDE A 2-D ARRAY
    public static void main(String[] args) {

        //marks.length=5 and marks[i].length=2
        int[][] marks = new int[5][2];
        for (int i = 0; i <= marks.length - 1; i++) { //For level 1 array
            for (int j = 0; j <= marks[i].length - 1; j++) { //For level 2 array
                marks[i][j] = i + j;
            }
        }

        //To print the Array
        for (int i = 0; i <= marks.length - 1; i++) { //For level 1 array
            for (int j = 0; j <= marks[i].length - 1; j++) { //For level 2 array
                                                             //for i=0, j=0,1
                                                             //for i=1, j=0,1
                                                             //for i=2, j=0,1
                                                             //for i=3, j=0,1
                                                             //for i=4, j=0,1
                System.out.print(marks[i][j]);
                if(j<marks[j].length-1){
                    System.out.print(",");
                }
            }
            if(i<marks.length-1){
                System.out.print(",");
            }
        }
    }
}
