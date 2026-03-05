package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Longest_Increasing_Subsequence_By_Binary_Search {
    public static void main(String[] args) {
    int[] arr = {1, 7, 8, 4, 5, 6, -1, 9};
        System.out.println(longestIncreasingSubsequence(arr));
    }
    public static int longestIncreasingSubsequence(int arr[]) {
        List< Integer > list = new ArrayList<>();
        int n = arr.length;
        list.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            }
            else {
                int ind = upperBound(list, arr[i]);
                list.remove(ind);
                list.add(ind,arr[i]);
            }
        }
        return list.size();
    }
    static int upperBound(List<Integer> list, int target) { //using binary search
        int start = 0;
        int end = list.size() - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) >= target) {
                res = mid; //potential anss
                end = mid - 1; //move left
            }
            else { //if list.get(mid) < target
                start = mid + 1; //move left
            }
        }
        return res;
    }
}
