package dynamic_programming;
import java.util.Comparator;

import java.util.*;

public class Longest_String_Chain_CN {
    public static void main(String[] args) {
        String[] str1 = {"dog", "dogs", "dots", "dot", "d", "do"};
        String[] str2 = {"x", "xx", "y", "xyx"};
        String[] str3 = {"a", "ab", "abc", "abcd", "abcde"};
        String[] str4 = {"m", "nm", "mmm"};
        String[] str5 = {"hsjsw", "hsjs", "hs", "fduou", "h", "m", "hsj"};

        System.out.println(longestStrChain(str1));
        System.out.println(longestStrChain(str2));
        System.out.println(longestStrChain(str3));
        System.out.println(longestStrChain(str4));
        System.out.println(longestStrChain(str5));

    }
    public static int longestStrChain(String[] arr) {
        // Write your code here.
        Arrays.sort(arr, new sortByLength());
        return f(arr, 0, -1);
    }
    static int f(String[] arr, int cur_ind, int prev_ind) {
        int n = arr.length; int m2 = -1;

        //base case
        if (cur_ind == n) {
            return 0;
        }
        int m1 = arr[cur_ind].length();
        if (prev_ind >= 0) {
            m2 = arr[prev_ind].length();
        }
        int pick = -1;
        if (prev_ind == -1 || compare(arr[cur_ind], arr[prev_ind])
        && lcs(arr[cur_ind], arr[prev_ind], m1 - 1, m2 - 1) == Math.min(m1, m2)) {
            pick = 1 + f(arr, cur_ind + 1, cur_ind);
        }
        int notPick = f(arr, cur_ind + 1, prev_ind);
        int length = Math.max(pick, notPick);
        return length;
    }

    // a function to check the longest common string subsequence
    static int lcs (String s1, String s2, int ind1, int ind2) {
        // base case
        if (ind1 < 0 || ind2 < 0) {
            return 0; //this means lcs is 0 if either of the string does not exist
        }
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
           int matching = 1 + lcs(s1, s2, ind1 - 1, ind2 - 1);
            return matching;
        }
        int notMatching = Math.max(lcs(s1, s2, ind1 - 1, ind2), lcs(s1, s2, ind1, ind2 - 1));
        return notMatching;
    }

    static boolean compare (String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) == 1) {
            return true;
        }
        return false;
    }

}

//we will sort the string array based on string length
class sortByLength implements Comparator< String > {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
