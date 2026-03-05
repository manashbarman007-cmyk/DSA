package dynamic_programming;

import java.util.Arrays;

public class Number_Of_LIS_CN {
    public static void main(String[] args) {
       int[] arr1 = {50, 3, 90, 60, 80};
       int[] arr2 = {5, 7, 2, 3};
        System.out.println(findNumberOfLIS(arr1));
        System.out.println(findNumberOfLIS(arr2));
    }

    public static int findNumberOfLIS(int []arr) {
        // Write your code here.
        int n = arr.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        return f(arr, n, dp);
    }
    static int f(int[] arr, int n, int[] dp) {
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxi = -1;
        int maxCount = 0;
        for (int cur_ind = 1; cur_ind < n; cur_ind++) {
            for (int prev_ind = 0; prev_ind < cur_ind; prev_ind++) {
                if (arr[cur_ind] > arr[prev_ind] && 1 + dp[prev_ind] > dp[cur_ind]) {
                    dp[cur_ind] = Math.max(dp[cur_ind], 1 + dp[prev_ind]);
                    count[cur_ind] = count[prev_ind];
                }
                else if (arr[cur_ind] > arr[prev_ind] && 1 + dp[prev_ind] == dp[cur_ind]) {
                   count[cur_ind] += count[prev_ind];
                }
                maxi = Math.max(maxi,dp[cur_ind]);

            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] ==maxi) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
