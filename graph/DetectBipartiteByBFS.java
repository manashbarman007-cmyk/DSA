package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectBipartiteByBFS {
    public static void main(String[] args) {
        DetectBipartiteByBFS bipartite = new DetectBipartiteByBFS();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(2).add(6);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(4).add(3);
        adjList.get(4).add(5);
        adjList.get(4).add(7);
        adjList.get(5).add(4);
        adjList.get(5).add(6);
        adjList.get(6).add(2);
        adjList.get(6).add(5);
        adjList.get(7).add(4);
        adjList.get(7).add(8);
        adjList.get(8).add(7);

        System.out.println(bipartite.isBipartite(8, adjList));

    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adjList) {

        int[] coloredArray = new int[V + 1]; // 1-based indexed graph
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= V; i++) { // we do this as there can be multiple components
            if (coloredArray[i] == 0) {
                if (!bfs(queue, coloredArray, adjList, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(Queue<Integer> queue, int[] coloredArray,
                       ArrayList<ArrayList<Integer>> adjList, int startNode) {
        queue.offer(startNode); // starting node
        coloredArray[startNode] = 1;

        while (!queue.isEmpty()) {
            int curNode = queue.peek();
            for (int adjNode : adjList.get(curNode)) {
                if (coloredArray[adjNode] == 0) { // i.e. not coloured
                    queue.offer(adjNode);
                    if (coloredArray[curNode] == 1) {
                        coloredArray[adjNode] = 2;
                    }
                    else { // if (coloredArray[curNode] == 2)
                        coloredArray[adjNode] = 1;
                    }
                }
                if (coloredArray[curNode] == coloredArray[adjNode]) return false;
            }
            queue.poll();
        }
        return true;
    }
}
