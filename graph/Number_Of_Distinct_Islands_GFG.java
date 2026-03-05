package graph;

import java.util.*;

public class Number_Of_Distinct_Islands_GFG {
    public static void main(String[] args) {

        Number_Of_Distinct_Islands_GFG islandsGfg = new Number_Of_Distinct_Islands_GFG();

        int[][] grid1 = {{1, 1, 0, 0, 0},
                         {1, 1, 0, 0, 0},
                         {0, 0, 0, 1, 1},
                         {0, 0, 0, 1, 1}};

        int[][] grid2 = {{1, 1, 0, 1, 1},
                         {1, 0, 0, 0, 0},
                         {0, 0, 0, 1, 1},
                         {1, 1, 0, 1, 0}};

        System.out.println(islandsGfg.countDistinctIslands(grid1));
        System.out.println(islandsGfg.countDistinctIslands(grid2));

    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length; // row size
        int m = grid[0].length; // col size

        List<List<Pair3>> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair3> sublist = new ArrayList<>();
                    dfs(grid, visited, sublist, dx, dy, i, j, i, j);
                    list.add(sublist);
                }
            }
        }

        Set<List<Pair3>> set = new HashSet<>();
        for (List<Pair3> sublist : list) {
            set.add(sublist); // store the unique sublists
        }

        return set.size();
    }

    public void dfs(int[][] grid, boolean[][] visited, List<Pair3> sublist,
                    int[] dx, int[] dy, int baseX, int baseY, int ind1, int ind2) {

        int n = grid.length; // row size
        int m = grid[0].length; // col size
        if (ind1 < 0 || ind1 >= n || ind2 < 0 || ind2 >= m) {
            return;
        }
        visited[ind1][ind2] = true;
        int num1 = ind1 - baseX;
        int num2 = ind2 - baseY;
        sublist.add(new Pair3(num1, num2));

        for (int i = 0; i < 4; i++) {
            int nRow = ind1 + dx[i]; // neighbour row
            int nCol = ind2 + dy[i]; // neighbour col
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(grid, visited, sublist, dx, dy, baseX, baseY, nRow, nCol);
            }
        }
    }
}

class Pair3 {
    int x; // representing x coordinate
    int y; // representing y coordinate

    public Pair3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair3)) return false;
        Pair3 pair = (Pair3) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
