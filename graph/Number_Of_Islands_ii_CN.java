package graph;

import java.util.Arrays;

public class Number_Of_Islands_ii_CN {
    public static void main(String[] args) {

        int[][] q = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        System.out.println(Arrays.toString(numOfIslandsII(3, 3, q)));
    }
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.
        int size = q.length;
        int[] res = new int[size];
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 0;

        for (int i = 0; i < size; i++) {

            int row = q[i][0]; // x-coordinate
            int col = q[i][1]; // y-coordinate

            if (visited[row][col]) continue; // skip this iteration

            // mark it as visited
            visited[row][col] = true;
            count++;

            int cellNumber = (row * m) + col;

            for (int l = 0; l < 4; l++) {
                int nRow = row + dx[l]; // neighbor row
                int nCol = col + dy[l]; // neighbor column
                int adjCellNumber = (nRow * m) + nCol;
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) { // i.e inside the grid
                    if (visited[nRow][nCol]) {
                        int root1 = ds.find(cellNumber);
                        int root2 = ds.find(adjCellNumber);
                        if (root1 != root2) {
                            count--; // reduce the count by 1
                            ds.unionByRank(cellNumber, adjCellNumber);
                        }
                    }
                }
            }
            res[i] = count;
        }
        return res;
    }
}
