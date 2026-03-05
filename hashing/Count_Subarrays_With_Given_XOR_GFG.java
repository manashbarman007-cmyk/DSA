package hashing;

import java.util.HashMap;

public class Count_Subarrays_With_Given_XOR_GFG {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 6, 4};
        int[] arr2 = {5, 6, 7, 8, 9};
        int[] arr3 = {1, 1, 1, 1,};
        System.out.println(subarrayXor(arr1, 6));
//        System.out.println(subarrayXor(arr2, 5));
//        System.out.println(subarrayXor(arr3, 0));
    }
    public static long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int prefixXor = 0;
        hm.put(prefixXor, 1); // as initially prefixXor is 0, ie it appears 1 times
        long count = 0;
        for (int i = 0; i < n; i++) {
            prefixXor = prefixXor ^ arr[i];
            int y = prefixXor ^ k;
            if (hm.containsKey(y)) {
                count += hm.get(y);
            }
            if (hm.containsKey(prefixXor)) {
                hm.put(prefixXor, hm.get(prefixXor) + 1);
            }
            else {
                hm.put(prefixXor, 1);
            }

        }
        return count;
    }
}
