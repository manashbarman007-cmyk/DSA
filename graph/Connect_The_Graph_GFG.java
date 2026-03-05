package graph;

import java.util.HashSet;
import java.util.Set;

public class Connect_The_Graph_GFG {
    public static void main(String[] args) {

        Connect_The_Graph_GFG connect = new Connect_The_Graph_GFG();

        int[][] edges1 = {{0, 1}, {0, 2}, {1, 2}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};

        System.out.println(connect.Solve(4, edges1));
        System.out.println(connect.Solve(6, edges2));

    }
    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);

        int E = edge.length;
        int extraEdges = 0;

        for (int i = 0; i < E; i++) {
            int u = edge[i][0];
            int v = edge[i][1];

            int root1 = ds.find(u);
            int root2 = ds.find(v);

            if (root1 != root2) {
                ds.unionByRank(u, v); // we build the given graph
            }
            else { // root1 == root2
                extraEdges++;
            }
        }

        // Number of operations required = number of components - 1

        int[] parent = ds.parent; // parent is of size n + 1

        int size = parent.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size - 1; i++) {
            set.add(ds.find(i));
        }

        int numOfComponents = set.size();

        return (extraEdges >= numOfComponents - 1) ? numOfComponents - 1 : -1;
    }
}
