package two_pointer_and_sliding_window;

public class Binary_Subarrays_With_Sum_LC_930 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
    }

    // Approach 1 : Brute force
//    public static int numSubarraysWithSum(int[] nums, int goal) {
//        int n = nums.length;
//        int numOfSubarrays = 0;
//        for (int i = 0; i < n; i++){
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum == goal) {
//                    numOfSubarrays++;
//                }
//                else if (sum > goal) {
//                    break;
//                }
//            }
//        }
//        return numOfSubarrays;
//    }


    // Approach 2 : Sliding window and two pointer
    public static int numSubarraysWithSum(int[] nums, int goal) {

       int x = func(nums, goal);
       int y = func(nums, goal - 1);
       return x - y;
    }
    static  int func (int[] nums, int goal) {
        // edge case
        if (goal < 0) {
            return 0;
        }
        int n = nums.length;
        int numOfSubarrays = 0;
        int l = 0, r = 0, sum = 0;

        while (r < n) {
            int cur_r_ele = nums[r];
            sum += cur_r_ele;
            if (sum > goal) {
                while (sum > goal) {
                    int cur_l_ele = nums[l];
                    sum -= cur_l_ele;
                    l++;
                }
            }
            // if (sum <= goal)
            numOfSubarrays += r - l + 1;
            r++;
        }
        return numOfSubarrays;
    }
}
