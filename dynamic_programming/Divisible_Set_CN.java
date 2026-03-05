package dynamic_programming;
import java.util.*;

public class Divisible_Set_CN {
    public static void main(String[] args) {
       int[] arr1 = {1, 16, 7, 8, 4};
       int[] arr2 = {24, 9, 20, 9, 9, 11, 20};
       int[] arr3 = {20, 19, 11, 25, 21};
       int[] arr4 = {10, 2, 5, 5, 10, 17};
        System.out.println(divisibleSet(arr1));
        System.out.println(divisibleSet(arr2));
        System.out.println(divisibleSet(arr3));
        System.out.println(divisibleSet(arr4));
    }
    public static List< Integer > divisibleSet(int []arr) {
        // Write your code here.
        Arrays.sort(arr);
        int n = arr.length;
        List< Integer > list = new ArrayList<>();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        return f(arr, list, dp);
    }
    static List< Integer > f(int []arr, List< Integer > list, int[] dp) {
        int n = arr.length;
        int last_ind = 0;
        int maxi = -1;
        int[] bt = new int[n];

        for (int cur_ind = 1; cur_ind <= n - 1; cur_ind++) {
            bt[cur_ind] = cur_ind;
            for(int prev_ind = 0; prev_ind < cur_ind; prev_ind++) {
                if (arr[cur_ind] % arr[prev_ind] == 0 && dp[cur_ind] < 1+ dp[prev_ind]) {
                    dp[cur_ind] = 1 + dp[prev_ind];
                    bt[cur_ind] = prev_ind;

                    maxi = Math.max(maxi,dp[cur_ind]);
                    if(dp[cur_ind] == maxi) {
                        last_ind = cur_ind;
                    }
                }
            }
        }
        list.add(arr[last_ind]);
        while (last_ind != bt[last_ind]) {
            list.add(arr[bt[last_ind]]);
            last_ind = bt[last_ind];
        }
        Collections.reverse(list);
        return list;
    }
}
