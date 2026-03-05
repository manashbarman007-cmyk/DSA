package stacks_lectures;

import java.util.Stack;

public class Count_The_Reversals_GFG {
    public static void main(String[] args) {
    Count_The_Reversals_GFG obj=new Count_The_Reversals_GFG();
    String ex1="}{{}}{{{";
    String ex2="{{}{{{}{{}}{{";
    String ex3="}{{}}{{{";
        System.out.println(obj.countMinReversals(ex1));
        System.out.println(obj.countMinReversals(ex2));
        System.out.println(obj.countMinReversals(ex3));
    }

    public int countMinReversals(String s) {
        // code here
        int n=s.length();
        Stack<Character> obj=new Stack<>();

        //for odd length string as it can never be balanced
        if(n%2 !=  0) return -1;

        else  {
            for (int i=0;i<n;i++){
                char ch=s.charAt(i);
               if(ch=='{'){
                   obj.push(ch);
               } else if (obj.isEmpty() || obj.peek()=='}') {
                   obj.push(ch);
               }
               //pop the valid pairs
               else{
                   obj.pop();
               }
            }
        }

        //now make a count for '{' and '}' remaining in the stack
        double countOpen=0, countClose=0;
            while(!obj.isEmpty()){ //The while loop stops when the stack is empty
                if(obj.peek()=='{'){
                    obj.pop();
                    countOpen++;
                }else {
                    obj.pop();
                    countClose++;
                }
            }
            double minReversal=Math.ceil(countOpen/2)+Math.ceil(countClose/2);

            return (int)minReversal;//type casting to int

    }
}
