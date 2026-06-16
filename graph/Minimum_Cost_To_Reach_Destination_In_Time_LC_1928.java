import java.util.*;

class Minimum_Cost_To_Reach_Destination_In_Time_LC_1928 {

      public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int V = passingFees.length;

        // dp[node][time] : minimum cost to reach "node" from 0 using exactly "time"
        // we use this as there are 2 constraints:
            // 1: Cost (what we want to minimize)
            // 2: Time 
        // Thus, we can not use normal Dijkstra's algorithm
        int[][] dp = new int[V][maxTime + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        List<List<Triplet>> adjList = getAdjList(V, edges, passingFees);

        PriorityQueue<Triplet> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );
        int minCost = 0;
        queue.offer(new Triplet(0, 0, passingFees[0]));
        while (!queue.isEmpty()) {
            Triplet curTriplet = queue.poll();
            int curNode = curTriplet.node;
            int curTime = curTriplet.time;
            int curCost = curTriplet.cost;

            // destination reached with min cost
            if (curNode == V - 1) {
                return curCost;
            }

            for (Triplet neighbour : adjList.get(curNode)) {
                int neighbourNode = neighbour.node;
                int neighbourTime = neighbour.time;
                int neighbourCost = neighbour.cost;

                int newTime = curTime + neighbourTime;

                if (newTime > maxTime) continue;

                int newCost = curCost + neighbourCost;

                if (newCost < dp[neighbourNode][newTime]) {
                    dp[neighbourNode][newTime] = newCost;
                    queue.offer(new Triplet(neighbourNode, newTime, dp[neighbourNode][newTime]));
                }
            }
        }
        return -1;
    }

    public List<List<Triplet>> getAdjList (int V, int[][] edges, int[] passingFees) {
        List<List<Triplet>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adjList.get(u).add(new Triplet(v, time, passingFees[v]));
            adjList.get(v).add(new Triplet(u, time, passingFees[u]));
        }
        return adjList;
    }

    record Triplet (int node, int time, int cost){};
}
