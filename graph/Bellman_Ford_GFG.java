package graph;

import java.util.Arrays;

public class Bellman_Ford_GFG {
    public static void main(String[] args) {

        Bellman_Ford_GFG bf = new Bellman_Ford_GFG();
        int[][] edges = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        System.out.println(Arrays.toString(bf.bellmanFord(5, edges, 0)));

    }
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int  E = edges.length; // number of edges
        int[] dist = new int[V];
        Arrays.fill(dist, (int)Math.pow(10, 8));
        dist[src] = 0;

        // perform edge relaxation for V - 1 times
        for (int i = 1; i <= V - 1; i++) {
            // for each edge
            for (int j = 0; j < E; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if (dist[u] != (int)Math.pow(10, 8) && dist[v] > dist[u] + w) { // we do not check for unreachable node
                                                                                // i.e. dist[u] != (int)Math.pow(10, 8)
                                                                                // since, if 'u' is unreachable, then we
                                                                                // cannot go from 'u' to 'v'
                    dist[v] = dist[u] + w; // update the dist
                }
            }
        }

        // check for negative cycle
        // run a check for each edge
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if (dist[u] != (int)Math.pow(10, 8) && dist[v] > dist[u] + w) { // we do not check for unreachable node
                                                                            // i.e. dist[u] != (int)Math.pow(10, 8)

                int[] negative = new int[1];
                negative[0] = -1;
                return negative;
            }
        }
        return dist;
    }
}
