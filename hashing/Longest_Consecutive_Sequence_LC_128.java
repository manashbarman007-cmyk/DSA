package hashing;

import java.util.*;
import java.util.Map;

public class Longest_Consecutive_Sequence_LC_128 {
    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {1, 0, 1, 2};
        int[] nums3 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums4 = {0, 2, -1};
        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
        System.out.println(longestConsecutive(nums3));
        System.out.println(longestConsecutive(nums4));
    }
    public static int longestConsecutive(int[] nums) {

        // edge cases
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // store the unique elements
            hs.add(nums[i]);
        }
        int max = -100000;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int key = nums[i] - 1;
            if (!hs.contains(key)) {
                key = nums[i];
                while (hs.contains(key)) {
                    count++;
                    key++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
