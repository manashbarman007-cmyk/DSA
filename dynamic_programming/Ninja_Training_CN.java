package dynamic_programming;

import java.util.Arrays;

public class Ninja_Training_CN {
    public static void main(String[] args) {
        int[][] ex1={{10,40,70},{20,50,80},{30,60,90}};
        int[][] ex2={{1,2,5},{3,1,1},{3,3,3}};
        int[][] ex3={{18,11,19},{4,13,7},{1,8,13}};
        int[][] ex4={{10,50,1}, {5,100,11}};
        System.out.println(ninjaTraining(3,ex1));
    }

    //recursive code
//    public static int ninjaTraining(int n, int points[][]) {
//
//        // Write your code here..
//        return findMaxMerit(points,n-1,0);
//    }
//
//    static int findMaxMerit(int[][] points,int row,int col){

//        //Each 'row' represents the number of days
//        //Each 'col' (0,1 and 2) represent the three different allowed activities with corresponding merit points

//          //base case
//        if(row==0){
//           int maxValue=Integer.MIN_VALUE;
//           for (int i=0;i<=2;i++) {
//               if (i != col) { //as we cannot do the same task in two consecutive days
//                   maxValue = Math.max(maxValue, points[0][i]); //we pick the largest allowed, merit points from Day1
//               }
//           }
//           return maxValue;
//        }
//        int maxMerit=Integer.MIN_VALUE;
//
//        for(int i=0;i<=2;i++){
//           if(i!=col){ //as we cannot do the same task in two consecutive days
//               int sum=points[row][i]+findMaxMerit(points,row-1,i);
//               maxMerit=Math.max(maxMerit,sum);
//           }
//        }
//        return maxMerit;
//    }


    //memoization
//    public static int ninjaTraining(int n, int points[][]) {
//
//        // Write your code here..
//        int[][] dp=new int[n][4];
//        for(int i=0;i< points.length;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return findMaxMerit(points,n-1,3,dp); //col=3 signifies that none of the task has been performed
//                                                       //on the previous day
//    }
//
//    static int findMaxMerit(int[][] points,int row,int col,int[][] dp){
//        //base case
//        //Each 'row' represents the number of days
//        //Each 'col' represents the three different allowed activities with corresponding merit points
//        if(row==0){
//           int maxValue=Integer.MIN_VALUE;
//           for (int i=0;i<=2;i++) {
//               if (i != col) {
//                   maxValue = Math.max(maxValue, points[0][i]); //we pick the largest merit points from Day1
//               }
//           }
//           return dp[row][col]=maxValue; //store and return the answer
//        }
//        if(dp[row][col]!=-1){
//            return dp[row][col];
//        }

//        int maxMerit=Integer.MIN_VALUE;
//
//        for(int i=0;i<=2;i++){
//           if(i!=col){
//               int sum=points[row][i]+findMaxMerit(points,row-1,i,dp);
//               maxMerit=Math.max(maxMerit,sum);
//           }
//        }
//        return dp[row][col]=maxMerit;  //calculate, store and return the result if it is a new
//                                       //subproblem
//    }


    //tabulation
//    public static int ninjaTraining(int n, int points[][]) {
//
//        // Write your code here..
//        int[][] dp=new int[n][4];
//        for(int i=0;i< points.length;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return findMaxMerit(points,dp); //col=3 signifies that none of the task has been performed
//                                                       //on the previous day
//    }
//
//    static int findMaxMerit(int[][] points,int[][] dp){
//        //base case
//        //Each 'row' represents the number of days
//        //Each 'col' represents the three different allowed activities with corresponding merit points
//        dp[0][0]=Math.max(points[0][1],points[0][2]);
//        dp[0][1]=Math.max(points[0][0],points[0][2]);
//        dp[0][2]=Math.max(points[0][0],points[0][1]);
//        dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
//
//        for(int days=1;days<dp.length;days++){  //the recursive code is replaced by this loop
//
//            for (int last=0;last<dp[days].length;last++){
//
//                int maxMerit=Integer.MIN_VALUE; //for each iteration in last maxMerit initializes as Integer.MIN
//
//                for (int task=0;task<=2;task++) {
//
//                    if (task != last) {
//                        int sum = points[days][task] + dp[days - 1][task];
//                        maxMerit=Math.max(maxMerit,sum);
//                    }
//
//                }
//
//                dp[days][last]=maxMerit;
//            }
//        }
//
//        return dp[dp.length-1][dp[0].length-1]; //the ans is stored at the last element of the dp array
//    }


    //space optimization
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[] prev=new int[4];
        Arrays.fill(prev,-1);

        return findMaxMerit(n,points,prev); //col=3 signifies that none of the task has been performed
                                                       //on the previous day
    }

    static int findMaxMerit(int n,int[][] points,int[] prev){
        //base case
        //Each 'row' represents the number of days
        //Each 'col' represents the three different allowed activities with corresponding merit points
        prev[0]=Math.max(points[0][1],points[0][2]);
        prev[1]=Math.max(points[0][0],points[0][2]);
        prev[2]=Math.max(points[0][0],points[0][1]);
        prev[3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int days=1;days<n;days++){  //the recursive code is replaced by this loop
            int[] temp=new int[4]; //create a temporary array

            for (int last=0;last<4;last++){

                int maxMerit=Integer.MIN_VALUE; //for each iteration in last maxMerit initializes as Integer.MIN

                for (int task=0;task<=2;task++) {

                    if (task != last) {
                        int sum = points[days][task] + prev[task];
                        maxMerit=Math.max(maxMerit,sum);
                    }

                }
                temp[last]=maxMerit;
            }
            //after computing make prev as temp for the next for loop in days
            prev=temp;
        }

        return prev[prev.length-1]; //the ans is stored at the last element of the prev array
    }
}
