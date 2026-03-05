package linear_search;

public class Linear_Search_Examples_In_2D_Array {
    public static void main(String[] args) {
        int[][] arr2D = {
                {10, 4, 2, 1, 50},
                {3, 6, 4, 7, 8},
                {9, 4, 6, 9, 4},  //This is a 2D array of 4 rows and 5 columns i.e [4][5]
                {1, 4, 3, 2, 5}
        };
//        toSearchFirstAndLastOccurrence(arr2D,1,false); //Searches first occurrence
//        toSearchFirstAndLastOccurrence(arr2D,1, true); //Searches last occurrence
//        toSearchMultipleOccurrences(arr2D,5);
        printMaxSum(arr2D);
    }

    //Linear search for first and last occurrence in array
    static void toSearchFirstAndLastOccurrence(int[][] arr, int target, boolean findLastOccurrence) {
        //if findLastOccurrence==true, we will find the last occurrence index
        int level1Index = -1, level2Index = -1;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {//i represents 1st level array
            for (int j = 0; j < arr[i].length; j++) {  //j represents 2nd level array
                if (arr[i][j] == target) {
                    level1Index = i;
                    level2Index = j;
                    if (findLastOccurrence == false) { //This exits the inner for loop
                        found = true;
                        break;
                    }
                }
            }
            if (found == true) {  //This exits the outer for loop
                break;
            }
        }


        if (level2Index == -1 && level2Index == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("The element " + target + " was first found at i: " + level1Index + " and j: " + level2Index);
        }
    }

    // Linear search for multiple occurrences in array
    static void toSearchMultipleOccurrences(int[][] arr, int target) {
        int k = 0;
        int size = arr.length * arr[0].length;
        int[][] res = new int[size][2]; //The resultant array will have two columns and size number of rows and we store
        // the result in an array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    res[k][0] = i;
                    res[k][1] = j;
                    k++;
                }
            }
        }
        // we weill print the 'res' arrray
        if (k == 0) {
            System.out.println("Element not found in array");
        } else {
            for (int i = 0; i < k; i++) {
                System.out.println("The element " + target + " is found at: " + res[i][0] + " and " + res[i][1]);
            }
        }

    }

    //Finding the maximum of a sub-array
    static void printMaxSum(int[][] arr) {
         int maxIndex=-1;
        int maxSum=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;          //We initialize the 'sum' inside the for-loop of 'i'
                                  // as for each iteration in 'i' we want 'sum' to be 0
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum + arr[i][j];
                if(maxSum<sum){
                    maxSum=sum;
                    maxIndex=i;
                }
            }
        }
        System.out.println("The maximum sum is found in array index: "+maxIndex);
        System.out.println("The maximum sum of the sub-array is: "+maxSum);
    }
}