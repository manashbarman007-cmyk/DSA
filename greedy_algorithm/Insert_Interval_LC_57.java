package greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Insert_Interval_LC_57 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] res = insert(intervals, newInterval);
        for (int[] x : res) {
            System.out.print(Arrays.toString(x));
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        int ind = 0;

        // left non overlapped part
        while (ind < n && intervals[ind][1] < newInterval[0]) {
            int[] row = intervals[ind];
            list.add(row);
            ind++;
        }

        // middle overlapped part
        while (ind < n && intervals[ind][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[ind][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[ind][1], newInterval[1]);
            ind++;
        }
        list.add(newInterval);

        // right non overlapped part
        while (ind < n) {
            int[] row = intervals[ind];
            list.add(row);
            ind++;
        }
        int[][] res = convertArrayListToArray(list);
        return res;
    }
    public static int[][] convertArrayListToArray(ArrayList<int[]> arrayList2D) {
        int[][] array2D = new int[arrayList2D.size()][]; // jagged array

        for (int i = 0; i < arrayList2D.size(); i++) {
            int[] innerArray = arrayList2D.get(i);
            array2D[i] = innerArray;
        }
        return array2D;
    }
}
