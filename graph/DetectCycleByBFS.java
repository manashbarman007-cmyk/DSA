package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleByBFS {
    public static void main(String[] args) {


    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) { // V : number of nodes

        boolean[] visited = new boolean[V]; // 0-based indexing graph
        for (int i = 0; i < V; i++) { // we do this as the graph can have multiple components
            if (!visited[i]) {
                if (detectForCycle(i, adjList, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectForCycle(int startNode,
                                  ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startNode, -1)); // -1 is a dummy node
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int curNode = queue.peek().curNode;
            int arrivedFrom = queue.peek().arrivedFrom;
            for (int adjNode : adjList.get(curNode)) {
                if (!visited[adjNode]) {
                    queue.offer(new Pair(adjNode, curNode));
                    visited[adjNode] = true;
                } else if (visited[adjNode] && arrivedFrom != adjNode) {
                    return true;
                }
            }

            queue.poll();
        }
        return false;
    }
}

class Pair {
    int curNode;
    int arrivedFrom;

    public Pair(int curNode, int arrivedFrom) {
        this.curNode = curNode;
        this.arrivedFrom = arrivedFrom;
    }
}
