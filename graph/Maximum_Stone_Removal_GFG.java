package graph;

import java.util.*;

public class Maximum_Stone_Removal_GFG {
    public static void main(String[] args) {
        Maximum_Stone_Removal_GFG stone = new Maximum_Stone_Removal_GFG();
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(stone.maxRemove(stones));

    }
    int maxRemove(int[][] stones) {
        // Code here
        int n = stones.length; // number of stones
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];

            maxRow = Math.max(row, maxRow);
            maxCol = Math.max(col, maxCol);
        }

        int rowSize = maxRow + 1;
        int colSize = maxCol + 1;

        DisjointSet ds = new DisjointSet(rowSize + colSize);
        HashMap<Integer, Boolean> stoneNodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0]; // row represented as a node
            int nodeCol = maxRow + 1 + stones[i][1]; // col represented as a node
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, true);  // i.e. nodeRow is present int the component
            stoneNodes.put(nodeCol, true);  // i.e. nodeCol is present int the component
        }

        int cnt = 0;

        // now we need to count the number of components
        for (Map.Entry<Integer, Boolean> entry : stoneNodes.entrySet()) {
            int root = ds.find(entry.getKey());
            if (root == entry.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }
}

