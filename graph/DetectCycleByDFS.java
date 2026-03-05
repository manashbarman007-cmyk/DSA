package graph;

import java.util.ArrayList;

public class DetectCycleByDFS {
    public static void main(String[] args) {

    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[V]; // 0-based indexing graph
        for (int i = 0; i < V; i++) { // we do this as there can be multiple components
            if (!visited[i]) {
                if (detectForCycle(i, -1, adjList, visited)) return true; // -1 is a dummy index
            }
        }

        return  false;
    }
    public boolean detectForCycle(int curNode, int arrivedFrom,
                                  ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {

        visited[curNode] = true;
        for (int adjNode : adjList.get(curNode)) {
            if (!visited[adjNode]) {
                if (detectForCycle(adjNode, curNode, adjList, visited)) { // If that recursive call returns true,
                                                                          // it means a cycle was detected somewhere
                                                                          // deeper in the DFS tree — so you immediately
                                                                          // return true to bubble that result up.

                    return true;
                }
            } else if (visited[adjNode] && arrivedFrom != adjNode) {
                return true;
            }
        }
        return false;
    }
}




