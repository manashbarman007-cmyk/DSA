package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algorithm {
    public static void main(String[] args) {
        Prims_Algorithm prims = new Prims_Algorithm();
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 4, 2}, {2, 3, 2}, {3, 4, 1}};
        System.out.println(prims.spanningTree(5, edges));

    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Triplet4>> adjList = buildAdjList(V, edges);
        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        int[] sum = new int[1];
        boolean[] visited = new boolean[V];
        PriorityQueue<Triplet4> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        prims(adjList, mst, visited, pq, sum);

        return sum[0];
    }
    public void prims(ArrayList<ArrayList<Triplet4>> adjList, ArrayList<ArrayList<Integer>> mst,
                      boolean[] visited, PriorityQueue<Triplet4> pq, int[] sum) {
        pq.offer(new Triplet4(0, -1, 0)); // let's start with node 0

        while (!pq.isEmpty()) {
            Triplet4 curTriplet = pq.poll();
            int curNode = curTriplet.node;
            int curParent = curTriplet.parent;
            int curWeight = curTriplet.weight;

            if (visited[curNode]) continue;

            if (curParent != -1) {
                sum[0] += curWeight;
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(curParent);
                subList.add(curNode);
                mst.add(subList);
            }

            visited[curNode] = true; // mark the curNode as visited after polling

            for (Triplet4 adjTriplet : adjList.get(curNode)) {
                int adjNode = adjTriplet.node;
                int adjWeight = adjTriplet.weight;
                if (!visited[adjNode]) {
                    pq.offer(new Triplet4(adjNode, curNode, adjWeight));
                }
            }
        }
    }
    public ArrayList<ArrayList<Triplet4>> buildAdjList(int V, int [][] edges) {
        ArrayList<ArrayList<Triplet4>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Triplet4(v, -1, w));
            adjList.get(v).add(new Triplet4(u, -1, w));
        }
        return adjList;
    }
}
class Triplet4 {

    int node;
    int parent;
    int weight;

    public Triplet4(int node, int parent, int weight) {
        this.node = node;
        this.parent = parent;
        this.weight = weight;
    }
}
