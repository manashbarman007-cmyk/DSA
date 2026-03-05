package special_binary_search_problems;

public class Bitonic_Array_Lec_21 {
    public static void main(String[] args) {
        int[] example1 = {2, 4, 5, 9, 11, 17, 6, 3, 1}; //bitonic array
        int[] example2 = {7, 1, 4, 5, 4, 4}; //non bitonic array
//        toFindMinimum(example1);
//        toCheckIsBitonic(example1);
//        toCheckIsBitonic(example2);
//        toFindPeak(example1);
//        toFindPeakByBinarySearch(example1);
        toFindTarget(example1, 1);
    }

    //To find the minimum element
    static void toFindMinimum(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) {
            System.out.println("The minimum element is: " + arr[0]);
        } else {
            System.out.println("The minimum element is: " + arr[arr.length - 1]);
        }
    }

    //To check if the given array is bitonic
    static void toCheckIsBitonic(int[] arr) {
        int index = 0, size = arr.length;

        // loop for the strictly increasing part (to find the peak element)
        while (index < size - 1) {
            if (arr[index] < arr[index + 1]) {
                index++;
            } else {   //This will give us the peak
                break;
            }
        }
        if (index == 0 || index == size - 1) {
            System.out.println("The array is not bitonic");
        }
        int newIndex = index;


        // loop for the strictly decreasing part (we need to reach the end of the array to be bitonic)
        if (index != 0 && index != size - 1) {
            while (newIndex < size - 1) {  //This while loop is executed only if the "if" statement is fulfilled
                if (arr[newIndex] > arr[newIndex + 1]) {
                    newIndex++;
                } else {
                    break;
                }
            }
            // if the array is bitonic newIndex will go to the last element of array
            if (newIndex == size - 1) {
                System.out.println("The array is bitonic");
            }
        }
    }


    //peak element in a bitonic array
    static void toFindPeak(int[] arr) {

        //first check if the array is bitonic and then return the peak element
        int index = 0, size = arr.length;

        //for the strictly increasing part
        while (index < size - 1) {
            if (arr[index] < arr[index + 1]) {
                index++;
            } else {
                break;
            }
        }
        if (index == 0 || index == size - 1) {
            System.out.println("It is not bitonic");
        }
        int newIndex = index;

        //for the strictly decreasing part
        if (index != 0 && index != size - 1) {
            while (newIndex < size - 1) {  //This while loop is executed only if the "if" statement is fulfilled
                if (arr[newIndex] > arr[newIndex + 1]) {
                    newIndex++;
                } else {
                    break;
                }
            }
        }
        // if the array is bitonic newIndex will go to the last element of array
        if (newIndex == size - 1) {
            System.out.println("The peak element is: " + arr[index]);
        }
    }

    //peak element in a bitonic array by binary search
    static void toFindPeakByBinarySearch(int[] arr) {
        int peak = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                peak = arr[mid];
                break;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("The peak of the bitonic array is: " + peak);
    }

    //finding target in bitonic array by binary search
    static void toFindTarget(int[] arr, int target) {

        // Step1: finding the peak
        int peak = -1, res = -1, resDec = -1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                peak = mid;  //peak will store the index of the peak element
                break;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //Step2: applying binary search in the increasing array
        start = 0;
        end = peak;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (res != -1) {
            System.out.println("The element " + target + " is found at index: " + res);
        }

        //Step3: applying binary search in decreasing array
        if (res == -1) {  //this block is executed if the target is not present in the increasing array
            start = peak + 1;
            end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    resDec = mid;
                    break;
                } else if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (resDec == -1) {
                System.out.println("The element " + target + " is not present in the array");
            } else {
                System.out.println("The element " + target + " is found at index: " + resDec);
            }

        }
    }
}
