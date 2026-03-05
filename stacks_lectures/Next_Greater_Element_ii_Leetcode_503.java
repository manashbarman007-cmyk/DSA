package stacks_lectures;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_ii_Leetcode_503 {
    public static void main(String[] args) {
        Next_Greater_Element_ii_Leetcode_503 obj=new Next_Greater_Element_ii_Leetcode_503();
        int[] ex1={1,2,1};
        int[] ex2={1,2,3,4,3};
        System.out.println(obj.nextGreaterElements(ex1));
        System.out.println(obj.nextGreaterElements(ex2));

    }
    public int[] nextGreaterElements(int[] nums) {
     int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
     //we go through the array two times circularly
     for(int i=2*n-1;i>=0;i--){
         int element=nums[i%n];

         //strictly decreasing monotonic stack
         while(!stack.isEmpty() && stack.peek()<=element){
             stack.pop();
         }
         if(stack.isEmpty()){
             res[i%n]=-1;
             stack.push(element);

         }else{
             res[i%n]=stack.peek();
             stack.push(element);
         }
     }

     return res;
    }
}
