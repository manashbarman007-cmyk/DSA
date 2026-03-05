package greedy_algorithm;

import java.util.Arrays;

public class Jump_Game_ii_LC_45 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {2, 3, 1, 3, 1, 1, 1, 2};
        int[] nums4 = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(nums1));
        System.out.println(jump(nums2));
        System.out.println(jump(nums3));
        System.out.println(jump(nums4));
    }

    // Brute force (Using recursion)
//    public static int jump(int[] nums) {
//        return func(nums, 0, 0);
//    }
//
//    static int func(int[] nums, int ind, int jumps) {
//        int n = nums.length;
//        // base case
//        if (ind >= n - 1) {
//            return jumps; // as we are out of the array
//        }
//        int jumpCount = Integer.MAX_VALUE;
//        // try out all possible ways on the index
//        for (int i = 1; i <= nums[ind]; i++) {
//            jumpCount = Math.min(jumpCount, func(nums, ind + i, jumps + 1)); // "1 + " as we took one jump
//        }
//        return jumpCount;
//    }

    // (Memoize it)
//    public static int jump(int[] nums) {
//        int n = nums.length;
//        int[][] dp = new int[n][n];
//        for (int[] x : dp) {
//            Arrays.fill(x, -1);
//        }
//        return func(nums, 0, 0, dp);
//    }
//
//    static int func(int[] nums, int ind, int jumps, int[][] dp) {
//        int n = nums.length;
//        // base case
//        if (ind >= n - 1) {
//            return jumps; // as we are out of the array
//        }
//        if (dp[ind][jumps] != -1) {
//            return dp[ind][jumps];
//        }
//        int jumpCount = Integer.MAX_VALUE;
//        // try out all possible ways on the index
//        for (int i = 1; i <= nums[ind]; i++) {
//            jumpCount = Math.min(jumpCount, func(nums, ind + i, jumps + 1, dp)); // "1 + " as we took one jump
//        }
//        return dp[ind][jumps] = jumpCount;
//    }


    // Optimal Approach
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int jumps = 0;
        int l = 0, r = 0;
        int farthest = 0;

        while (r < n - 1) {
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
