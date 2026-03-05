package lecture_45_to_47;

import java.util.Arrays;

public class Missing_Number_Leetcode_268 {
    public static void main(String[] args) {
        Missing_Number_Leetcode_268 obj=new Missing_Number_Leetcode_268();
        int[] ex={2,5,0,1,4};
        System.out.println(obj.missingNumber(ex));

    }

    public int missingNumber(int[] nums) {
        int  n=nums.length;
        int actualSum=0;
        //to find the sum of the given array
        for(int i =0;i<n;i++){
            actualSum+=nums[i];
        }
        //find the sum of the first max natural numbers
        int expectedSum=n*(n+1)/2;

       int missingNum=expectedSum-actualSum;
        return missingNum;
    }
}
