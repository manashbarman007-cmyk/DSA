package graph;

import java.util.*;

public class Dijkstras_Algorithm_Using_Set {
    public static void main(String[] args) {

        Dijkstras_Algorithm_Using_Set dijkstra = new Dijkstras_Algorithm_Using_Set();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        System.out.println(Arrays.toString(dijkstra.dijkstra(3, edges, 2)));


    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        ArrayList<ArrayList<Pair8>> adjList = buildAdjList(V, edges);
        Set<Pair8> set = new TreeSet<>(); // sort in ascending order of distance
        bfs(adjList, dist, set, src);
        return dist;
    }
    public void bfs (ArrayList<ArrayList<Pair8>> adjList, int[] dist, Set<Pair8> set, int src) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        set.add(new Pair8(src, 0));
        while (!set.isEmpty()) {
            Pair8 curPair = set.stream().findFirst().get();
            int curNode = curPair.node;
            int curDist = curPair.dist;
            set.remove(curPair); // remove from the set

            for (Pair8 adjPair : adjList.get(curNode)) {
                int weight = adjPair.dist;
                int adjNode = adjPair.node;
                if (dist[adjNode] > curDist + weight) {
                    set.remove(adjPair); // remove the old adjPair from the set if it exists in the set
                    dist[adjNode] = curDist + weight;
                    set.add(new Pair8(adjNode, dist[adjNode]));
                }
            }
        }
    }
    public ArrayList<ArrayList<Pair8>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Pair8>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Pair8(v, w));
            adjList.get(v).add(new Pair8(u, w));
        }
        return adjList;
    }
}
class Pair8 implements Comparable<Pair8>{
    int node;
    int dist;

    public Pair8(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair8 pair8)) return false;
        return node == pair8.node && dist == pair8.dist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, dist);
    }

    @Override
    public int compareTo(Pair8 other) {
        if (this.dist != other.dist) {
            return Integer.compare(this.dist, other.dist); // If distances differ, the smaller distance comes first
        }
        return Integer.compare(this.node, other.node); // Tie-breaking
                                                       // If distances are equal, the smaller node comes first
                                                       // - Without this, two equal dist values could be
                                                       // considered "equal" even if they belong to different nodes,
                                                       // which can cause issues in TreeSet
    }
}
