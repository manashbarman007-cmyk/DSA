package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Number_Of_Provinces_GFG_Using_Disjoint_Set {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        adjMatrix.get(0).add(1);
        adjMatrix.get(0).add(0);
        adjMatrix.get(0).add(1);
        adjMatrix.get(1).add(0);
        adjMatrix.get(1).add(1);
        adjMatrix.get(1).add(0);
        adjMatrix.get(2).add(1);
        adjMatrix.get(2).add(0);
        adjMatrix.get(2).add(1);

        System.out.println(numProvinces(adjMatrix, 2));

    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = buildAdjListFromAdjMatrix(adj);
        DisjointSet ds = new DisjointSet(V);

        for (int i = 0; i < V; i++) {
            for (int adjNode : adjList.get(i)) {
                ds.unionByRank(i, adjNode);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < V; i++) {
            set.add(ds.find(i)); // use representative root
        }

        return set.size();
    }

    public static ArrayList<ArrayList<Integer>> buildAdjListFromAdjMatrix(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && adj.get(i).get(j) == 1) {
                    adjList.get(i).add(j); // keep 0-based indexing
                }
            }
        }
        return adjList;
    }
}
