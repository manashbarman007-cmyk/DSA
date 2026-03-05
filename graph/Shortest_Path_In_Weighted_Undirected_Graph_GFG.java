package graph;

import java.util.*;

public class Shortest_Path_In_Weighted_Undirected_Graph_GFG {
    public static void main(String[] args) {
        Shortest_Path_In_Weighted_Undirected_Graph_GFG path = new Shortest_Path_In_Weighted_Undirected_Graph_GFG();
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(path.shortestPath(5, 6, edges));

    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair9> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] parent = new int[n + 1]; // it stores the nearest parent of each node
        ArrayList<ArrayList<Pair9>> adjList = buildAdjList(n, edges);
        int[] dist = new int[n + 1];
        func(adjList, pq, dist, parent);

        if (dist[n] != Integer.MAX_VALUE) {
            //        ans.add(dist[n]);
            int ind = n;
            while(ind != 1) {
                ans.add(parent[ind]);
                ind = parent[ind];
            }
            int size = ans.size() / 2;

            for (int i = 0; i < size; i++) {
                swap(ans, i, ans.size() - 1 - i);
            }
            ans.addFirst(dist[n]);
            ans.addLast(n);
            return ans;
        }

        ans.add(-1);
        return ans;
    }
    public void func(ArrayList<ArrayList<Pair9>> adjList, PriorityQueue<Pair9> pq, int[] dist,
                     int[] parent) {

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // start node
        pq.offer(new Pair9(1, 0));

        while (!pq.isEmpty()) {
            Pair9 curPair = pq.poll();
            int curNode = curPair.node;
            int curDist = curPair.dist;

            for (Pair9 adjPair : adjList.get(curNode)) {
                int adjNode = adjPair.node;
                int weight = adjPair.dist;
                if (dist[adjNode] > curDist + weight) {
                    dist[adjNode] = curDist + weight;
                    parent[adjNode] = curNode;
                    pq.offer(new Pair9(adjNode, dist[adjNode]));
                }
            }
        }

    }
    public ArrayList<ArrayList<Pair9>> buildAdjList(int n, int[][] edges) {
        ArrayList<ArrayList<Pair9>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Pair9(v, w));
            adjList.get(v).add(new Pair9(u, w));
        }
        return adjList;
    }

    public void swap (List<Integer> ans, int ind1, int ind2) {
        int temp = ans.get(ind1);
        ans.set(ind1, ans.get(ind2));
        ans.set(ind2, temp);
    }

}
class Pair9 {
    int node;
    int dist;


    public Pair9(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

