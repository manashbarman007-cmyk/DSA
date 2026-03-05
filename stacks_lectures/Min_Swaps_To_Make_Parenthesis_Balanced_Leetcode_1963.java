package stacks_lectures;

import java.util.Stack;

public class Min_Swaps_To_Make_Parenthesis_Balanced_Leetcode_1963 {
    public static void main(String[] args) {
     Min_Swaps_To_Make_Parenthesis_Balanced_Leetcode_1963 obj=new Min_Swaps_To_Make_Parenthesis_Balanced_Leetcode_1963();
     String ex1="][][";
     String ex2="]]][[[";
     String ex3="[]";
     String ex4="]]]][[][[][[[]]][[]][[[[][]]][[]]]]]][]][[][][[]][][[]]]][[[[[[[";
        System.out.println(obj.minSwaps(ex1));
        System.out.println(obj.minSwaps(ex2));
        System.out.println(obj.minSwaps(ex3));
        System.out.println(obj.minSwaps(ex4));
    }

    //non optimised using stacks
//    public int minSwaps(String s) {
//        int n=s.length();
//        Stack<Character> stack=new Stack<>();
//        for(int i=0;i<n;i++){
//            char ch=s.charAt(i);
//            if(ch=='[') stack.push(ch);
//            else if (stack.isEmpty() && ch==']' || stack.peek()==']' && ch==']') {
//                stack.push(ch);
//            }
//            else stack.pop();  //pop the balanced pairs
//        }
//
//        int countOpen=stack.size()/2,countClose=stack.size()/2;
//
//        if(countOpen%2==0 && countOpen%2==0){
//            return (countClose+countClose)/4;
//        }
//        //else return this (when countOpen and countOpen are odd)
//        return (countClose+countClose)/4 +1;
//    }

    //optimise way without stacks
    public int minSwaps(String s){
        int countOpen=0, countClose=0,n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='[') countOpen++;
            else if (countOpen>0 && ch==']') countOpen--;
            else countClose++;
        }
        if(countOpen%2==0 && countOpen%2==0){
            return (countClose+countClose)/4;
        }
        //else return this (when countOpen and countOpen are odd)
        return (countClose+countClose)/4 +1;

    }
}
