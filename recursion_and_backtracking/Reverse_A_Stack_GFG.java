package recursion_and_backtracking;
import java.util.*;

public class Reverse_A_Stack_GFG {
    public static void main(String[] args) {
      Stack<Integer> stack1 =new Stack<>();
      stack1.push(2);
      stack1.push(4);
      stack1.push(6);
      stack1.push(8);

      Stack<Integer> stack2 =new Stack<>();
      stack2.push(2);
      stack2.push(4);
      stack2.push(6);
      stack2.push(8);
      while (!stack1.isEmpty()){
          System.out.print(stack1.pop()+" ");
      }
        System.out.println();

        reverse(stack2);

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop()+" ");
        }
    }

    //leap of faith approach
    static void reverse(Stack<Integer> s) {
        // add your code here

        //base case
        if(s.size()==0){
            return;
        }
        int ele=s.pop();
        reverse(s); //we hope that this call will reverse the n-1 elements
        insertAtBottom(s,ele);
    }
    static void insertAtBottom(Stack<Integer> s,int ele){
        if(s.isEmpty()){
            s.push(ele);
            return;
        }
        int newEle=s.pop();
        insertAtBottom(s,ele);
        s.push(newEle);

    }
}
