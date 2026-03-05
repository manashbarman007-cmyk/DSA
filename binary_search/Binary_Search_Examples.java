package binary_search;

import javax.swing.*;

public class Binary_Search_Examples {
    public static void main(String[] args) {
        int[] marks = {35, 58, 60, 76, 77, 79, 87}; //ascending sorted array
        int[] marks1 = {87, 79, 77, 76, 60, 58, 35};
//        System.out.println("The element is at the index: " + toFindElementAscending(marks, 76));
//        System.out.println("The element is at the index: " + toFindElementDescending(marks1, 60));
        toFindElementAgnostic(marks,73); //for ascending order sorting
        toFindElementAgnostic(marks1,79); //for descending order sorting
    }

    //to find element in the ascending sorted array using binary search;
    static int toFindElementAscending(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //the loop stops when start>end
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid; //we exit the method returning this value
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        //-1 will be returned if element does not exist inside array
        return -1;
    }

    //to find element in the descending sorted array using binary search;
    static int toFindElementDescending(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //return -1 if element is not present in array
        return -1;
    }

    //Order agnostic binary search
    static void toFindElementAgnostic(int[] arr, int target) {
        int index = -1,size= arr.length-1;
            if (arr[size] >= arr[0]) {     //ascending order sorting
                int start = 0;
                int end = arr.length-1;

                //the loop stops when start>end
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (arr[mid] == target) {
                        index = mid;
                        break;  // we exit the loop
                    } else if (arr[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                if (index == -1) {
                    System.out.println(target + " does not lie in the array");
                } else {
                    System.out.println("The " + target + " is at the index: " + index);
                }
            }
            else {         //descending order sorting
                int start = 0;
                int end = arr.length - 1;

                //the loop stops when start>end
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (arr[mid] == target) {
                        index = mid;
                        break;  // we exit the loop
                    } else if (arr[mid] < target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }

                }
                if (index == -1) {
                    System.out.println(target + " does not lie in the array");
                } else {
                    System.out.println("The " + target + " is at the index: " + index);
                }

            }

        }


    }
