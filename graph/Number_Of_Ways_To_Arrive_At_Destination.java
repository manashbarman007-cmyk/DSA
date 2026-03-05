package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Number_Of_Ways_To_Arrive_At_Destination {
    public static void main(String[] args) {
        Number_Of_Ways_To_Arrive_At_Destination dest = new Number_Of_Ways_To_Arrive_At_Destination();
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1 ,2 , 3}, {1 ,3 , 3},
                {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(dest.countPaths(7, roads));
    }

    public int countPaths(int n, int[][] roads) {

        PriorityQueue<Pair12> pq = new PriorityQueue<>((a, b) -> (int)a.dist - (int)b.dist);
        long[] dist = new long[n];
        long[] ways = new long[n];
        ArrayList<ArrayList<Pair12>> adjList = buildAdjList(n, roads);

        dijkstra(adjList, pq, dist, ways);

        return (int)ways[n - 1];
    }
    public void dijkstra(ArrayList<ArrayList<Pair12>> adjList, PriorityQueue<Pair12> pq,
                         long[] dist, long[] ways) {
        int MOD = (int)Math.pow(10, 9) + 7;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        Arrays.fill(ways, 0);
        ways[0] = 1; // as 1 way
        pq.offer(new Pair12(0, 0));
        while (!pq.isEmpty()) {
            Pair12 curPair = pq.poll();
            long curNode = curPair.node;
            long curDist = curPair.dist;
            if (curDist > dist[(int)curNode]) continue; // skip outdated entries
            for (Pair12 adjPair : adjList.get((int)curNode)) {
                long adjNode = adjPair.node;
                long adjDist = adjPair.dist;
                if (dist[(int)adjNode] > curDist + adjDist) {
                    dist[(int)adjNode] = curDist + adjDist;
                    pq.offer(new Pair12(adjNode, dist[(int)adjNode]));
                    ways[(int)adjNode] = ways[(int)curNode];
                }
                else if (dist[(int)adjNode] == curDist + adjDist) {
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)curNode]) % MOD;
                }
            }
        }
    }
    public ArrayList<ArrayList<Pair12>> buildAdjList(int n, int[][] roads) {
        ArrayList<ArrayList<Pair12>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adjList.get(u).add(new Pair12(v, w));
            adjList.get(v).add(new Pair12(u, w));
        }
        return adjList;
    }
}
class Pair12 {
    long node;
    long dist;

    public Pair12(long node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}
