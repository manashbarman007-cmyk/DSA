package stacks_lectures;

import java.util.Stack;

public class Min_Add_To_Make_Parenthesis_Valid_Leetcode_921 {
    public static void main(String[] args) {
        Min_Add_To_Make_Parenthesis_Valid_Leetcode_921 obj=new Min_Add_To_Make_Parenthesis_Valid_Leetcode_921();
        String ex1="())";
        String ex2="(((";
        String ex3="()))((";
        System.out.println(obj.minAddToMakeValid(ex1));
        System.out.println(obj.minAddToMakeValid(ex2));
        System.out.println(obj.minAddToMakeValid(ex3));

    }

    //non optimised using stacks
//    public int minAddToMakeValid(String s) {
//      int n=s.length();
//        Stack<Character> obj=new Stack<>();
//        for(int i=0;i<n;i++){
//            char ch=s.charAt(i);
//            if(ch=='('){
//                obj.push(ch);
//            } else if (obj.isEmpty() || obj.peek()==')') {
//                obj.push(ch);
//            }
//            else obj.pop(); //pop the valid pairs
//        }
//
//        return obj.size();
//    }

    //optimised solution
    //we optimise it without using stacks, so space can be optimised
    public int minAddToMakeValid(String s){
        int n=s.length(),countOpen=0,countClose=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') countOpen++;
            else if (countOpen>0 && ch==')') countOpen--;
            else countClose++;
        }
        return countOpen+countClose;
    }

}
