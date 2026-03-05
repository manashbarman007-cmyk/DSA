package stacks_lectures;

import java.util.ArrayList;
import java.util.Stack;

public class Next_Greater_Element_GFG {
    public static void main(String[] args) {
        Next_Greater_Element_GFG obj=new Next_Greater_Element_GFG();
        int[] ex1={6, 8, 0, 1, 3};
        int[] ex2={50, 40, 30, 10};
        int[] ex3={10, 20, 30, 50};
        System.out.println(obj.nextLargerElement(ex1));
        System.out.println(obj.nextLargerElement(ex2));
        System.out.println(obj.nextLargerElement(ex3));

    }

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n= arr.length;
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();

        //traverse backwards through the array
        for(int i=n-1;i>=0;i--){
            int ele=arr[i];

            //monotonic strictly decreasing stack
            while(!stack.isEmpty() && stack.peek()<=ele){
                stack.pop();
            }
            if(stack.isEmpty()){
                list.add(-1);
                stack.push(ele);
            }
            else {
                list.add(stack.peek());
                stack.push(ele);
            }
        }

        //we reverse the ArrayList
        return  reverseArrayList(list);
    }
    // writing a method to reverse an ArrayList
    static ArrayList<Integer> reverseArrayList(ArrayList<Integer> arr){
        int n=arr.size();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            result.add(arr.get(i));
        }
        return result;
    }
}
