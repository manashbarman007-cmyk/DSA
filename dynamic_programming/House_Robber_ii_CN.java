package dynamic_programming;

import java.util.ArrayList;

public class House_Robber_ii_CN {
    public static void main(String[] args) {
       int[] ex1={1,2,3,1};
       int[] ex2={2,3,2};
       int[] ex3={1,5,1,2,6};
        System.out.println(houseRobber(ex1));
        System.out.println(houseRobber(ex2));
        System.out.println(houseRobber(ex3));

    }

    public static long houseRobber(int[] valueInHouse) {

        if(valueInHouse.length==1){
            return valueInHouse[0];
        }
        // Write your code here.
        int[] arr1=new int[valueInHouse.length-1];
        int[] arr2=new int[valueInHouse.length-1];

        for (int i=0;i<arr1.length;i++){
            arr1[i]=valueInHouse[i+1];  //eliminating the first element

            arr2[i]=valueInHouse[i]; //eliminating the last element
        }
       long firstAns= findMaxSum(arr1);
       long secondAns=findMaxSum(arr2);

        return Math.max(firstAns,secondAns);
    }

     //recursion
//    static long findMax(int[] arr,int ind){
//       //base case
//        if(ind==0){
//            return arr[0];
//        }
//        if(ind<0){
//            return 0;
//        }
//
//        long pick = arr[ind] + findMax(arr, ind - 2); //we pick the current house and move 2 indices backward
//
//        long notPick=0 + findMax(arr,ind-1); //we don't pick the current house and move 1 index backward
//
//        return Math.max(pick,notPick);
//    }


    //space optimised
    static int findMaxSum(int[] arr){

        //base case
        int prev1=arr[0];
        int prev2=0; //initialize it as 0

        for(int i=1;i<arr.length;i++) { //recursion is replaced by this for loop

            int pick = arr[i];

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
