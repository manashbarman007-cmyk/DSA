package stacks_lectures;

import java.util.ArrayList;
import java.util.Stack;

public class Longest_Valid_Parentheses_Leetcode_32 {
    public static void main(String[] args) {
        Longest_Valid_Parentheses_Leetcode_32 obj = new Longest_Valid_Parentheses_Leetcode_32();
        String ex1 = ")()())";
        String ex2 = ")()()))()(())()()(";
        System.out.println(obj.longestValidParentheses(ex1));
        System.out.println(obj.longestValidParentheses(ex2));


    }
       //Brute force
//    public int longestValidParentheses(String s) {
//
//        char[] ch=s.toCharArray();
//        Stack<Integer> stack=popValidParenthesis(s);
//
//        int max=0;
//        if(stack.isEmpty()){
//            return s.length(); //ie when all the parentheses are valid
//        }
//
//        ArrayList<Integer> list=storeStackInArrayList(stack,ch);
//            for (int i=0;i<=list.size()-2;i++){
//                int p1=i,p2=i+1; //we set two pointers
//                int length=list.get(p2)-list.get(p1)-1;
//                max= Math.max(max,length);
//            }
//
//
//        return max;
//
//    }
//
//    static Stack<Integer>  popValidParenthesis(String s){
//        int n=s.length();
//        Stack<Integer> st=new Stack<>();
//        for (int i=0;i<n;i++){
//            char element=s.charAt(i);
//            if(element=='('){
//                st.push(i);
//            }
//            else if(st.isEmpty() || s.charAt(st.peek())==')') {
//               st.push(i);
//            }
//             else {
//                    st.pop(); //we pop the valid perentheses
//             }
//        }
//        return st;

//    }


    
    //we add the indices of the invalid parentheses in an ArrayList
//    static ArrayList<Integer> storeStackInArrayList(Stack<Integer> st,char[] ch){
//        ArrayList<Integer> arr=new ArrayList<>();
//        arr.add(0,ch.length);
//
//        while ((!st.isEmpty())){
//            arr.add(0,st.pop());
//        }
//
//        arr.add(0,-1);
//
//        return arr;
//    }

//    //Optimal Approach (without custom stacks)
//    public int longestValidParentheses(String s) {
//        int n=s.length();
//        Stack<Integer> stack=new Stack<>();
//        int max=0;
//        stack.push(-1); //simply push this to denote that the stack is empty at first
//        for(int i=0;i<n;i++){
//            char ch=s.charAt(i);
//            if(ch=='('){ //blind insertion
//                stack.push(i);
//            }else {
//                stack.pop();
//                if(stack.isEmpty()){
//                    stack.push(i);
//                }
//                max= Math.max(max,i-stack.peek());
//            }
//        }
//        return max;
//    }

    //Optimal Approach(using custom stack)
    public int longestValidParentheses(String s) {
        int n=s.length();
        int[] stack=new int[n+1]; // "n+1" as we store an additional -1
        int max=0,top=-1;
        stack[++top]=-1;//simply push this to denote that the stack is empty at first
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){ //blind insertion
                stack[++top]=i; //we push the index
            }else {
                top--; //we pop the element
                if(top==-1){
                    stack[++top]=i;
                }
                max= Math.max(max,i-stack[top]);
            }
        }
        return max;
    }
}
