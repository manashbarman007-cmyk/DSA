package dynamic_programming;
import java.util.*;

public class Max_Sum_Of_Non_Adjacent_Elements_CN {
    public static void main(String[] args) {

        ArrayList<Integer> ex1=new ArrayList<>();
        ex1.add(2);
        ex1.add(1);
        ex1.add(4);
        ex1.add(9);
        System.out.println(maximumNonAdjacentSum(ex1));
    }

    //recursive
//    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//        // Write your code here.
//       return findMaxSum(nums,nums.size()-1);
//    }
//    static int findMaxSum(ArrayList<Integer> nums,int ind){
//        //base case
//        if(ind == 0){
//            return nums.get(0);
//        }
//        if(ind<0){
//            return 0;
//        }
//
//        int pick = nums.get(ind)+findMaxSum(nums,ind-2); //pick the current index and move 2 indices backward
//        int notPick=0 + findMaxSum(nums,ind-1); //not pick the current index amd move one index backward
//
//        return Math.max(pick,notPick);
//    }


    //memoization
//    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//        // Write your code here.
//        int[] dp=new int[nums.size()];
//        Arrays.fill(dp,-1);
//       return findMaxSum(nums,dp,nums.size()-1);
//    }
//    static int findMaxSum(ArrayList<Integer> nums,int[] dp,int ind){
//        //base case
//        if(ind == 0){
//            return nums.get(0);
//        }
//        if(ind<0){
//            return 0;
//        }
//        if(dp[ind]!=-1){
//            return dp[ind];
//        }
//
//        int pick = nums.get(ind)+findMaxSum(nums,dp,ind-2); //pick the current index and move 2 indices backward
//        int notPick=0 + findMaxSum(nums,dp,ind-1); //not pick the current index amd move one index backward
//
//        return dp[ind]=Math.max(pick,notPick);
//    }

    //Tabulation
//    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
//        // Write your code here.
//        int[] dp=new int[nums.size()];
//        Arrays.fill(dp,-1);
//       return findMaxSum(nums,dp);
//    }
//
//    static int findMaxSum(ArrayList<Integer> nums,int[] dp){
//
//        //base case
//        dp[0]=nums.get(0);
//
//        for(int i=1;i<dp.length;i++) { //recursion is replaced by this for loop
//
//            int pick = nums.get(i);
//
//            if (i > 1) {
//                pick += dp[i-2]; //pick the current index and move 2 indices backward
//            }
//
//                int notPick =0 + dp[i-1]; //not pick the current index amd move one index backward
//
//                dp[i] = Math.max(pick, notPick);
//        }
//
//
//        return dp[dp.length-1]; //the ans is stored in the last index of the dp array
//    }


    //space optimization
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
       return findMaxSum(nums);
    }

    static int findMaxSum(ArrayList<Integer> nums){

        //base case
        int prev1=nums.get(0);
        int prev2=0; //initialize it as 0

        for(int i=1;i<nums.size();i++) { //recursion is replaced by this for loop

            int pick = nums.get(i);

            if (i > 1) {
                pick += prev2;
            }

                int notPick =0 + prev1;

                int cur_i = Math.max(pick, notPick);

                prev2=prev1;
                prev1=cur_i;

        }
        return prev1;
    }
}
