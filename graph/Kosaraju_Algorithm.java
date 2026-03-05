package graph;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_Algorithm {
    public static void main(String[] args) {
        Kosaraju_Algorithm kosaraju = new Kosaraju_Algorithm();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);

        System.out.println(kosaraju.kosaraju(adj));


    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size(); // number of vertices
        boolean[] visited = new boolean[V]; // 0-based indexed graph
        boolean[] transposeVisited = new boolean[V]; // 0-based indexed graph
        Stack<Integer> stack = new Stack<>();

        // Step 1
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs (adj, visited, stack, i);
            }
        }

        ArrayList<ArrayList<Integer>> scc = new ArrayList<>();

        // Step 2
        ArrayList<ArrayList<Integer>> transpose = transposeAdjList(adj);

        //Step 3 and 4
        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            if (!transposeVisited[curNode]) {
                ArrayList<Integer> sublist = new ArrayList<>();
                transposeDfs (transpose, sublist, transposeVisited, curNode);
                scc.add(sublist);
            }
        }

        System.out.println(scc);

        return scc.size();
    }
    public void transposeDfs (ArrayList<ArrayList<Integer>> transpose, ArrayList<Integer> sublist,
                              boolean[] transposeVisited, int curNode) {
        sublist.add(curNode);
        transposeVisited[curNode] = true; // mark as visited
        for (Integer adjNode : transpose.get(curNode)) {
            if (!transposeVisited[adjNode]) {
                transposeVisited[adjNode] = true; // mark as visited
                transposeDfs(transpose, sublist, transposeVisited, adjNode);
            }
        }

    }

    public void dfs (ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack, int curNode) {
        visited[curNode] = true; // mark as visited
        for (Integer adjNode : adj.get(curNode)) {
            if (!visited[adjNode]) {
                visited[adjNode] = true; // mark as visited
                dfs(adj, visited, stack, adjNode);
            }
        }
        stack.push(curNode);
    }

    public ArrayList<ArrayList<Integer>> transposeAdjList (ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        int ind = 0;
        for (ArrayList<Integer> sublist : adj) {
            for (Integer adjNode : sublist) {
                transpose.get(adjNode).add(ind);
            }
            ind++;
        }
        return transpose;
    }
}
