package linear_search;

public class Linear_Search_Examples_In_1D_Array {
    public static void main(String[] args) {
        int[] marks = {75, 55, 86, 35, 78, 55, 32, 33, 33, 45, 55, 91, 55,91}; //Unsorted array
//         toSearchFirstOccurrence(marks,55);
//         toSearchLastOccurrence(marks,55,true);
        toSearchMultipleOccurrences(marks, 91);

    }

    //Linear search for first occurrence in array
    static void toSearchFirstOccurrence(int[] arr, int target) {
        int res = -1;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == target) {
                res = i;
                break;
            }
        }
        if (res == -1) {
            System.out.println("Element is not present in the array");
        } else {
            System.out.println("The element " + target + " first occurs at index: " + res);
        }
    }


    //Linear search for last occurrence in array
    static void toSearchLastOccurrence(int[] arr, int target, boolean findLastIndex) {
        int res = -1;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == target) {
                res = i;
                if (findLastIndex == false) {  //**If findLastIndex==true, then the loop will continue to run
                    // and 'res' will override the last index occurrence of target
                    break;
                }
            }
        }
        if (res == -1) {
            System.out.println("Element is not present in the array");
        } else {
            System.out.println("The element " + target + " last occurs at index: " + res);
        }
    }

    // Linear search for multiple occurrences in array
    static void toSearchMultipleOccurrences(int[] arr, int target) {

        int[] arr1 = new int[arr.length]; // must be of same size as our original array,
                                          // as all the elements in array can be duplicate
        int k = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == target) {
                arr1[k] = i;
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Element is not present in array");
        }
        // code to print the arr1[]
        else {
            System.out.println("The element " + target + " occurs at indices: ");
            for (int i = 0; i <= k-1; i++) { //** Notice this for-loop very carefully,so want to print only
                                             // the required indices and not the whole arr1
                System.out.print(arr1[i]);
                if (i < k-1) {
                    System.out.print(",");
                }
            }

        }
    }
}
