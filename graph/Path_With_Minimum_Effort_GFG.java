package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Path_With_Minimum_Effort_GFG {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2},
                           {3, 8, 2},
                           {5, 3, 5}};

        System.out.println(MinimumEffort(3, 3, heights));
    }
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int[][] effort = new int[rows][columns]; // stores the effort for each cell
        PriorityQueue<Triplet2> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        dijkstra(heights, effort, pq, dx, dy);

        return effort[rows - 1][columns - 1];
    }
    public static void dijkstra(int[][] heights, int[][] effort, PriorityQueue<Triplet2> pq, int[] dx, int[] dy) {
        int n = heights.length;
        int m = heights[0].length;
        for (int[] e : effort) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        pq.offer(new Triplet2(0, 0, 0));

        while (!pq.isEmpty()) {
            Triplet2 curTriplet = pq.poll();
            int curRow = curTriplet.row;
            int curCol = curTriplet.col;
            int curDiff = curTriplet.diff;
            for (int i = 0; i < 4; i++) {
                int nRow = curRow + dx[i];
                int nCol = curCol + dy[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    // we now consider the max absolute difference
                    int newDiff = Math.max(Math.abs(heights[nRow][nCol] - heights[curRow][curCol]), curDiff);

                    // we store the minimum of the current max and the previous max
                    if (newDiff < effort[nRow][nCol]) {
                        effort[nRow][nCol] = newDiff;
                        pq.offer(new Triplet2(nRow, nCol, effort[nRow][nCol]));
                    }
                }
            }
        }
    }

}
class Triplet2 {
    int row;
    int col;
    int diff; // signifies the difference between two consecutive cells

    public Triplet2(int row, int col, int diff) {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}
