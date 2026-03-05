package array;

import java.util.Scanner;

public class Array_Insertion {

    public static void main(String[] args) {
        int[] rollnum= new int[5];  // delcaration + memory allocation

        //taking user input
        for(int i=0;i< 3;i++){   //This is array traversal
            int element;
            System.out.print("Enter "+i+" element: ");
            Scanner sc=new Scanner(System.in);
            element= sc.nextInt();
            rollnum[i]= element;
        }

   printArray(rollnum);
   insertElement(rollnum,0,13);

    }

    //To print array
    static void printArray(int[] arr){

        //printing the array
        for(int i=0;i< arr.length;i++ ){    //This is array traversal
            System.out.print(arr[i]);
            if(i<arr.length-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    //To insert element in array
    static void insertElement(int[] arr, int pos, int element ) {

        if (pos >= 0 && pos <= arr.length) {
            for (int i = arr.length - 2; i >= pos; i--) {
                arr[i + 1] = arr[i]; // we shift the array elements one position towards end
            }
            arr[pos] = element;

        } else {
            System.out.println("Array index is out of bound");
            return;  //we will exit the loop
        }
        //printing the array
        for (int i = 0; i < arr.length; i++) {    //This is array traversal
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
    }
}
