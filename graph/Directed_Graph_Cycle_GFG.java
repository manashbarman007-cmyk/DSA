package graph;

import java.util.ArrayList;

public class Directed_Graph_Cycle_GFG {

    public static void main(String[] args) {
        Directed_Graph_Cycle_GFG cycle = new Directed_Graph_Cycle_GFG();
        int[][] edges1 = {{0, 1},{1, 2},{2, 0},{2, 3}};
        int[][] edges2 = {{0, 1},{0, 2},{1, 2},{2, 3}};
        System.out.println(cycle.isCyclic(4, edges1));
        System.out.println(cycle.isCyclic(4, edges2));
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V]; // we use this to keep track if the node is not a part of cycle and also
                                          // the node does lead to a cycle
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(V, edges);
        for(int i = 0; i < V; i++) { // as the graph can have multiple components
            if (!visited[i]) {
                if (dfs(adjList, visited, pathVisited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] pathVisited,
                        int curNode) {

        visited[curNode] = true;
        pathVisited[curNode] = true;
        for (int adjNode : adjList.get(curNode)) {
            if (!visited[adjNode]) {
                if (dfs(adjList, visited, pathVisited, adjNode)) {
                    return true; // bubble up the recursion tree
                }
            }
            else if (visited[adjNode] && pathVisited[adjNode]) {
                return true;
            }
        }

        // if no cycle is found

        pathVisited[curNode] = false; // If we do not find a solution (i.e. did not find a cycle):
                                     // We mark it as 'false' while returning so that we
                                     // know that we are not on the same path

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
