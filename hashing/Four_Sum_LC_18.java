package hashing;
import java.util.*;
public class Four_Sum_LC_18 {
    public static void main(String[] args) {
        Four_Sum_LC_18 obj = new Four_Sum_LC_18();
        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {1000000000,1000000000,1000000000,1000000000};
//        int[] nums = {2, 2, 2, 2, 2};
        List<List<Integer>> list = obj.fourSum(nums, 0);
        System.out.println(list);
    }

    // Approach 1 : Brute Force (TC = O(nlogn + n^3*logn))
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<List<Integer>> list = new ArrayList<>();
//        int n = nums.length;
//        for (int  i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    int newTarget = target - (nums[i] + nums[j] + nums[k]);
//                    int ele = binarySearch(k + 1, n - 1, newTarget, nums);
//                    if (ele == newTarget) {
//                       List<Integer> sublist = new ArrayList<>();
//                       sublist.add(nums[i]);
//                       sublist.add(nums[j]);
//                       sublist.add(nums[k]);
//                       sublist.add(ele);
//                       if (!list.contains(sublist)) { // so that we can get the unique elements
//                           list.add(sublist);
//                       }
//                    }
//                }
//            }
//        }
//        return list;
//    }
//    static int binarySearch (int start, int end, int target, int[] arr) {
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] == target) {
//                return arr[mid];
//            } else if (arr[mid] < target) {
//                start = mid + 1; //move right
//            }
//            else {
//                end = mid - 1; // move left;
//            }
//        }
//        return -1000000; // if element not found
//    }

    // ApproCH 2 : Optimal approach  (TC = O(n^2))
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // to avoid consecutive duplicates
                                                   // as we have already checked for nums[i - 1]
                continue; // skip this iteration
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // to avoid consecutive duplicates
                                                           // as we have already checked for nums[j - 1]
                    continue; // skip this iteration
                }

                // two pointers
                int start = j + 1, end  = n - 1;

                while (start < end) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[start];
                    sum += nums[end];
                    if (sum == target) {
                        List<Integer> sublist = new ArrayList<>();
                        sublist.add(nums[i]);
                        sublist.add(nums[j]);
                        sublist.add(nums[start]);
                        sublist.add(nums[end]);
                        list.add(sublist);
                        start++;
                        end--;
                        // avoid duplicates
                        while (start < end && nums[start] == nums[start - 1]) { // as we have already checked for nums[start - 1]
                            start++;
                        }
                        // avoid duplicates
                        while (start < end && nums[end] == nums[end + 1]) { // as we have already checked for nums[end + 1]
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    }else { // if (sum > target)
                        end--;
                    }
                }
            }
        }
        return list;
    }
}
