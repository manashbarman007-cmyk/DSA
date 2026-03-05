package two_pointer_and_sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Max_Consecutive_Ones_iii_LC_1004 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums1, 2));
        System.out.println(longestOnes(nums2, 3));
    }

    // Approach 1 : Brute force (TC = O(n^2))
//    public static int longestOnes(int[] nums, int k) {
//        int n = nums.length;
//        int maxLength = 0;
//        for (int i = 0; i < n; i++) {
//            int count_0 = 0;
//            for (int j = i; j < n; j++) {
//                int length = j - i + 1;
//                if (nums[j] == 0) {
//                    count_0++;
//                }
//                if (count_0 > k) { // won't be a part of our subarray
//                    break;
//                }
//                maxLength = Math.max(maxLength, length);
//            }
//        }
//        return maxLength;
//    }



    // Approach 2 : Two pointers and sliding window (TC = O(n))
//    public static int longestOnes(int[] nums, int k) {
//        int n = nums.length;
//        int l = 0, r = 0;
//        int maxLength = 0;
//        int count_0 = 0;
//        while (r < n) {
//            if (nums[r] == 0) {
//                count_0++;
//            }
//            if (count_0 > k) {
//                while (l < n) {
//                    if (nums[l] == 0) {
//                        count_0 = count_0 - 1; // reduce the count by 1
//                    }
//                    l++;
//                    break;
//                }
//            }
//            else { // if (count_0 <= k)
//                int length = r - l + 1;
//                maxLength = Math.max(length, maxLength);
//            }
//            r++;
//        }
//        return maxLength;
//    }


    // Approach 2 : Two pointers and sliding window with hashmap(TC = O(n))
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int maxLength = -1;
        int count_0 = 0;
        while (r < n) {
            if (nums[r] == 0) {
                count_0++;
            }
            if (count_0 > k) {
                if (nums[l] == 0) {
                    count_0 = count_0 - 1; // reduce the count by 1
                }
                l++;
            }
            else { // if (count_0 <= k)
                int length = r - l + 1;
                maxLength = Math.max(length, maxLength);
            }
            r++;
        }
        return maxLength;
    }
}
