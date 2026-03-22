package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum_LC_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 1) return nums;

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove out-of-window elements
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Record result
            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
