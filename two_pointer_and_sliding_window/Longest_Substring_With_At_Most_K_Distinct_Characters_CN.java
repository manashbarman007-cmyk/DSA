package two_pointer_and_sliding_window;
import java.util.*;

public class Longest_Substring_With_At_Most_K_Distinct_Characters_CN {
    public static void main(String[] args) {
        String str = "aaabbccd";
        System.out.println(kDistinctChars(2, str));
    }
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int n = str.length();
        int maxLength = 0, l = 0, r = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while (r < n) {
            char r_char = str.charAt(r);
            if (!freqMap.containsKey(r_char)) {
                freqMap.put(r_char, 1);
            }
            else {
                freqMap.put(r_char, freqMap.get(r_char) + 1); // increase the freq by 1
            }
            if (freqMap.size() > k) {
                char l_char = str.charAt(l);
                freqMap.put(l_char, freqMap.get(l_char) - 1); // reduce the freq by 1

                if (freqMap.get(l_char) == 0) {
                    freqMap.remove(l_char); // if freq is 0, simply remove it
                }

                l++;
            }
            else { // if (freqMap.size() <= k)
                int length = r - l + 1;
                maxLength = Math.max(maxLength, length);
            }

            r++;
        }
        return maxLength;
    }
}
