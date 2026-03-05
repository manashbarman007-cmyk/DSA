package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Shortest_Path_In_DAG_GFG {
    public static void main(String[] args) {

        Shortest_Path_In_DAG_GFG path = new Shortest_Path_In_DAG_GFG();

        int[][] edges = {{0, 1, 2},{0, 4, 1},{4, 5, 4},{4, 2, 2},{1, 2, 3},{2, 3, 6},{5, 3, 1}};
        System.out.println(Arrays.toString(path.shortestPath(6, 7, edges)));

    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // for the source node
        ArrayList<ArrayList<Pair4>> adjList = buildAdjList(V, edges);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adjList, visited, stack, i);// to get the topo sort
            }
        }

        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            if (dist[curNode] != Integer.MAX_VALUE) { // i.e. the curNode is reachable from the starting node
                for (Pair4 adjNode : adjList.get(curNode)) {
                    int weight = adjNode.weight;
                    dist[adjNode.node] = Math.min(dist[adjNode.node], dist[curNode] + weight);
                }
            }
            else { // i.e. the curNode is not reachable from the starting node
                dist[curNode] = -1;
            }
        }

        return dist;
    }

    public void dfs(ArrayList<ArrayList<Pair4>> adjList, boolean[] visited,
                    Stack<Integer> stack, int curNode) {
        visited[curNode] = true;
        for (Pair4 adjNode : adjList.get(curNode)) {
            if (!visited[adjNode.node]) {
                dfs(adjList, visited, stack, adjNode.node);
            }
        }
        // while returning add the node to the stack
        stack.push(curNode);
    }

    public ArrayList<ArrayList<Pair4>> buildAdjList(int V, int[][] edges) {

        ArrayList<ArrayList<Pair4>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2]; // edge weight
            adjList.get(u).add(new Pair4(v, w)); // for directed graph
        }
        return adjList;
    }
}

class Pair4{
    int node;
    int weight;

    public Pair4(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
