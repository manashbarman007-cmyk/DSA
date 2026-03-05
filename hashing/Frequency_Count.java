package hashing;

import java.util.*;

public class Frequency_Count {
    public static void main(String[] args) {
        int[] arr = {22, 1, 2, 12, 1, 5, 1, 5};
        String s = "zaabaz";
        HashMap<Integer, Integer> hm1 = numFrequency(arr);
        for (Map.Entry<Integer, Integer> e : hm1.entrySet()) {
            System.out.println("key : " + e.getKey() + ", " + "value : " + e.getValue());
        }
        System.out.println();

        HashMap<Character, Integer> hm2 = charFrequency(s);
        for (Map.Entry<Character, Integer> e : hm2.entrySet()) {
            System.out.println("key : " + e.getKey() + ", " + "value : " + e.getValue());
        }

//       int[] map2 = charFrequency(s);
//       int m = map2.length;
//        for (int i = 0; i < m; i++) {
//            System.out.print(map2[i] + " ");
//        }
    }

    // Number Hashing
//    static int[] numFrequency (int[] arr) {
//        int[] hashArray = new int[13];
//        int n = arr.length;
//
//        // precompute
//        for (int i = 0; i < n; i++) {
//            hashArray[arr[i]]++;
//        }
//        return hashArray;
//    }
//
//    // Character Hashing
//    static int[] charFrequency (String s) {
//        int m = 'z' - 'a'; // m = 25
//        int[] hashArray = new int[m + 1];
//        int n = s.length();
//
//        // precompute
//        for (int i = 0; i < n; i++) {
//            hashArray[s.charAt(i) - 'a']++;
//        }
//        return hashArray;
//    }

    // Number Hashing (Using HashMaps)
    static HashMap<Integer, Integer> numFrequency(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        // precompute
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 1;
            if (hm.containsKey(key)) { // if key is already present in map we simply increase the freq by one
                freq = hm.get(key);
                freq++;
            }
            hm.put(key, freq);
        }
        return hm;
    }


    // Character Hashing (Using HashMaps)
    static HashMap<Character, Integer> charFrequency(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();

        // precompute
        for (int i = 0; i < n; i++) {
            char key = s.charAt(i);
            int freq = 1;
            if (hm.containsKey(key)) {
                freq = hm.get(key);
                freq++;
            }
            hm.put(key, freq);

        }
        return hm;
    }
}

