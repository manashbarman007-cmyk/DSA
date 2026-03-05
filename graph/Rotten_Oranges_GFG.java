package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges_GFG {
    public static void main(String[] args) {
        Rotten_Oranges_GFG oranges = new Rotten_Oranges_GFG();
        int[][] mat = {{2, 1, 0, 2, 1},
                       {0, 0, 1, 2, 1},
                       {1, 0, 0, 2, 1}};
        System.out.println(oranges.orangesRot(mat));


    }
    public int orangesRot(int[][] mat) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        int countFresh = 0;
        int countFreshCheck = 0;
        int[][] visited = new int[row][col];
        Queue<Helper> queue = new LinkedList<>();

        // Step 1 : Store the coordinates of the initial rotten oranges along with time = 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new Helper(i, j, 0));
                    visited[i][j] = 2; // mark as visited
                }
                if (mat[i][j] == 1) countFresh += 1; // count the fresh oranges
            }
        }

        int maxTime = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int time = queue.peek().time;

            for (int i = 0; i < 4; i++) {
                int nRow = r + dx[i]; // neighbour row
                int nCol = c + dy[i]; // neighbour col
                if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col && visited[nRow][nCol] != 2) {
                    if (mat[nRow][nCol] == 1) {
                        countFreshCheck += 1; // count the fresh oranges
                        queue.offer(new Helper(nRow, nCol, time + 1));
                        visited[nRow][nCol] = 2; // mark as visited
                    }
                    if (mat[nRow][nCol] == 0) {
                        visited[nRow][nCol] = 2; // mark as visited
                    }
                }
            }
            maxTime = Math.max(maxTime, queue.poll().time);

        }

        if (countFreshCheck != countFresh) return -1;

        return maxTime;
    }
}
class Helper{
    int row;
    int col;
    int time;

    public Helper(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
