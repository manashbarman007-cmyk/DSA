package two_pointer_and_sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class Number_Of_Substrings_Containing_All_Three_Characters_LC_1358 {
    public static void main(String[] args) {
        Number_Of_Substrings_Containing_All_Three_Characters_LC_1358 obj =
                new Number_Of_Substrings_Containing_All_Three_Characters_LC_1358();
        String s = "abcabc";
        System.out.println(obj.numberOfSubstrings(s));

    }

    // Approach 1 : Brute force (TC = O(n^2))
//    public int numberOfSubstrings(String s) {
//        int n = s.length();
//        int numSubstrings = 0;
//        Set<Character> hs = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                char ch = s.charAt(j);
//                hs.add(ch);
//                if (hs.size() == 3) { // it can be a part of our substring
////                    numSubstrings++; // this is much slower
//                    numSubstrings = numSubstrings + (n - j); // as the remaining part will of course be our part
//                                                             // so, no need to check, simply add the remaining chars (n - j)
//                    break;
//                }
//            }
//            hs.clear();
//        }
//        return numSubstrings;
//    }

    // Approach 2 : Two pointer and sliding window
//    public int numberOfSubstrings(String s) {
//        int n = s.length();
//        int numSubstrings = 0;
//        Map<Character, Integer> lastSeenMap = new HashMap<>();
//        lastSeenMap.put('a', -1);
//        lastSeenMap.put('b', -1);
//        lastSeenMap.put('c', -1);
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            lastSeenMap.put(ch, i); // we store the index where we last see char ch
//            int minInd = Math.min(lastSeenMap.get('a'), Math.min(lastSeenMap.get('b'), lastSeenMap.get('c')));
//            if (minInd != -1) {
//                numSubstrings += minInd + 1;
//            }
//        }
//        return numSubstrings;
//    }

    // Approach 2 : Two pointer and sliding window
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int numSubstrings = 0;
        int[] lastSeenMap = {-1, -1, -1};
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastSeenMap[ch - 'a'] = i; // we store the index where we last see char ch
            int minInd = Math.min(lastSeenMap[0], Math.min(lastSeenMap[1], lastSeenMap[2]));
            if (minInd != -1) {
                numSubstrings += minInd + 1;
            }
        }
        return numSubstrings;
    }

    // Approach 1 : Brute force (TC = O(n^2))
//    public static int numOfSubstrings(int k, String str) {
//        // Write your code here
//        int n = str.length();
//        int numSubstrings = 0;
//        Set<Character> hs = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                char ch = str.charAt(j);
//                hs.add(ch);
//                if (hs.size() <= k) { // it can be a part of our substring
//                    numSubstrings++;
//                }
//            }
//            hs.clear();
//        }
//        return numSubstrings;
//    }

    // Approach 2 : Two pointer and sliding window
//    public static int numOfSubstrings(int k, String str) {
//        // Write your code here
//        int n = str.length();
//        int numSubstrings = 0;
//        Map<Character, Integer> freqMap = new HashMap<>();
//        int l = 0, r = 0;
//        while (r < n) {
//            char r_char = str.charAt(r);
//            if (!freqMap.containsKey(r_char)) {
//                freqMap.put(r_char, 1);
//            }
//            else {
//                freqMap.put(r_char, freqMap.get(r_char) + 1); // increase the freq by 1
//            }
//            if (freqMap.size() > k) {
//                char l_char = str.charAt(l);
//                while (freqMap.size() > k) {
//                    freqMap.put(l_char, freqMap.get(l_char) - 1); // reduce the freq by 1
//                    if (freqMap.get(l_char) == 0) {
//                        freqMap.remove(l_char);
//                    }
//                    l++;
//                }
//            }
//            else { // when freqMap.size() <= k
//                numSubstrings++;
//            }
//            r++;
//        }
//        return numSubstrings;
//    }
}
