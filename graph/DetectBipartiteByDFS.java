package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectBipartiteByDFS {
    public static void main(String[] args) {

        DetectBipartiteByDFS bipartite = new DetectBipartiteByDFS();
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

        for (int i = 1; i <= V; i++) { // we do this as there can be multiple components
            if (coloredArray[i] == 0) {
                coloredArray[i] = 1;
                if (!dfs(adjList, coloredArray, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int[] coloredArray, int curNode) {

        for (int adjNode : adjList.get(curNode)) {
            if (coloredArray[adjNode] == 0) {
                coloredArray[adjNode] = 3 - coloredArray[curNode]; // we switch between 1 and 2
                if (!dfs(adjList, coloredArray, adjNode)) {
                    return false; // if we get 'false' anywhere down the recursion tree, we will simply bubble up the
                                  // 'false' up the recursion tree
                }
            }
            if (coloredArray[curNode] == coloredArray[adjNode]) return false;
        }
        return true;
    }
}
