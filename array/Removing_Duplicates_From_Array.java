package array;

import java.util.*;

public class Removing_Duplicates_From_Array {
    public static void main(String[] args) {
        int[] ex1 = {1, 2, 2, 2, 3, 4, 4, 5}; //sorted
        int[] ex2 = {2, 2, 2, 2, 2, 2, 5,5}; //sorted
        System.out.println(removeDuplicate(ex1));
        System.out.println(removeDuplicate(ex2));
    }

    static List<Integer> removeDuplicate(int[] arr) {
        List<Integer> list=new ArrayList<>();
        if (arr[0] == arr[arr.length - 1]) { //edge case (if all the elements are duplicate)
            list.add(arr[0]);
        } else {
            int i = 0; //i: for original array
            while (i < arr.length) {
                if (i < arr.length - 1) {
                    if (arr[i] != arr[i + 1]) {
                        list.add(arr[i]);
                        i++;
                    } else {
                        i++; //skip the duplicate elements
                    }
                } else if (i == arr.length - 1) { //for i==arr.length-1;
                    list.add( arr[arr.length - 1]);
                    i++;
                }
            }
        }
        return list;
    }
}
