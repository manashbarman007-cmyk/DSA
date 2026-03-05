package graph;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops_GFG {
    public static void main(String[] args) {
        Cheapest_Flights_Within_K_Stops_GFG stops = new Cheapest_Flights_Within_K_Stops_GFG();
        int[][] flights = {{0, 1, 100},{1, 2, 100},{2, 0, 100},{1, 3, 600},{2, 3, 200}};
        System.out.println(stops.CheapestFLight(4, flights, 0, 3, 1));

    }
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here
        ArrayList<ArrayList<Triplet3>> adjList = buildAdjList(n, flights);
        int[] price = new int[n];
        Queue<Triplet3> queue = new LinkedList<>();
        dijkstra(adjList, price, queue, src, k);
        if (price[dst] != Integer.MAX_VALUE) {
            return price[dst];
        }
        return -1;
    }
    public void dijkstra(ArrayList<ArrayList<Triplet3>> adjList, int[] price,
                         Queue<Triplet3> queue, int src, int k) {

        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        queue.offer(new Triplet3(0, src, 0));

        while (!queue.isEmpty()) {
            Triplet3 curTriplet = queue.poll();
            int curCity = curTriplet.city;
            int curPrice = curTriplet.price;
            int curStop = curTriplet.stop;
            for (Triplet3 adjTriplet : adjList.get(curCity)) {
                int adjCity = adjTriplet.city;
                int adjPrice = adjTriplet.price;
                if (curStop <= k) {
                    if (price[adjCity] > curPrice + adjPrice) {
                        price[adjCity] = curPrice + adjPrice; // update it

                        queue.offer(new Triplet3(curStop + 1, adjCity, price[adjCity])); // increase the stop by 1
                    }
                }
            }
        }
    }
    public ArrayList<ArrayList<Triplet3>> buildAdjList(int n, int flights[][]) {
        ArrayList<ArrayList<Triplet3>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adjList.get(u).add(new Triplet3(0, v, w)); // initially all stops are 0
        }
        return adjList;
    }
}
class Triplet3 {
    int stop;
    int city;
    int price;

    public Triplet3(int stop, int city, int price) {
        this.stop = stop;
        this.city = city;
        this.price = price;
    }
}
