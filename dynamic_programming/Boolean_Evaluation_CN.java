package dynamic_programming;

import java.util.Arrays;

public class Boolean_Evaluation_CN {
    public static void main(String[] args) {
        String exp1 = "F|T^F";
        String exp2 = "F^F^F^F&T|T|F|T|F|F|T|T|T|T&T|T|T&T|F&T|F|T|T|T^T|F^T|T&F^T|F|T|F|T&T|T^F|F^T&T^T&T^T&T^T&F&T^F|F^T|T|F|F^F|F&F|F|T&F&F";
        System.out.println(evaluateExp(exp1));
        System.out.println(evaluateExp(exp2));
    }


    //recursion
//    public static int evaluateExp(String exp) {
//        // Write your code here.
//        int n = exp.length();
//        return f(exp, 0, n - 1, 1);
//    }
//    static int f(String exp, int i, int j, int isTrue) {
//      int n = exp.length();
//      //base case 1
//        if (i > j) {
//            return 0; //as we can't make any partition
//        }
//        if (i == j) {
//            if (isTrue == 1) { // we want the number of ways t get true
//                return exp.charAt(i) == 'T' ? 1 : 0;
//            }
//            else { // we want the number of ways t get false
//                return exp.charAt(i) == 'F' ? 1 : 0;
//            }
//        }
//        int mod = (int) Math.pow(10, 9) + 7;
//        int ways = 0; // initialize as 0
//        for (int k = i + 1; k <= j - 1; k += 2) {
//            int lT = f(exp, i, k - 1, 1); // number of ways for the left subproblem to give true
//            int lF = f(exp, i, k - 1, 0); // number of ways for the left subproblem to give false
//            int rT = f(exp, k + 1, j, 1); // number of ways for the right subproblem to give true
//            int rF = f(exp, k + 1, j, 0); // number of ways for the right subproblem to give false
//            char operator = exp.charAt(k);
//            if (operator == '&') {
//                if (isTrue == 1) { //we want the number of ways to get true
//                    ways += (lT * rT) % mod;
//                }
//                else { //we want the number of ways to get false
//                    ways += ((lF * rF) % mod + (lF * rT) % mod + (lT * rF) % mod) % mod;
//                }
//            }
//            if (operator == '|') {
//                if (isTrue == 1) { //we want the number of ways to get true
//                    ways += ((lT * rT) % mod + (lF * rT) % mod + (lT * rF) % mod) % mod;
//                }
//                else { //we want the number of ways to get false
//                    ways += (lF * rF) % mod;
//                }
//            }
//            if (operator == '^') {
//                if (isTrue == 1) { //we want the number of ways to get true
//                    ways += ((lF * rT) % mod + (lT * rF) % mod) % mod;
//                }
//                else { //we want the number of ways to get false
//                    ways += ((lF * rF) % mod + (lT * rT) % mod) % mod;
//                }
//            }
//        }
//        return ways;
//    }


    //memoization
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        long[][][] dp = new long [n][n][2];
        for (long[][] x : dp) {
            for (long[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return (int)f(exp, 0, n - 1, 1, dp);
    }
    static long f(String exp, int i, int j, int isTrue, long[][][] dp) {
      int n = exp.length();
      //base case 1
        if (i > j) {
            return 0; //as we can't make any partition
        }
        if (i == j) {
            if (isTrue == 1) { // we want the number of ways t get true
                return exp.charAt(i) == 'T' ? 1 : 0;
            }
            else { // we want the number of ways t get false
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        int mod = (int) Math.pow(10, 9) + 7;
        long ways = 0; // initialize as 0
        for (int k = i + 1; k <= j - 1; k += 2) {
            long lT = f(exp, i, k - 1, 1, dp); // number of ways for the left subproblem to give true
            long lF = f(exp, i, k - 1, 0, dp); // number of ways for the left subproblem to give false
            long rT = f(exp, k + 1, j, 1, dp); // number of ways for the right subproblem to give true
            long rF = f(exp, k + 1, j, 0, dp); // number of ways for the right subproblem to give false
            char operator = exp.charAt(k);
            if (operator == '&') {
                if (isTrue == 1) { //we want the number of ways to get true
                    ways = (ways + (lT * rT)) % mod;
                }
                else { //we want the number of ways to get false
                    ways = (ways + ((lF * rF) % mod + (lF * rT) % mod + (lT * rF) % mod)) % mod;
                }
            }
            if (operator == '|') {
                if (isTrue == 1) { //we want the number of ways to get true
                    ways = (ways + ((lT * rT) % mod + (lF * rT) % mod + (lT * rF) % mod)) % mod;
                }
                else { //we want the number of ways to get false
                    ways = (ways + (lF * rF)) % mod;
                }
            }
            if (operator == '^') {
                if (isTrue == 1) { //we want the number of ways to get true
                    ways = (ways + ((lF * rT) % mod + (lT * rF) % mod)) % mod;
                }
                else { //we want the number of ways to get false
                    ways = (ways + ((lF * rF) % mod + (lT * rT) % mod)) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }

}
