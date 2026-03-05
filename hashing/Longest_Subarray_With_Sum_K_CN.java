package hashing;

import java.util.HashMap;

public class Longest_Subarray_With_Sum_K_CN {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 1, 1};
        System.out.println(longestSubarrayWithSumK(a, 3));
    }
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        HashMap<Long, Integer> hm = new HashMap<>();
        int maxi = -10000;
        long prefixSum = 0;
        hm.put(prefixSum, -1); // we put 0 and -1 represents the index
        int n = a.length;
        for (int i = 0; i < n; i++) {
            prefixSum += a[i];
            long y = prefixSum - k;
            if (hm.containsKey(y)) {
                int length = i - hm.get(y);
                maxi = Math.max(maxi, length);
            }
            if (!hm.containsKey(prefixSum)) {
                hm.put(prefixSum, i);
            }
        }
        return maxi;
    }
}
