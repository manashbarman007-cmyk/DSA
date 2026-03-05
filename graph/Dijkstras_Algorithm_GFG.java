package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras_Algorithm_GFG {
    public static void main(String[] args) {

        Dijkstras_Algorithm_GFG dijkstra = new Dijkstras_Algorithm_GFG();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        System.out.println(Arrays.toString(dijkstra.dijkstra(3, edges, 2)));

    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        PriorityQueue<Pair7> pq = new PriorityQueue<>((a , b) -> a.dist - b.dist); // ascending order
                                                                                              // of dist
        ArrayList<ArrayList<Pair7>> adjList = buildAdjList(V, edges);
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        bfs(adjList, visited, pq, dist, src);

        return dist;
    }

    public void bfs(ArrayList<ArrayList<Pair7>> adjList, boolean[] visited,
                    PriorityQueue<Pair7> pq, int[] dist, int src) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair7(src, 0));
        while (!pq.isEmpty()) {
            int curNode = pq.peek().node;
            int curDist = pq.peek().dist;
            pq.poll();

            if (visited[curNode]) continue; // we skip this iteration
            visited[curNode] = true;

            for (Pair7 adjNode : adjList.get(curNode)) {
                int weight = adjNode.dist;
                if (!visited[adjNode.node] && dist[adjNode.node] > curDist + weight) { // update it
                    dist[adjNode.node] = curDist + weight;
                    pq.offer(new Pair7(adjNode.node, dist[adjNode.node]));
                }
            }
        }
    }

    public ArrayList<ArrayList<Pair7>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Pair7>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Pair7(v, w));
            adjList.get(v).add(new Pair7(u, w));
        }
        return adjList;
    }
}
class Pair7 {
    int node;
    int dist;

    public Pair7(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
