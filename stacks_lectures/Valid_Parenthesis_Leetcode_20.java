package stacks_lectures;

import java.util.Stack;

public class Valid_Parenthesis_Leetcode_20 {
    public static void main(String[] args) {
        Valid_Parenthesis_Leetcode_20 obj1=new Valid_Parenthesis_Leetcode_20();
        String s1="(){}[]";
        String s2="([{}])";
        String s3="(]";
        String s4="}{";
        String s5="([}}])";
        System.out.println(obj1.isValid(s1));
        System.out.println(obj1.isValid(s2));
        System.out.println(obj1.isValid(s3));
        System.out.println(obj1.isValid(s4));
        System.out.println(obj1.isValid(s5));


    }
    public boolean isValid(String s) {
        boolean isValidParenthesis = false;
        int n = s.length();
        Stack<Character> obj = new Stack<>();
        if (n % 2 == 1) return false;
        else {
            // push the open brackets in the stack
            for (int i = 0; i < n; i++) {

                char ch = s.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') { //perform push
                    obj.push(ch);
                } else {
                    if(obj.isEmpty()) return false;

                    else if (obj.peek() != '(' && ch == ')' ) {
                        return false;
                    } else if ( obj.peek() != '{' && ch == '}' ) {
                        return false;
                    } else if ( obj.peek() != '[' && ch == ']') {
                        return false;
                    } else obj.pop();
                }
            }
        }
        // for valid parenthesis the stack must be empty
        if(obj.isEmpty()) return true;


        //else
        return isValidParenthesis;
    }
}
