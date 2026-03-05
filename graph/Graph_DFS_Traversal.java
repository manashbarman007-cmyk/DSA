package graph;

import java.util.ArrayList;

public class Graph_DFS_Traversal {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> dfsOfGraph(int size,
                                         ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[size];
        dfs(0, visited, adjList, list); // the starting node is 0 (0-based indexing graph)
        return list;
    }
    public void dfs(int index, boolean[] visited,
                    ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> list) {
        // base condition
        if (visited[index]) {
            return;
        }
        list.add(index); // add the current node to the list
        visited[index] = true; // mark the current node as visited
        for (int adjNode : adjList.get(index)) {
           if (!visited[adjNode]) {
               dfs(adjNode, visited, adjList, list); // recursive call
           }
        }
    }
}
