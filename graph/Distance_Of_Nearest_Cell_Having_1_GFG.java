package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Distance_Of_Nearest_Cell_Having_1_GFG {
    public static void main(String[] args) {

        Distance_Of_Nearest_Cell_Having_1_GFG cell = new Distance_Of_Nearest_Cell_Having_1_GFG();

        int[][] grid1 = {{0, 1, 1, 0},
                        {1, 1, 0, 0},
                        {0, 0, 1, 1}};
        System.out.println(cell.nearest(grid1));
        int[][] grid2 = {{0, 1, 0},
                        {1, 1, 0},
                        {1, 0, 0}};
        System.out.println(cell.nearest(grid2));

    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ans.add(new ArrayList<>());
        }

        Queue<Triplet> queue = new LinkedList<>();

        findInitialOnes(grid, ans, queue, visited);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()) {

            int curRow = queue.peek().row;
            int curCol = queue.peek().col;
            int curDist = queue.peek().distance;

            for(int i = 0; i < 4; i++) {
                int nRow = curRow + dx[i]; // neighbour row
                int nCol = curCol + dy[i]; // neighbour col
                if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col && !visited[nRow][nCol]) {
                    if(grid[nRow][nCol] == 0) {
                        ans.get(nRow).set(nCol, curDist + 1); // the set() method replaces the element at the
                                                              // specified index with the specified element
                        visited[nRow][nCol] = true;
                        queue.offer(new Triplet(nRow, nCol, curDist + 1));
                    }
                }
            }
            queue.poll();
        }
        return ans;
    }

    public void findInitialOnes(int[][] grid, ArrayList<ArrayList<Integer>> ans, Queue<Triplet> queue, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Triplet(i, j, 0));
                    visited[i][j] = true;
                }
                ans.get(i).add(0);
            }
        }
    }
}

class Triplet {
    int row;
    int col;
    int distance;

    public Triplet(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
