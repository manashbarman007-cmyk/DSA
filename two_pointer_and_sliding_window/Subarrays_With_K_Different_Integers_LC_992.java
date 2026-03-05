package two_pointer_and_sliding_window;

import java.util.HashMap;

public class Subarrays_With_K_Different_Integers_LC_992 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 2, 3};
        int[] nums2 = {1, 2, 1, 3, 4};
        System.out.println(subarraysWithKDistinct(nums1, 2));
        System.out.println(subarraysWithKDistinct(nums2, 3));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int x = func(nums, k);
        int y = func(nums, k - 1);
        return x - y;
    }

    // Using HashMap
//    static int func (int[] nums, int k) {
          // edge case
//        if (k < 0) {
//            return 0;
//        }
//        int l = 0, r = 0, goodSubarrays = 0;
//        int n = nums.length;
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//        while (r < n) {
//            int r_num = nums[r];
//            if (!freqMap.containsKey(r_num)) {
//                freqMap.put(r_num, 1);
//            }
//            else {
//                freqMap.put(r_num, freqMap.get(r_num) + 1); // increase the frequency by 1
//            }
//            if (freqMap.size() > k) {
//                while (freqMap.size() > k) {
//                    int l_num = nums[l];
//                    freqMap.put(l_num, freqMap.get(l_num) - 1); // reduce the frequency by 1
//                    if (freqMap.get(l_num) == 0) {
//                        freqMap.remove(l_num);
//                    }
//                    l++;
//                }
//            }
//            // if freqMap.size() <= k
//            goodSubarrays += r - l + 1;
//            r++;
//        }
//        return goodSubarrays;
//    }


    // Using array
    static int func (int[] nums, int k) {
        // edge case
        if (k < 0) {
            return 0;
        }
        int l = 0, r = 0, goodSubarrays = 0;
        int n = nums.length;
        int[] freqArray = new int[n]; // as 1 <= nums[i] <= n/
        int count = 0; // to keep a track on the unique elements
        while (r < n) {
            int r_num = nums[r];
            freqArray[r_num - 1]++; // increase the frequency of (r-num - 1) index by 1
            if (freqArray[r_num - 1] == 1) {
                count++; // this is when we introduce a unique element
            }
            if (count > k) {
                while (count > k) {
                    int l_num = nums[l];
                    freqArray[l_num - 1]--; // reduce the frequency of (l-num - 1) index by 1
                    if (freqArray[l_num - 1] == 0) {
                        count--; // this is when we reduce the count of the unique element by 1
                    }
                    l++;
                }
            }
            // if count <= k
            goodSubarrays += r - l + 1;
            r++;
        }
        return goodSubarrays;
    }
}
