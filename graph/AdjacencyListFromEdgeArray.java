package graph;
import java.util.*;

public class AdjacencyListFromEdgeArray {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {2, 0},
                {2, 3},
                {3, 3}
        };
        int numVertices = 4;

        Map<Integer, List<Integer>> adjacencyList = buildAdjacencyList(edges, numVertices);

        // Print the adjacency list
        for (int node : adjacencyList.keySet()) {
            System.out.println(node + " -> " + adjacencyList.get(node));
        }
    }

    // Function to build adjacency list from edge array
    public static Map<Integer, List<Integer>> buildAdjacencyList(int[][] edges, int numVertices) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Initialize the adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v); // For directed graph
            // adjList.get(v).add(u); // Uncomment for undirected graph
        }

        return adjList;
    }
}

