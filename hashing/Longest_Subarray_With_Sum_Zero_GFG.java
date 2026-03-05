package hashing;

import java.util.HashMap;

public class Longest_Subarray_With_Sum_Zero_GFG {
    public static void main(String[] args) {
        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr2 = {-31, -48, -90, 54, 20, 95, 6, -86, 22};
        System.out.println(maxLen(arr1));
        System.out.println(maxLen(arr2));
    }

    static int maxLen(int arr[]) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int max = 0;
        int sum = 0;
        hm.put(0, -1); // we initially put this, we assume that at index -1 the sum is 0
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                int count = i - hm.get(sum);
                max = Math.max(max, count);
            }
            else{
                hm.put(sum, i); // if hm does not contain the sum
            }
        }
        return max;
    }
}
