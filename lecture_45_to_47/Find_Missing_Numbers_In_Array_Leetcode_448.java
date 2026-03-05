package lecture_45_to_47;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_Missing_Numbers_In_Array_Leetcode_448 {
    public static void main(String[] args) {
      int[] ex={4,3,2,7,8,2,3,1};
      Find_Missing_Numbers_In_Array_Leetcode_448 obj=new Find_Missing_Numbers_In_Array_Leetcode_448();
        System.out.println(obj.findDisappearedNumbers(ex));
    }

    public ArrayList<Integer> findDisappearedNumbers(int[] nums) { //the returns type is an arraylist
        int n=nums.length;
        cycleSort(nums);
        ArrayList<Integer> myList=new ArrayList<Integer>();
        //add elements in list
        int index=0;
        while(index<n) {
            if(nums[index]!=index+1 ) {
                myList.add(index+1);
                index++;
            }else index++;
        }
       return myList;
    }

    static void cycleSort(int[] nums){
        int n=nums.length,index=0;
        //cycle sort
        while(index<n){
            int actualIndex=nums[index]-1;
            //perform swap
            if(nums[index]!=nums[actualIndex]){
                int temp=nums[actualIndex];
                nums[actualIndex]=nums[index];
                nums[index]=temp;
            }
            else index++;
        }
    }
}
