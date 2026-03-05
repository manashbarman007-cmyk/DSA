package array;

import java.util.Scanner;

public class Taking_User_Input {
    public static void main(String[] args) {
        int[] rollnum= new int[5];  // delcaration + memory allocation

        //taking user input
        for(int i=0;i< rollnum.length;i++){   //This is array traversal
            int element;
            System.out.print("Enter "+i+" element: ");
            Scanner sc=new Scanner(System.in);
            element= sc.nextInt();
            rollnum[i]= element;
        }

        //printing the array
        for(int x: rollnum ){    //This is array traversal
            System.out.print(x+" ");
        }
    }
}
