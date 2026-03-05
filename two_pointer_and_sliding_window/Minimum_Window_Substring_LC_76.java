package two_pointer_and_sliding_window;

import java.util.*;

public class Minimum_Window_Substring_LC_76 {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String s2 = "a", t2 = "b";
        String s3 = "cabwefgewcwaefgcf", t3 = "cae";
        System.out.println(minWindow(s1, t1));
        System.out.println(minWindow(s2, t2));
        System.out.println(minWindow(s3, t3));
    }

    // Brute force
//    public static String minWindow(String s, String t) {
//        int n1 = s.length();
//        int n2 = t.length();
//        if (n1 < n2) {
//            return "";
//        }
//        int startInd = -1;
//        int minLength = (int)Math.pow(10, 9);
//
//        for (int i = 0; i < n1; i++) {
//
//            int[] freqArray = new int[256];
//            int count = 0;
//
//            for (int m = 0; m < n2; m++) { // iterating over string t
//                freqArray[t.charAt(m)]++;
//            }
//
//            for (int j = i; j < n1; j++) {
//                if (freqArray[s.charAt(j)] > 0) { // ie we have previsited
//                    count++;
//                    freqArray[s.charAt(j)]--;
//                }
//                if (count == n2) {
//                    int length = j - i + 1;
//                    if (length < minLength) {
//                        startInd = i;
//                        minLength = length; // update the minLength
//                    }
//                    break;
//                }
//            }
//        }
//       if (minLength < (int)Math.pow(10, 9)) {
//           return s.substring(startInd, startInd + minLength);
//       }
//       else return "";
//    }


    // Sliding window and two pointer
    public static String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 < n2) {
            return "";
        }
        int startInd = -1;
        int minLength = (int)Math.pow(10, 9);
        int l = 0, r = 0, count = 0;
        int[] freqArray = new int[256];

        for (int i = 0; i < n2; i++) {
            freqArray[t.charAt(i)]++;
        }

        while (r < n1) {
            char r_char = s.charAt(r);
            if (freqArray[r_char] > 0) { // ie it is previsited
                count++;
            }
            freqArray[r_char]--;
            if (count == n2) { // we try to shrink it
                while (count == n2){
                    char l_char = s.charAt(l);
                    int length = r - l + 1;
                    if (length < minLength) {
                        startInd = l;
                    }
                    minLength = Math.min(length, minLength); // update the minLength 
                    freqArray[l_char]++; // we reinsert it into the array
                    if (freqArray[l_char] > 0) {
                        count--;
                    }
                    l++;
                }
            }
            r++;
        }
        if (minLength < (int)Math.pow(10, 9)) {
            return s.substring(startInd, startInd + minLength);
        }
        else return "";
    }
}
