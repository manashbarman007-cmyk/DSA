package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Replace_Os_With_Xs_GFG {
    public static void main(String[] args) {
        Replace_Os_With_Xs_GFG obj = new Replace_Os_With_Xs_GFG();
        char[][] grid = {{'X', 'O', 'X' , 'X'},
                         {'X', 'O', 'O' , 'X'},
                         {'X', 'O', 'O' , 'X'},
                         {'X', 'X', 'X' , 'X'}};
        
        for (char[] grid1 : grid) {
            System.out.println(Arrays.toString(grid1));
        }

        obj.fill(grid);

        System.out.println();
        System.out.println();

        for (char[] grid1 : grid) {
            System.out.println(Arrays.toString(grid1));
        }
    }

    public void fill(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        List<Pair1> boundaryOsList = findAllBoundaryOs(grid, row, col);
        List<Pair1> connectedOsWithBoundaryOsList = new ArrayList<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (Pair1 pair1 : boundaryOsList) {
            int curRow = pair1.x;
            int curCol = pair1.y;
            if (!visited[curRow][curCol]) {
                dfs(grid, visited, connectedOsWithBoundaryOsList, dx, dy, row, col, curRow, curCol);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = 'X';
            }
        }

        int ind = connectedOsWithBoundaryOsList.size() - 1;

        while(!connectedOsWithBoundaryOsList.isEmpty()) {
            int curRow = connectedOsWithBoundaryOsList.get(ind).x;
            int curCol = connectedOsWithBoundaryOsList.get(ind).y;
            grid[curRow][curCol] = 'O';
            connectedOsWithBoundaryOsList.remove(ind);
            ind--;
        }
    }

    public void dfs(char[][] grid, boolean[][] visited, List<Pair1> connectedOsWithBoundaryOsList,
                    int[] dx, int[] dy, int row, int col, int ind1, int ind2) {

        if (ind1 < 0 || ind1 > row - 1 || ind2 < 0 || ind2 > col - 1) {
            return;
        }

        visited[ind1][ind2] = true;

        connectedOsWithBoundaryOsList.add(new Pair1(ind1, ind2));

        for (int i = 0; i < 4; i++) {
            int nRow = ind1 + dx[i]; // neighbour row
            int nCol = ind2 + dy[i]; // neighbour col
            if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col
                && !visited[nRow][nCol] && grid[nRow][nCol] == 'O') {
                dfs(grid, visited, connectedOsWithBoundaryOsList, dx, dy, row, col, nRow, nCol);
            }
        }
    }

    public List<Pair1> findAllBoundaryOs(char[][] grid, int row, int col) {
        List<Pair1> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && grid[0][j] == 'O') {
                    list.add(new Pair1(0, j));
                }
                if (i == row - 1 && grid[row - 1][j] == 'O') {
                    list.add(new Pair1(row - 1, j));
                }
                if (i < row - 2) {
                    if (j == 0 && grid[i + 1][0] == 'O') {
                        list.add(new Pair1(i + 1, 0));
                    }
                    if (j == col - 1 && grid[i + 1][col - 1] == 'O') {
                        list.add(new Pair1(i + 1, col - 1));
                    }
                }
            }
        }
        return list;
    }
}

class Pair1 {
    int x; // representing x-coordinate
    int y; // representing y-coordinate

    public Pair1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
