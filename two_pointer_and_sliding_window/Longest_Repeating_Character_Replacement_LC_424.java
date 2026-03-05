package two_pointer_and_sliding_window;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement_LC_424 {
    public static void main(String[] args) {
        String s1 = "ABBA";
        String s2 = "ADBD";
        String s3 = "AABABBA";
        System.out.println(characterReplacement(s1, 2));
        System.out.println(characterReplacement(s2, 1));
        System.out.println(characterReplacement(s3, 1));
    }

    // Approach 1 : Brute force
//    public static int characterReplacement(String s, int k) {
//        int n = s.length();
//        int maxLength = 0;
//        int maxFreq = 0;
//        int[] freqArray = new int[26]; // as the 26 alphabets (we use and array instead of hashmap for faster performance)
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                char cur_ch = s.charAt(j);
//                freqArray[cur_ch - 'A']++; // increase the frequency by 1
//                maxFreq = Math.max(maxFreq, freqArray[cur_ch - 'A']);
//                int length = j - i + 1;
//                int change = length - maxFreq;
//                if (change <= k) {
//                    maxLength = Math.max(maxLength, length);
//                }
//                else { // if change > k
//                    break;
//                }
//            }
//            Arrays.fill(freqArray, 0); // we reset all the values back to 0
//        }
//        return maxLength;
//    }


    // Approach 2 : Two pointer and sliding window (TC = O(2n * 26))
//    public static int characterReplacement(String s, int k) {
//        int n = s.length();
//        int l = 0, r = 0, maxLength = 0, maxFreq = 0;
//        int[] freqArray = new int[26];
//        while (r < n) {
//            char r_char = s.charAt(r);
//            freqArray[r_char - 'A']++; // we increase the freq by 1
//            maxFreq = Math.max(maxFreq, freqArray[r_char - 'A']);
//            int length = r - l + 1;
//            int change = length - maxFreq;
//            while (change > k) {
//                char l_char = s.charAt(l);
//                freqArray[l_char - 'A']--; // we decrease the freq by 1
//                maxFreq = 0; // reset the maxFreq to 0
//                for (int i = 0; i < 26; i++) {
//                    maxFreq = Math.max(maxFreq, freqArray[i]);
//                }
//                l++;
//                length = r - l + 1; // update the new length
//                change = length - maxFreq; // update the new change
//            }
//
//            // if change <= k
//            maxLength = Math.max(maxLength, length);
//
//            r++;
//        }
//        return maxLength;
//    }


    // Most optimal
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, maxLength = 0, maxFreq = 0;
        int[] freqArray = new int[26];
        while (r < n) {
            char r_char = s.charAt(r);
            freqArray[r_char - 'A']++; // we increase the freq by 1
            maxFreq = Math.max(maxFreq, freqArray[r_char - 'A']);
            int length = r - l + 1;
            int change = length - maxFreq;
            while (change > k) {
                char l_char = s.charAt(l);
                freqArray[l_char - 'A']--; // we decrease the freq by 1
                l++;
                length = r - l + 1; // update the new length
                change = length - maxFreq; // update the new change
            }

            // if change <= k
            maxLength = Math.max(maxLength, length);

            r++;
        }
        return maxLength;
    }
}
