package graph;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Shortest_Distance_In_A_Binary_Maze_GFG {
    public static void main(String[] args) {
        Shortest_Distance_In_A_Binary_Maze_GFG maze = new Shortest_Distance_In_A_Binary_Maze_GFG();
        int[][] grid = {
                          {1, 1, 1, 1},
                          {1, 1, 0, 1},
                          {1, 1, 1, 1},
                          {1, 1, 0, 0},
                          {1, 0, 0, 1}
                       };
        int[] source = {0, 1};
        int[] destination = {2, 2};

        System.out.println(maze.shortestPath(grid, source, destination));

    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n = grid.length; // row
        int m = grid[0].length; // col

        int srcRow = source[0];
        int srcCol = source[1];

        if (grid[srcRow][srcCol] != 1) return -1;

        int[][] dist = new int[n][m];
        PriorityQueue<Triplet1> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist); // min heap based on
                                                                                                    // dist

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        dijkstra(grid, source, dist, pq, dx, dy);

        int destRow = destination[0];
        int destCol = destination[1];

        if (dist[destRow][destCol] != Integer.MAX_VALUE) {
            return dist[destRow][destCol];
        }
        return -1; // else we return a -1
    }
    public void dijkstra (int[][] grid, int[] source,
                          int[][] dist, PriorityQueue<Triplet1> pq, int[] dx, int[] dy) {
        int n = grid.length; // row
        int m = grid[0].length; // col
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int srcRow = source[0];
        int srcCol = source[1];

        dist[srcRow][srcCol] = 0; // the source node
        pq.offer(new Triplet1(srcRow, srcCol, 0));

        while (!pq.isEmpty()) {
            Triplet1 curTriplet = pq.poll();
            int curRow = curTriplet.row;
            int curCol = curTriplet.col;
            int curDist = curTriplet.dist;
            for (int i = 0; i < 4; i++) {
                int nRow = curRow + dx[i]; // neighbour row
                int nCol = curCol + dy[i]; // neighbour col
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) { // i.e. inside the matrix bounds
                    if (grid[nRow][nCol] == 1 && dist[nRow][nCol] > curDist + 1) {
                        dist[nRow][nCol] = curDist + 1; // update it
                        pq.offer(new Triplet1(nRow, nCol, dist[nRow][nCol])); // offer it in pq
                    }
                }
            }
        }
    }
}
class Triplet1{
    int row;
    int col;
    int dist;

    public Triplet1(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
