package lecture_45_to_47;

import java.io.FilterOutputStream;
import java.util.Arrays;

public class Find_Duplicate_Number_Leetcode_287 {
    public static void main(String[] args) {
        Find_Duplicate_Number_Leetcode_287 obj = new Find_Duplicate_Number_Leetcode_287();
        int[] ex1 = {1,3,4,2,2};
        int[] ex2={3,1,3,4,2};
        int[] ex3={3,3,3,3,3};
        System.out.println(obj.findDuplicate(ex1));
        System.out.println(obj.findDuplicate(ex2));
        System.out.println(obj.findDuplicate(ex3));
    }

    //non-optimal approach
//    public int findDuplicate(int[] nums) {
//        int n= nums.length, index=0;
//
//        while (index<n){
//            int actualIndex=nums[index]-1;
//            if (nums[index] != nums[actualIndex]) {
//                //perform swap
//                int temp=nums[actualIndex];
//                nums[actualIndex]=nums[index];
//                nums[index]=temp;
//            }else index++;
//        }
//
//        //return the duplicate number
//        for(int i=0;i<n;i++){
//            if(nums[i]!=i+1) return nums[i];
//        }
//
//        //return a dummy value
//        return -1;
//    }


    //optimal approach
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int actualIndex = Math.abs(nums[i]) - 1;

            if (nums[actualIndex] < 0) { //this means that the element is negative
                return Math.abs(nums[i]);
            } else {
                nums[actualIndex] = -nums[actualIndex];
            }
        }

//        //returning a dummy value
        return -1;
    }
}