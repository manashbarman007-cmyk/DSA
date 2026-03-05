package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_i_GFG {
    public static void main(String[] args) {

    }
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        ArrayList<Integer> topo = topoSort(n, prerequisites);
        return topo.size() == n;

    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(V, edges);
        int[] countIndegree = findIndegree(adjList);
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        bfs(V, adjList, countIndegree, queue, topo);

        return topo;
    }

    public void bfs (int V, ArrayList<ArrayList<Integer>> adjList,
                     int[] countIndegree, Queue<Integer> queue,
                     ArrayList<Integer> topo) {

        for (int i = 0; i < V; i++) {
            if (countIndegree[i] == 0) queue.offer(i); // offer the 0 in-degree elements into the queue
        }

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int adjNode : adjList.get(curNode)) {
                int updateIndegree = countIndegree[adjNode] - 1; // reduce the indegree count of the adjNode by 1
                countIndegree[adjNode] = updateIndegree; // update the new indegree
                if (updateIndegree == 0) { // if the count is 0 add it to the queue
                    queue.offer(adjNode);
                }
            }
            topo.add(curNode);
        }

    }

    public int[] findIndegree(ArrayList<ArrayList<Integer>> adjList) {
        int n = adjList.size();
        int[] countIndegree = new int[n];

        for (int i = 0; i < n; i++) {
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
            adjList.get(v).add(u); // for directed graph
//            adjList.get(v).add(u); // for undirected graph
        }
        return adjList;
    }
}
