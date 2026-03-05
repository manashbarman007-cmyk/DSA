package kadane_algorithm;
import java.util.*;

public class Maximum_Subarray_LC_53 {
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-2, -1, -3};
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));

    }

    // brute force
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int maxSum = -1000000;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                maxSum = Math.max(sum, maxSum);
//            }
//        }
//        return maxSum;
//    }


    // Kadane's algorithm (Maximum subarray sum)
//    public static int maxSubArray(int[] nums) {
//        if(nums.length == 1) {
//            return nums[0];
//        }
//        int maxEle = Integer.MIN_VALUE;
//        int n = nums.length;
//        int maxSum = Integer.MIN_VALUE;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            maxEle = Math.max(maxEle, nums[i]);
//
//            if (sum < 0) {
//                sum = 0; // we reset the sum to 0
//            }
//
//            maxSum = Math.max(sum, maxSum);
//        }
//        if (maxSum > 0) {
//            return maxSum;
//        }
//        else {
//            return maxEle;
//        }
//    }

    // Using Kadane's algorithm to print any of the subarrays
    public static List<Integer> maxSubArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int maxEle = Integer.MIN_VALUE;
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int startInd = -1, endInd = -1, start = -1;

        for (int i = 0; i < n; i++) {

            if (sum == 0) {
                start = i;
            }

            sum += nums[i];

            if (sum > maxSum) {
                startInd = start;
                endInd = i;
                maxSum = sum; // update the maxSum
            }

            maxEle = Math.max(maxEle, nums[i]);

            if (sum < 0) {
                sum = 0; // we reset the sum to 0
            }
        }

        if (startInd != -1 && endInd != -1) {
            for (int i = startInd; i <= endInd; i++) {
                list.add(nums[i]);
            }
        }

        if (maxSum == 0) {
            list.add(maxEle);
        }

        return list;
    }
}
