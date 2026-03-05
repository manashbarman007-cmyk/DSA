package dynamic_programming;

import java.util.Arrays;

public class Count_Square_Submatrices_With_All_Ones_CN {
    public static void main(String[] args) {
       int[][] arr = {{0, 1, 1, 1},
                     {1, 1, 1, 1},
                     {0, 1, 1, 1}};
        System.out.println(countSquares(3, 4, arr));
    }
    public static int countSquares(int n, int m, int[][] arr) {
        // Write your code here.
        int count = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (arr[i][j] == 1) {
                        dp[i][j] = 1;
                    }
                }
                else {
                    if (arr[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}
