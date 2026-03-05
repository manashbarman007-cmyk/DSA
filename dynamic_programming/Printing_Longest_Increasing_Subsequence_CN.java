package dynamic_programming;
import java.util.*;
public class Printing_Longest_Increasing_Subsequence_CN {
    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 1, 16, 8};
        System.out.println(printingLongestIncreasingSubsequence(arr, 6));
    }

    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        // Write Your Code Here
        List< Integer > list = new ArrayList<>();
        int[] dp = new int[x];
        Arrays.fill(dp, 1);
        return f(arr, x, dp, list);
    }
    static List< Integer > f(int[] arr, int x, int[] dp,  List< Integer > list) {

        int[] bt = new int[x];
        int LIS = -1;
        int maxi = 1; // as initially all the elements of dp array is 1
        int last_ind = 0; // initially we set the last_ind of the LIS to be 0
        for (int cur_ind = 0; cur_ind < x; cur_ind++) {
            bt[cur_ind] = cur_ind;
            for (int prev_ind = 0; prev_ind < cur_ind; prev_ind++) {
                if (arr[cur_ind] > arr[prev_ind] && 1 + dp[prev_ind] > dp[cur_ind]) {
                    dp[cur_ind] =  1 + dp[prev_ind];
                    bt[cur_ind] = prev_ind;
                }
                LIS = Math.max(LIS, dp[cur_ind]);
                if (dp[cur_ind] > maxi) {
                    last_ind = cur_ind; // we store the index of the largest element
                    maxi = dp[cur_ind];
                }
            }
        }
        list.add(arr[last_ind]);
        while (last_ind > 0) {
            list.add(arr[bt[last_ind]]);
            last_ind = bt[last_ind];
        }
        Collections.reverse(list);
        return list;
    }
}

