package graph;

import java.util.*;

public class Articulation_Point_i_GFG {
    public static void main(String[] args) {
        Articulation_Point_i_GFG ap = new Articulation_Point_i_GFG();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(4);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(4).add(3);

        System.out.println(adj);

        System.out.println(ap.articulationPoints(5, adj));

    }
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Set<Integer> set = new HashSet<>();
        int[] starting = {1};
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        int[] time = new int[V]; // time of insertion during dfs
        int[] low = new int[V];  // to track the minimum time of insertion during dfs of the
                                 // adjacent nodes excluding the parent node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs (adj, set, visited, parent, time, low, starting, i);
            }
        }
        ArrayList<Integer> ap = new ArrayList<>(set);
        Collections.sort(ap);
        return (!ap.isEmpty()) ? ap : new ArrayList<>(List.of(-1));
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, Set<Integer> set, boolean[] visited,
                    int[] parent, int[] time, int[] low, int[] starting, int curNode) {

        visited[curNode] = true;
        time[curNode] = low[curNode] = starting[0]++;
        int children = 0; // count the children of curNode in DFS recursion tree
        for (int adjNode : adj.get(curNode)) {
            int parentOfCurNode = parent[curNode];

            if (adjNode == parentOfCurNode) continue;

            if (!visited[adjNode]) {
                visited[adjNode] = true;
                parent[adjNode] = curNode;
                children++;
                dfs(adj, set, visited, parent, time, low, starting, adjNode);

                // Now the backtracking algorithm
                low[curNode] = Math.min(low[curNode], low[adjNode]);

                // Case 1 : curNode is root with more than 1 child
                if (parent[curNode] == -1 && children > 1) {
                    set.add(curNode);
                }

                // Case 2 : curNode is non root element
                if (low[adjNode] >= time[curNode] && parent[curNode] != -1) { // parent[curNode] == -1 is for the
                                                                              // source node, for the source node
                                                                              // we will use a different logic
                    set.add(curNode);
                }
            }else { // if (visited[adjNode]) i.e. curNode-adjNode is a back edge
                low[curNode] = Math.min(low[curNode], time[adjNode]);
            }
        }
    }
}
