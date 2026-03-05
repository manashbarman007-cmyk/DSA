package hashing;

import java.util.*;

public class Longest_Substring_Without_Repeating_Characters_LC_3 {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "aab";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
    }

    // Approach 2 : Better approach (TC = O(n^2))
//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        int maxi = -10000;
//        int n = s.length();
//        HashSet<Character> hs = new HashSet<>();
//        int left = 0;
//        int right = 0;
//        while (left < n) {
//            while (right < n) {
//                if (!hs.contains(s.charAt(right))) {
//                    hs.add(s.charAt(right));
//                    right++;
//                    maxi = Math.max(maxi, hs.size());
//                }
//                else {
//                   hs.clear();
//                   break; // we get out of the inner while loop
//                }
//            }
//            left++;
//            right = left;
//        }
//        return maxi;
//    }

    // Approach 3 : Optimal approach (TC = O(n))
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxi = -10000;
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int length;
        while (right < n) {
            char ch = s.charAt(right);
            if (hm.containsKey(ch)) {
                left = Math.max(left, hm.get(ch) + 1); // the left is updated if it is a part of the current substring
            }
            hm.put(ch, right); // update the new index for the particular key
            length = right - left + 1;
            maxi = Math.max(maxi, length);
            right++;
        }
        return maxi;
    }

}
