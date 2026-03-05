package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Safe_States_GFG {
    public static void main(String[] args) {
        Safe_States_GFG safe = new Safe_States_GFG();
        int[][] edges1 = {{1, 0},{1, 2},{1, 3},{1, 4},{2, 3},{3, 4}};
        int[][] edges2 = {{1, 2},{2, 3},{3, 2}};
        System.out.println(safe.safeNodes(5, edges1));
        System.out.println(safe.safeNodes(4, edges2));

    }
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        ArrayList<Integer> safeNodes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(V, edges);
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V]; // checks if the node is a part of a cycle or not
                                          // check[i] == true if the i-th node is not a part of a cycle
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adjList, check, visited, pathVisited, i);
            }
        }
        for (int i = 0; i < V; i++) {
            if (check[i]) safeNodes.add(i);
        }
        return safeNodes;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] check,
                                   boolean[] visited, boolean[] pathVisited, int curNode) {
        visited[curNode] = true;
        pathVisited[curNode] = true;

        for (int adjNode : adjList.get(curNode)) {
            if (!visited[adjNode]) {
               if (dfs(adjList, check, visited, pathVisited, adjNode)) return true; // no need to check further.
                                                                              // Simply return a true if we obtain any
                                                                              // terminal mode
            } else if (visited[adjNode] && pathVisited[adjNode]) {
                return true; // i.e. it is a cycle
            }
        }

        // if no cycle is found

        check[curNode] = true; // i.e. the curNode is not a part of a cycle and it does not lead into a cycle
        pathVisited[curNode] = false; // while returning if we do not find a cycle
        return false;
    }

    public ArrayList<ArrayList<Integer>> buildAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v); // for directed graph
//            adjList.get(v).add(u); // for undirected graph
        }
        return adjList;
    }
}
