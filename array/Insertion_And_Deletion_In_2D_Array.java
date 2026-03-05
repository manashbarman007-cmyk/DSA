package array;

import java.util.Scanner;

public class Insertion_And_Deletion_In_2D_Array {
    public static void main(String[] args) {
        int[][] marks = new int[3][4];
        takeInput(marks);
//        insertElement(marks,0,0,24);
        System.out.println("Original Array:");
        print2dArray(marks);
        deleteElement(marks,0,1);
        System.out.println("After deletion:");
        print2dArray(marks);
    }

    //taking user input
    static void takeInput(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr[i].length-1; j++) {
                System.out.println("Insert " + j + " element: ");
                arr[i][j]=sc.nextInt();
            }
        }
    }

    //printing the array
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

    //Inserting elements in 2D Array
    static void insertElement(int[][] arr,int pos1,int pos2,int element){
        if(pos2>=0 && pos2<=arr[pos1].length-1 && pos1 >= 0 && pos1 <= arr.length-1){
            for(int j=arr[pos1].length-2;j>=pos2;j--){  //pos1 is fixed
                arr[pos1][j+1]=arr[pos1][j];
            }
            arr[pos1][pos2]= element;
        }
        else {
            System.out.println("Array index is out of bound");
        }

    }

    //Deleting elements in 2D Array
    static void deleteElement(int[][] arr,int pos1,int pos2){
        int size2=arr[pos1].length;
        if(pos2>=0 && pos2<=arr[pos1].length-1 && pos1 >= 0 && pos1 <= arr.length-1){
            for(int j=pos2;j<=size2-2;j++){  //pos1 is fixed
                arr[pos1][j]=arr[pos1][j+1];
            }
            arr[pos1][size2-1]= 0;
        }
        else {
            System.out.println("Array index is out of bound");
        }

    }
}
