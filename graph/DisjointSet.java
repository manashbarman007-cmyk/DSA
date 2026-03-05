package graph;

import java.util.Arrays;

public class DisjointSet {
    int V; // number of nodes
    int[] parent;
    int[] rank;
    int[] size;

    public DisjointSet (int V) {
        this.V = V;
        parent = new int[V + 1]; // V + 1 as it works for both 0-based ind 1-based indexing
        for (int i = 0; i <= V; i++) {
            parent[i] = i; // each node points to itself initially
        }
        rank = new int[V + 1];
        size = new int[V + 1];

        Arrays.fill(size, 1); // initially the size of each component is 1
    }
    public int find (int x) { // during path compression the rank remains unchanged
        // base condition
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union by rank
    public void unionByRank (int x, int y) {
        int rootOfX = find(x);
        int rootOfY = find(y);

        // if both the roots are same then it means that x and y are from the same component
        if (rootOfX == rootOfY) return;

        if (rank[rootOfX] == rank[rootOfY]) {
            // join any of the root under the other root
            parent[rootOfY] = rootOfX; // or parent[rootOfX] = rootOfY;
            rank[rootOfX]++; // increment by 1
        }
        // attach the smaller rank root under the larger rank root but the ranks remain unchanged
        else if (rank[rootOfX] < rank[rootOfY]) {
            parent[rootOfX] = rootOfY;
        }
        else { // rank[rootOfX] > rank[rootOfY]
            parent[rootOfY] = rootOfX;
        }
    }

    // Union by size
    public void unionBySize (int x, int y) {
        int rootOfX = find(x);
        int rootOfY = find(y);

        // if both the roots are same then it means that x and y are from the same component
        if (rootOfX == rootOfY) return;

        if (size[rootOfX] == size[rootOfY]) {
            // join any of the root under the other root
            parent[rootOfY] = rootOfX; // or parent[rootOfX] = rootOfY;
            size[rootOfX] += size[rootOfY];
        }
        else if (size[rootOfX] < size[rootOfY]) {
            // attach the lower size root to the larger size root
            parent[rootOfX] = rootOfY;
            size[rootOfY] += size[rootOfX];
        }
        else { // size[rootOfX] > size[rootOfY]
            // attach the lower size root to the larger size root
            parent[rootOfY] = rootOfX;
            size[rootOfX] += size[rootOfY];
        }
    }
}
