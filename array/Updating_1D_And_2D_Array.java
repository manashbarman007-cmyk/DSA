package array;

public class Updating_1D_And_2D_Array {
    public static void main(String[] args) {
        int[] marks1D = {55, 67, 54, 78, 34, 63, 57}; //creation of 1D Array
        int[][] marks2D = {{35, 67}, {67, 45}, {67, 90}};  //creation of 2D Array
        update1dArray(marks1D,3,100);
        print1DArray(marks1D);
        update2dArray(marks2D,1,1,100);
        print2dArray(marks2D);

    }

    //updating an 1D Array
    static void update1dArray(int[] arr, int pos, int element) {
        if (pos >= 0 && pos <= arr.length-1) {
            arr[pos] = element;
        }
        else {
            System.out.println("Array index out of bound");
        }
    }

    //updating a 2D Array
    static void update2dArray(int[][] arr, int pos1, int pos2, int element) {

        if (pos2 >= 0 && pos2 <= arr[pos1].length-1 && pos1 >= 0 && pos1 <= arr.length-1) {
            arr[pos1][pos2] = element;
        }
       else {
            System.out.println("Array index out of bound");
        }
    }

    //printing 1D Array
    static void print1DArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {    //This is array traversal
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    //printing 2D Array
    static void print2dArray(int[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {//For level 1 array
            for (int j = 0; j <= arr[i].length - 1; j++) { //For level 2 array
                System.out.print(arr[i][j]);
                if(j<arr[i].length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
