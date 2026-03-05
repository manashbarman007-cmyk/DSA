package array;

public class Array_Deletion {
    public static void main(String[] args) {
        int[] marks={20,30,50,77,99,67,80};
        printArray(marks);
        deleteArrayElement(marks,2);

    }
    static void printArray(int[] arr){
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //we write the program to delete the i-th index element
    static void deleteArrayElement(int[] arr, int pos){
        if(pos>=0 && pos<= arr.length-1){
            for(int i=pos; i<=arr.length-2;i++){
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=0;  //To make the last element of the array to be 0
        }
        else {
            System.out.println("Array index out of bound");
        }
        for (int i: arr){
            System.out.print(i+" ");
        }
    }
}
