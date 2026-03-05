package greedy_algorithm;

public class Jump_Game_LC_55 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 5, 0, 0};
//        System.out.println(canJump(nums1));
//        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));

    }
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }
        int n = nums.length;
        int maxInd = 0;
        for (int i = 0; i < n - 1; i++) {
            maxInd = Math.max(maxInd, i + nums[i]);
            if (maxInd >= n - 1) {
                return true;
            }
            if (nums[i] == 0 && maxInd == i) {
                return false; // as we are at oth element
            }
        }
        return false;
    }
}
