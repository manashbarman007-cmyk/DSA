package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Non_Overlapping_Intervals_LC_435 {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2},
                              {2, 3},
                              {3, 4},
                              {1, 3}};

        int[][] intervals2 = {{1, 100},
                              {11, 22},
                              {1, 11},
                              {2, 12}};
        System.out.println(eraseOverlapIntervals(intervals1));
        System.out.println(eraseOverlapIntervals(intervals2));

    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Intervals[] arr = new Intervals[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Intervals(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(arr, new SortEnd());
        return solve(arr);
    }

    static int solve (Intervals[] arr) {
        int n = arr.length, count = 0;
        int endOfInterval = arr[0].end;
        for (int i = 1; i < n; i++) {
            if (arr[i].start < endOfInterval) {
                count++;
            }
            else { // if (arr[i].start >= endOfInterval)
                endOfInterval = arr[i].end;
            }
        }
        return count;
    }
}
class Intervals {
    int start, end;

    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class SortEnd implements Comparator<Intervals> {
    @Override
    public int compare(Intervals o1, Intervals o2) {
        return o1.end - o2.end; // sort end by ascending order
    }
}