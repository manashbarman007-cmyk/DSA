package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_In_Undirected_Graph_GFG {
    public static void main(String[] args) {
        Shortest_Path_In_Undirected_Graph_GFG path = new Shortest_Path_In_Undirected_Graph_GFG();
        int[][] edges1 = {{0, 1},{0, 3},{1, 2},{3, 4},{4, 5},{2, 6},{5, 6},{6, 7},{6, 8},{7, 8}};
        int[][] edges2 = {{0, 3},{1, 3}};

        System.out.println(Arrays.toString(path.shortestPath(9, edges1, 0)));
        System.out.println(Arrays.toString(path.shortestPath(4, edges2, 3)));

    }
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Pair5> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(V, edges);

        bfs(adjList, queue, dist, visited, src);

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    public void bfs(ArrayList<ArrayList<Integer>> adjList, Queue<Pair5> queue, int[] dist, boolean[] visited, int src) {
        queue.offer(new Pair5(src, 0));
        visited[src] = true;
        while (!queue.isEmpty()) {
            int curNode = queue.peek().node;
            int curDist = queue.peek().dist;
            queue.poll();
            for (int adjNode : adjList.get(curNode)) {
                if (!visited[adjNode]) {
                    dist[adjNode] = Math.min(dist[adjNode], curDist + 1);
                    queue.offer(new Pair5(adjNode, dist[adjNode]));
                    visited[adjNode] = true;
                }
            }
        }
    }


    public ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
class Pair5 {
    int node;
    int dist;

    public Pair5(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
