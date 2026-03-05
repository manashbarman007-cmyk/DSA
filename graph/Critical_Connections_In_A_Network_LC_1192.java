package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Critical_Connections_In_A_Network_LC_1192 {
    int startTime = 1;
    public static void main(String[] args) {
        Critical_Connections_In_A_Network_LC_1192 crit = new Critical_Connections_In_A_Network_LC_1192();
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            connections.add(new ArrayList<>());
        }
        connections.get(0).add(0);
        connections.get(0).add(1);
        connections.get(1).add(1);
        connections.get(1).add(2);
        connections.get(2).add(2);
        connections.get(2).add(0);
        connections.get(3).add(1);
        connections.get(3).add(3);
        System.out.println(crit.criticalConnections(4, connections));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> criticalConnections = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] time = new int[n]; // time of insertion of dfs call
        int[] low = new int[n]; // minimum time of insertion of all the adjacent nodes excluding the parent node
        int[] parent = new int[n]; // to keep track of the parent node
        Arrays.fill(parent, -1);
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(n, connections);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs (adjList, criticalConnections, visited, time, low, parent, i);
            }
        }
        return criticalConnections;
    }
    public void dfs (ArrayList<ArrayList<Integer>> adjList, List<List<Integer>> criticalConnections,
                     boolean[] visited, int[] time, int[] low, int[] parent, int curNode) {
        visited[curNode] = true;
        time[curNode] = low[curNode] = startTime++;
        for (int adjNode : adjList.get(curNode)) {
            int parentOfCurNode = parent[curNode];

            if (adjNode == parentOfCurNode) continue; // no need to do anything

            if (!visited[adjNode]) {
                visited[adjNode] = true;
                parent[adjNode] = curNode;

                dfs(adjList, criticalConnections, visited, time, low, parent, adjNode);

                // while backtracking we update the low (we need to exclude the parent node of curNode)
                low[curNode] = Math.min(low[curNode], low[adjNode]);

                // while backtracking
                if (low[adjNode] > time[curNode]) { // i.e. it is a critical connection (i.e. a bridge)
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(curNode);
                    sublist.add(adjNode);
                    criticalConnections.add(sublist);
                }
            } else { // if curNode-adjNode is a back edge
                     // if adjNode is already visited then it can never be a part of a bridge (as we have already
                     //  reached it via another path)
                     // (we do not do any dfs), we simply take the minimum low
                low[curNode] = Math.min(low[curNode], low[adjNode]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> buildAdjList(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
