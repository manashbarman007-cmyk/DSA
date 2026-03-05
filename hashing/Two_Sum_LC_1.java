package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_LC_1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] res = twoSum(nums, 7);
        System.out.println(Arrays.toString(res));
    }

    // Approach 1 : Two pointer (TC = O(n * n) (approx))
//    public static int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        int n = nums.length;
//        for (int  i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++ ) {
//                if (nums[i] + nums[j] == target) {
//                    res[0] = i;
//                    res[1] = j;
//                }
//            }
//        }
//        return res;
//    }


    // Approach 2 : Using HashMap (TC = O(n))
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int  i = 0; i < n; i++) {
            int key = target - nums[i];
            if (!hm.containsKey(key)) { // ie if hm.containsKey(key) ==  false
                hm.put(nums[i], i);
            }
            else { //if (hm.containsKey(key))
                res[0] = i;
                res[1] = hm.get(key);
            }
        }

        return res;
    }
}
