package graph;

import java.util.Arrays;

public class City_With_Smallest_Number_Of_Neighbors_At_A_Threshold_Distance_GFG {
    public static void main(String[] args) {
        City_With_Smallest_Number_Of_Neighbors_At_A_Threshold_Distance_GFG city =
                new City_With_Smallest_Number_Of_Neighbors_At_A_Threshold_Distance_GFG();
        int[][] edges = {{0, 1, 3},
                         {1, 2, 1},
                         {1, 3, 4},
                         {2, 3, 1}};
        System.out.println(city.findCity(4, 4, edges, 4));

    }
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int[][] dist = buildAdjMatrix(n, edges);
        int INF = Integer.MAX_VALUE;

        // floyd warshall algo
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF
                            && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // to count the neighbors

        int result = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count; // set minCount as count
                result = i; // tie breaking condition (we will prefer the larger index)
            }
        }
        return result;
    }
    public int[][] buildAdjMatrix(int n, int[][] edges) {
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) adjMatrix[i][j] = 0;
                else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjMatrix[u][v] = w;
            adjMatrix[v][u] = w;
        }
        return adjMatrix;
    }
}
