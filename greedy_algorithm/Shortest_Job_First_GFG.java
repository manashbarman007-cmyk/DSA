package greedy_algorithm;

import java.util.Arrays;

public class Shortest_Job_First_GFG {
    public static void main(String[] args) {
        int[] bt1 = {4, 3, 7, 1, 2};
        int[] bt2 = {1, 2, 3, 4};
        System.out.println(solve(bt1));
        System.out.println(solve(bt2));
    }
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n = bt.length;
        int total_wt = 0;
        int wt = 0;
        for (int i = 0; i < n; i++) {
            total_wt += wt;
            wt += bt[i];
        }
        double average_wt = total_wt / n;
        return (int)Math.floor(average_wt);
    }
}
