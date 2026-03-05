package dynamic_programming;

import java.util.Arrays;

public class Ways_To_Make_Coin_Change_CN {
    public static void main(String[] args) {
     int[] ex1 = {1,2,3};
     int[] ex2 = {1,2};
        System.out.println(countWaysToMakeChange(ex1,4));
        System.out.println(countWaysToMakeChange(ex2,4));
    }

    //recursion
//    public static long countWaysToMakeChange(int denominations[], int value){
//        //write your code here
//        int n = denominations.length;
//        return f(denominations,value,n-1);
//    }
//    static long f(int denominations[], int value,int ind){
//        //base cases (when we reach the first element)
//        if(ind == 0){
//            if(value == 0 && denominations[0] == 0){
//                return 2; //we either pick or not pick it
//            }
//            if(value == denominations[0] || value % denominations[0] == 0){
//                return 1; //ie we count the element
//            }
//            return 0; //else we return 0
//        }
//        long pick = 0;
//        if(value >= denominations[ind]){
//            pick = f(denominations,value - denominations[ind],ind);
//        }
//        long notPick = f(denominations,value,ind-1);
//
//        return pick + notPick;
//    }


    //memoization
//    public static long countWaysToMakeChange(int denominations[], int value){
//        //write your code here
//        int n = denominations.length;
//        long[][] dp = new long[n][value+1];
//        for (long[] x : dp){
//            Arrays.fill(x,-1);
//        }
//        return f(denominations,value,n-1,dp);
//    }
//    static long f(int denominations[], int value,int ind,long[][] dp){
//        //base cases (when we reach the first element)
//        if(ind == 0){
//            if(value == 0 && denominations[0] == 0){
//                return 2; //we either pick or not pick it
//            }
//            if(value == denominations[0] || value % denominations[0] == 0){
//                return 1; //ie we count the element
//            }
//            return 0; //else we return 0
//        }
//        if(dp[ind][value] != -1){
//          return dp[ind][value];
//        }
//        long pick = 0;
//        if(value >= denominations[ind]){
//            pick = f(denominations,value - denominations[ind],ind,dp);
//        }
//        long notPick = f(denominations,value,ind-1,dp);
//
//        return dp[ind][value] = pick + notPick;
//    }


    //tabulation
    public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here
        int n = denominations.length;
        long[][] dp = new long[n][value+1];
        for (long[] x : dp){
            Arrays.fill(x,-1);
        }
        return f(denominations,value,dp);
    }
    static long f(int denominations[], int value,long[][] dp){
        int n=denominations.length;
        for(int ind = 0;ind <n;ind++){
            for (int target = 0;target <= value;target++){
                //base cases (when we reach the first element)
                if(ind == 0){
                    if(target == 0 && denominations[0] == 0){
                        dp[ind][target] = 2;
                        continue;
                    }
                    if (target == denominations[0] || target % denominations[0] == 0){
                        dp[ind][target] = 1;
                        continue;
                    }
                    dp[ind][target] = 0;
                    continue;
                }
                long pick = 0;
                if(target >= denominations[ind]){
                    pick = dp[ind][target - denominations[ind]];
                }
                long notPick = dp[ind-1][target];
                dp[ind][target] = pick + notPick;
            }
        }
        return dp[n-1][value];
    }
}
