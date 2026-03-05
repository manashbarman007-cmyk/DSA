package dynamic_programming;

import java.util.Arrays;

public class Longest_Bitonic_Sequence_CN {
    public static void main(String[] args) {
       int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longestBitonicSequence(arr, 8));
    }

    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        return f(arr, n, dp1, dp2);
    }

    static int f(int[] arr, int n, int[] dp1, int[] dp2) {
        int maxLength = -1;
        for (int cur_ind = 1; cur_ind < n; cur_ind++) { //we start from 1 as dp1[0] == 1 always
            for (int prev_ind = 0; prev_ind < cur_ind; prev_ind++) {
                if (arr[cur_ind] > arr[prev_ind]) {
                    dp1[cur_ind] = Math.max(1 + dp1[prev_ind], dp1[cur_ind]);
                }
            }
        }
        for (int cur_ind = n - 2; cur_ind >= 0; cur_ind--) { //we start from n - 2 as dp2[n - 1] == 1 always
            for (int prev_ind = n - 1; prev_ind > cur_ind; prev_ind--) {
                if (arr[cur_ind] > arr[prev_ind]) {
                    dp2[cur_ind] = Math.max(1 + dp2[prev_ind], dp2[cur_ind]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp1[i] + dp2[i] - 1);
        }
        return maxLength;
    }
}
