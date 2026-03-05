package graph;

import java.util.ArrayList;

public class Number_Of_Provinces_GFG {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        adjMatrix.get(0).add(0);
        adjMatrix.get(0).add(0);
        adjMatrix.get(0).add(0);
        adjMatrix.get(1).add(0);
        adjMatrix.get(1).add(1);
        adjMatrix.get(1).add(1);
        adjMatrix.get(2).add(0);
        adjMatrix.get(2).add(1);
        adjMatrix.get(2).add(1);

        System.out.println(numProvinces(adjMatrix, 2));


    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here

        ArrayList<ArrayList<Integer>> adjList = buildAdjListFromAdjMatrix(adj);
        int size = V + 1;
        int province = 0;

        boolean[] visited = new boolean[size]; // as 1 based indexing graph
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                province++;
                dfs(i, visited, adjList);
            }
        }

        return province;
    }
    public static void dfs(int index, boolean[] visited,
                    ArrayList<ArrayList<Integer>> adjList) {
        // base condition
        if (visited[index]) {
            return;
        }
        visited[index] = true; // mark the current node as visited
        for (int x : adjList.get(index)) {
            if (!visited[x]) {
                dfs(x, visited, adjList); // recursive call
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> buildAdjListFromAdjMatrix(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = adj.size();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (i != j) {
                    if(adj.get(i).get(j) == 1) {
                        adjList.get(i).add(j);
                    }
                }
            }
        }
        return adjList;
    }
}
