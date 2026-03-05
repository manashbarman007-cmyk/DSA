package two_pointer_and_sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class Fruit_Into_Baskets_LC_904 {
    public static void main(String[] args) {
        int[] fruits1 = {1, 2, 1};
        int[] fruits2 = {0, 1, 2, 2};
        int[] fruits3 = {1, 2, 3, 2, 2};
        int[] fruits4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits1));
        System.out.println(totalFruit(fruits2));
        System.out.println(totalFruit(fruits3));
        System.out.println(totalFruit(fruits4));
    }

    // Approach 1 : generate all subarrays having at most 2 distinct elements (TC = O(n^2))
//    public static int totalFruit(int[] fruits) {
//        Set<Integer> set = new HashSet<>(); // stores unique elements
//        int n = fruits.length;
//        int maxLength = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//               if (!set.contains(fruits[j])) {
//                   set.add(fruits[j]);
//               }
//               if (set.size() <= 2) {
//                   int length = j - i + 1;
//                   maxLength = Math.max(length, maxLength);
//               }
//               else {
//                  break;
//               }
//            }
//            set.clear();
//        }
//        return maxLength;
//    }


    // Approach 2 : Sliding window and two pointers (TC = O(2n))
//    public static int totalFruit(int[] fruits) {
//        Map<Integer, Integer> frequncyMap = new HashMap();
//        int n = fruits.length;
//        int maxLength = 0;
//        int l = 0, r = 0;
//        while (r < n) {
//            if (!frequncyMap.containsKey(fruits[r])) {
//                frequncyMap.put(fruits[r], 1);
//            }
//            else {
//                frequncyMap.put(fruits[r], 1 + frequncyMap.get(fruits[r])); // we increase the frequency by one and update it
//            }
//            if (frequncyMap.size() > 2) {
//                while (frequncyMap.size() > 2) {
//                    frequncyMap.put(fruits[l], frequncyMap.get(fruits[l]) - 1); // reduce the frequency by one
//
//                    // if the frequency is 0 we remove it simply
//                    if (frequncyMap.get(fruits[l]) == 0) {
//                        frequncyMap.remove(fruits[l]);
//                    }
//
//                    l++;
//                }
//            }
//            else { // if (frequncyMap.size <= 2)
//                int length = r - l + 1;
//                maxLength = Math.max(length, maxLength);
//            }
//            r++;
//        }
//        return maxLength;
//    }

    // Approach 3 : Sliding window and two pointers (TC = O(2n))
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> frequncyMap = new HashMap();
        int n = fruits.length;
        int maxLength = 0;
        int l = 0, r = 0;
        while (r < n) {
            if (!frequncyMap.containsKey(fruits[r])) {
                frequncyMap.put(fruits[r], 1);
            }
            else {
                frequncyMap.put(fruits[r], 1 + frequncyMap.get(fruits[r])); // we increase the frequency by one and update it
            }
            if (frequncyMap.size() > 2) {
                frequncyMap.put(fruits[l], frequncyMap.get(fruits[l]) - 1); // reduce the frequency by one

                // if the frequency is 0 we remove it simply
                if (frequncyMap.get(fruits[l]) == 0) {
                    frequncyMap.remove(fruits[l]);
                }

                l++;
            }
            else { // if (frequncyMap.size <= 2)
                int length = r - l + 1;
                maxLength = Math.max(length, maxLength);
            }
            r++;
        }
        return maxLength;
    }
}
