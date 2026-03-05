package different_searching_algorithms;

public class InterpolationSearchAlgorithm {
    public static void main(String[] args) {
        int [] ex1={2,4,6,8,10,12,14,16,18}; //uniform sorted array
        int[] ex2={2};
        System.out.println(performInterpolationSearch(ex1,112));
        System.out.println(performInterpolationSearch(ex2,2));
    }
    static int performInterpolationSearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        // if there is only one element in  the array
        if (arr[start] == arr[end]){
            if(arr[start]==target){
                return start;
            }
        }

            while (start <= end && target <= arr[end] && target >= arr[start]) {
                //calculating the probe position
                int pos = start + ((target - arr[start]) * (end - start)) / (arr[end] - arr[start]);
                if (arr[pos] == target) return pos;
                else if (target > arr[pos]) start = pos + 1;
                else end = pos - 1; //This is when target<arr[pos]
            }

            //if element is not present in the array -1 is returned
            return -1;
        }
    }
