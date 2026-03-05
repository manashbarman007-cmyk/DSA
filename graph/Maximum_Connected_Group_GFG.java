package graph;


import java.util.HashSet;
import java.util.Set;

public class Maximum_Connected_Group_GFG {
    int maxCount = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Maximum_Connected_Group_GFG max = new Maximum_Connected_Group_GFG();
        int[][] grid1 = {{1, 1}, {0, 1}};
        int[][] grid2 = {{1, 0, 1}, {1, 0, 1}, {1, 0, 1}};

        System.out.println(max.MaxConnection(grid1));
        System.out.println(max.MaxConnection(grid2));


    }
    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n - 1);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Step 1 : Find the size of each existing components
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) continue; // no need to process if it is 0

                int cellNumber = (i * n) + j;

                for (int k = 0; k < 4; k++) {
                    int nRow = i + dx[k];
                    int nCol = j + dy[k];
                    int adjCellNumber = (nRow * n) + nCol;
                    if (isValid(nRow, nCol, n) && grid[nRow][nCol] == 1) {
                        int root1 = ds.find(cellNumber);
                        int root2 = ds.find(adjCellNumber);
                        if (root1 != root2) {
                            ds.unionBySize(cellNumber, adjCellNumber);
                        }
                    }
                }
            }
        }

        int[] size = ds.size;
        for (int i = 0; i < size.length; i++) {
            maxCount = Math.max(size[i], maxCount);
        }

        // Step 2 : Try converting every 0 to 1 and find the new component size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) continue; // no need to process if it is 1
                Set<Integer> uniqueRoots = new HashSet<>();
                int count = 1; // 1 for itself
                for (int k = 0; k < 4; k++) {
                    int nRow = i + dx[k];
                    int nCol = j + dy[k];
                    int adjCellNumber = (nRow * n) + nCol;
                    if (isValid(nRow, nCol, n) && grid[nRow][nCol] == 1) {
                        int root = ds.find(adjCellNumber);
                        uniqueRoots.add(root); // to avoid counting the same size[root] more than once
                    }
                }
                for (int root : uniqueRoots) {
                    count += size[root];
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public boolean isValid(int nRow, int nCol, int n) {
        return nRow >= 0 && nRow < n && nCol >= 0 && nCol < n;
    }
}
