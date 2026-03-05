package graph;

import java.util.Arrays;

public class Floyd_Warshall_GFG {
    public static void main(String[] args) {

        Floyd_Warshall_GFG fw = new Floyd_Warshall_GFG();
        int INF = (int)Math.pow(10, 8);
        int[][] dist = {{0, 4, INF, 5, INF}, {INF, 0, 1, INF, 6}, {2, INF, 0, 3, INF},
                {INF, INF, 1, 0, 2}, {1, INF, INF, 4, 0}};

        for (int[] x : dist) {
            System.out.println(Arrays.toString(x));
        }

        fw.floydWarshall(dist);

        for (int[] x : dist) {
            System.out.println(Arrays.toString(x));
        }
    }
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        int INF = (int)Math.pow(10, 8);
        for (int k = 0; k < V; k++) { // k : intermediate node
            for (int i = 0; i < V; i++) { // i -> k -> j
                for (int j = 0; j < V; j++) {
                    // dist[i][k] != INF && dist[k][j] != INF is checked, as if no edge exists between (i, k) and (j, k)
                    // k will not be a valid intermediate node
                    // i.e an edge must exist between (i, k) and (j, k)
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // for negative cycle check
//        for (int i = 0; i < V; i++) {
//            if (dist[i][i] < 0) System.out.println("Negative cycle exist");
//        }
    }
}
