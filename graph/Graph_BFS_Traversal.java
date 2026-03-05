package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS_Traversal {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();


    }
    public ArrayList<Integer> bfsOfGraph(int size,
                                         ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0); // O-based indexed graph and the starting node is 0
        visited[0] = true;

        while(!queue.isEmpty()) {
            for(int adjNode : adjList.get(queue.peek())) {
                if (!visited[adjNode]) {
                    queue.offer(adjNode);
                    visited[adjNode] =  true;
                }
            }
            bfs.add(queue.poll());
        }
        return bfs;
    }

}
