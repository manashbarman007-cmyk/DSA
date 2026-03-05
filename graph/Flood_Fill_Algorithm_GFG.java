package graph;

import java.util.Arrays;

public class Flood_Fill_Algorithm_GFG {
    public static void main(String[] args) {
        Flood_Fill_Algorithm_GFG fill = new Flood_Fill_Algorithm_GFG();
        int[][] image = new int[3][4];
        image[0][0] = 1;
        image[0][1] = 1;
        image[0][2] = 1;
        image[0][3] = 0;
        image[1][0] = 0;
        image[1][1] = 1;
        image[1][2] = 1;
        image[1][3] = 1;
        image[2][0] = 1;
        image[2][1] = 0;
        image[2][2] = 1;
        image[2][3] = 1;
        for (int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }
        fill.floodFill(image, 1, 2, 2);
        System.out.println("Result:");
        for (int[] arr : image) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int r = image.length;
        int c = image[0].length;
        int originalColor = image[sr][sc];
        boolean[][] visited = new boolean[r][c];

        dfs(image, sr, sc, newColor, r, c, originalColor, visited);

        return image;
    }

    public void dfs(int[][]image, int sr, int sc, int newColor, int r, int c,
                    int originalColor, boolean[][] visited) {
        // base condition
        if (sr < 0 || sr > (r - 1) || sc < 0 || sc > (c - 1)) {
            return;

        }

        if (!visited[sr][sc] && image[sr][sc] == originalColor) {

            image[sr][sc] = newColor;
            visited[sr][sc] = true; // mark it as visited

            //move up
            dfs(image, sr - 1, sc, newColor, r, c, originalColor, visited);

            //move down
            dfs(image, sr + 1, sc, newColor, r, c, originalColor, visited);

            //move left
            dfs(image, sr, sc - 1, newColor, r, c, originalColor, visited);

            //move right
            dfs(image, sr, sc + 1, newColor, r, c, originalColor, visited);
        }
    }
}
