package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Kruskals_Algorithm {

    public static void main(String[] args) {
        Kruskals_Algorithm krus = new Kruskals_Algorithm();
        int[][] edges = {{1, 5, 4}, {4, 5, 9}, {1, 4, 1}, {3, 4, 5},
                {1, 2, 2}, {2, 4, 3}, {2, 3, 3}, {3, 6, 8}, {2, 6, 7}};
        System.out.println(krus.spanningTree(6, edges));
    }
    public int spanningTree(int V, int[][] edges) {

        int E = edges.length;
        Edge[] newEdges = new Edge[E];
        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        buildEdges(edges, newEdges);
        Arrays.sort(newEdges, (a, b) -> a.weight - b.weight);
        DisjointSet ds = new DisjointSet(V);
        int sum = 0;
        for (int i = 0; i < E; i++) {
            int u = newEdges[i].node1;
            int v = newEdges[i].node2;
            int weight = newEdges[i].weight;

            int root1 = ds.find(u);
            int root2 = ds.find(v);

            if (root1 == root2) continue; // skip this iteration

            ds.unionByRank(u, v);
            // include u-v in the MST
            ArrayList<Integer> sublist = new ArrayList<>();
            sublist.add(u);
            sublist.add(v);
            mst.add(sublist);

            sum += weight;
        }

        return  sum;
    }
    public void buildEdges(int[][] edges, Edge[] newEdges) {
        int n = edges.length;

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            newEdges[i] = new Edge(u, v, w);
        }
    }

}
class Edge {
    int node1;
    int node2;
    int weight;

    public Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
}
