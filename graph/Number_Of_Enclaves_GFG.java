package graph;

import java.util.ArrayList;
import java.util.List;

public class Number_Of_Enclaves_GFG {
    public static void main(String[] args) {

        Number_Of_Enclaves_GFG enclavesGfg = new Number_Of_Enclaves_GFG();

        int[][] grid1 = {{0, 0, 0, 0},
                         {1, 0, 1, 0},
                         {0, 1, 1, 0},
                         {0, 0, 0, 0}};

        int[][] grid2 = {{0, 0, 0, 1},
                         {0, 1, 1, 0},
                         {0, 1, 1, 0},
                         {0, 0, 0, 1},
                         {0, 1, 1, 0}};

        System.out.println(enclavesGfg.numberOfEnclaves(grid1));
        System.out.println(enclavesGfg.numberOfEnclaves(grid2));

    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        List<Pair2> boundary1sList = findAllBoundary1s(grid, row, col);
        List<Pair2> connected1sWithBoundary1sList = new ArrayList<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (Pair2 pair2 : boundary1sList) {
            int curRow = pair2.x;
            int curCol = pair2.y;
            if (!visited[curRow][curCol]) {
                dfs(grid, visited, connected1sWithBoundary1sList, dx, dy, row, col, curRow, curCol);
            }
        }

        int ind = connected1sWithBoundary1sList.size() - 1;

        while(!connected1sWithBoundary1sList.isEmpty()) {
            int curRow = connected1sWithBoundary1sList.get(ind).x;
            int curCol = connected1sWithBoundary1sList.get(ind).y;
            grid[curRow][curCol] = 0;
            connected1sWithBoundary1sList.remove(ind);
            ind--;
        }

        int countLand = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) countLand++;
            }
        }


        return countLand;
    }
    public void dfs(int[][] grid, boolean[][] visited, List<Pair2> connectedOsWithBoundaryOsList,
                    int[] dx, int[] dy, int row, int col, int ind1, int ind2) {

        if (ind1 < 0 || ind1 > row - 1 || ind2 < 0 || ind2 > col - 1) {
            return;
        }

        visited[ind1][ind2] = true;

        connectedOsWithBoundaryOsList.add(new Pair2(ind1, ind2));

        for (int i = 0; i < 4; i++) {
            int nRow = ind1 + dx[i]; // neighbour row
            int nCol = ind2 + dy[i]; // neighbour col
            if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col
                    && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(grid, visited, connectedOsWithBoundaryOsList, dx, dy, row, col, nRow, nCol);
            }
        }
    }

    public List<Pair2> findAllBoundary1s(int[][] grid, int row, int col) {
        List<Pair2> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && grid[0][j] == 1) {
                    list.add(new Pair2(0, j));
                }
                if (i == row - 1 && grid[row - 1][j] == 1) {
                    list.add(new Pair2(row - 1, j));
                }
                if (i < row - 2) {
                    if (j == 0 && grid[i + 1][0] == 1) {
                        list.add(new Pair2(i + 1, 0));
                    }
                    if (j == col - 1 && grid[i + 1][col - 1] == 1) {
                        list.add(new Pair2(i + 1, col - 1));
                    }
                }
            }
        }
        return list;
    }
}
class Pair2 {
    int x; // representing x-coordinate
    int y; // representing y-coordinate

    public Pair2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

