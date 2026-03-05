package two_pointer_and_sliding_window;

public class Count_Number_Of_Nice_Subarrays_LC_1248 {
    public static void main(String[] args) {
        Count_Number_Of_Nice_Subarrays_LC_1248 obj = new Count_Number_Of_Nice_Subarrays_LC_1248();
        int[] nums1 = {1, 1, 2, 1, 1};
        int[] nums2 = {2, 4, 6};
        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(obj.numberOfSubarrays(nums1, 3));
        System.out.println(obj.numberOfSubarrays(nums2, 1));
        System.out.println(obj.numberOfSubarrays(nums3, 2));

    }
    public int numberOfSubarrays(int[] nums, int k) {
        int x = func(nums, k);
        int y = func(nums, k - 1);
        return x - y;
    }
    public int func (int[] nums, int k) {
        // edge case {
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0, r = 0, numOfSubarrays = 0, count = 0;
        while (r < n) {
            int r_num = nums[r];
            if (r_num % 2 == 1) {
                count++; // we keep a track of the odd numbers in the subarray
            }
            if (count > k) {
                while (count > k) {
                    int l_num = nums[l];
                    if (l_num % 2 == 1) {
                        count--;
                    }
                    l++;
                }
            }
            // if count <= k
            numOfSubarrays += r - l + 1;
            r++;
        }
        return numOfSubarrays;
    }
}
