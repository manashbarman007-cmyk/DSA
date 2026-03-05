package heap_data_structure;

import java.util.*;

public class Top_K_Frequent_Elements_Leetcode_347 {
    int largest = -1;
    public static void main(String[] args) {
        Top_K_Frequent_Elements_Leetcode_347 top = new Top_K_Frequent_Elements_Leetcode_347();
        int[] nums = {1, 1, 2, 3, 1, 2};
        int[] res = top.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));

    }

    // Approach 1
//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int key = nums[i];
//            if (!map.containsKey(key)) {
//                map.put(key, 1);
//            }
//            else {
//                int count = map.get(key);
//                map.put(key, count + 1);
//            }
//        }
//
//        int[] res = new int[k];
//
//        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
//        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
//        Collections.sort(list,
//                (a, b) -> b.getValue() - a.getValue()); // sort in
//                                                                                            // descending order of values
//        for (int i = 1; i <= k; i++) {
//            res[i - 1] = list.get(i - 1).getKey();
//        }
//        return res;
//    }

    // Approach 2
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            }
            else {
                int count = map.get(key);
                map.put(key, count + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            list.add(integerIntegerEntry);
        }
        int[] res = new int[k];
        buildMaxHeap(list);
        for (int i = 1; i <= k; i++) {
            res[i - 1] = pop(list);
        }

        return res;
    }

    public void buildMaxHeap(List<Map.Entry<Integer, Integer>> list) {
        double n = list.size();
        for(int i = (int)Math.ceil(n / 2) - 1; i >= 0; i--) {
            maxHeapify(list, (int)n, i);
        }
    }

    public void maxHeapify(List<Map.Entry<Integer, Integer>> list, int n, int i) {
        int left = (2 * i) + 1; // position of left child
        int right = (2 * i) + 2; // position of right child
        if (left < n && list.get(left).getValue() > list.get(i).getValue()) {
            largest = left;
        }
        else largest = i;
        if (right < n && list.get(right).getValue() > list.get(largest).getValue()) {
            largest = right;
        }
        if (largest != i) { // if the largest is not the current index then heapify it
            Collections.swap(list, i, largest);
            maxHeapify(list, n, largest);
        }
    }

    public int pop(List<Map.Entry<Integer, Integer>> list) {
        Map.Entry<Integer, Integer> max = list.get(0);
        int n = list.size();
        Collections.swap(list, 0, n - 1);
        list.remove(n - 1); // remove the last element
        // max heapify the root
        int m = list.size();
        maxHeapify(list, m, 0);
        return max.getKey();
    }

}
