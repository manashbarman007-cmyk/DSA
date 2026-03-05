package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Safe_States_GFG_Using_BFS {
    public static void main(String[] args) {
        Safe_States_GFG_Using_BFS safe = new Safe_States_GFG_Using_BFS();
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 4}};
        System.out.println(safe.safeNodes(5, edges));

    }
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        reverseEdges(edges);
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(V, edges);
        ArrayList<Integer> safeNodes = new ArrayList<>();
        int[] countIndegree = indegree(V, adjList);
        Queue<Integer> queue = new LinkedList<>();

        bfs(V, adjList, queue, countIndegree, safeNodes);

        Collections.sort(safeNodes);

        return safeNodes;
    }

    public void reverseEdges(int [][] edges) {
        for (int[] edge : edges) {
            int temp = edge[0];
            edge[0] = edge[1];
            edge[1] = temp;
        }
    }

    public void bfs(int V, ArrayList<ArrayList<Integer>> adjList,
                    Queue<Integer> queue, int[] countIndegree, ArrayList<Integer> safeNodes) {
        for (int i = 0; i < V; i++) {
            if (countIndegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curEle = queue.poll();
            for (int adjNode : adjList.get(curEle)) {
                int updatedIndegree = countIndegree[adjNode] - 1; // reduce it by 1
                countIndegree[adjNode] = updatedIndegree; // update the new in-degree

                if (updatedIndegree == 0) {
                    queue.offer(adjNode);
                }

            }
            safeNodes.add(curEle);
        }
    }

    public int[] indegree (int V, ArrayList<ArrayList<Integer>> adjList) {
        int[] countIndegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                int curEle = adjList.get(i).get(j);
                countIndegree[curEle]++;
            }
        }
        return countIndegree;
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
