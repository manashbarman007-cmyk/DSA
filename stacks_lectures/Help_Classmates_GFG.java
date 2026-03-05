package stacks_lectures;

import java.util.Arrays;
import java.util.Stack;

public class Help_Classmates_GFG {
    public static void main(String[] args) {
      int[] ex1={3, 8, 5, 2, 25};
      int[] ex2={1, 2, 3, 4};
        System.out.println(help_classmate(ex1,5));
        System.out.println(help_classmate(ex2,4));

    }
    public static int[] help_classmate(int arr[], int n)
    {
        // Your code goes
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();

        //traverse backwards through the array
        for(int i=n-1;i>=0;i--){
            int element=arr[i];
            while(!stack.isEmpty() && stack.peek()>=element){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=-1;
                stack.push(element);
            }else {
                res[i]=stack.peek();
                stack.push(element);
            }

        }
        return res;
    }
}
