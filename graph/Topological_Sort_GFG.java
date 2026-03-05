package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort_GFG {
    public static void main(String[] args) {

        Topological_Sort_GFG sort = new Topological_Sort_GFG();
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(sort.topoSort(4, edges));

    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(V, edges);
        ArrayList<Integer> topo = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adjList, visited, stack, i);
            }
        }

        while(!stack.isEmpty()) {
            topo.add(stack.pop());
        }
        return topo;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
                    Stack<Integer> stack, int curNode) {
        visited[curNode] = true;
        for (int adjNode : adjList.get(curNode)) {
            if (!visited[adjNode]) {
                dfs(adjList, visited, stack, adjNode);
            }
        }
        // while returning add the node to the stack
        stack.push(curNode);
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
