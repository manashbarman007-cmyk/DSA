package stacks_lectures;

import java.util.ArrayList;
import java.util.Stack;

public class Online_Stock_Span_Leetocode_901 {
    public static void main(String[] args) {
     StockSpanner obj=new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }

}

class StockSpanner {

    Stack<Integer> stack;
    ArrayList<Integer> arr;


    //initializing the instance variables here in the constructor
    public StockSpanner() {
        stack = new Stack<>();
        arr = new ArrayList<>(); //dynamic array as datas will be given dynamically in this problem
    }

    public int next(int price) {
        arr.add(price);
        //strictly decreasing monotonic stack
        //we are storing the indices in the stack only
        while (!stack.isEmpty() && arr.get(stack.peek()) <= price) {
            stack.pop();
        }
        int indexOfPreviousGreater = (stack.isEmpty()) ? -1 : stack.peek();

        int currentIndex = arr.size()-1;

        int span=currentIndex-indexOfPreviousGreater;

        // we push after calculating the span, or else the arr.size() changes
        stack.push(currentIndex);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// class StockSpanner {

//     private Stack<int[]> stack;
//     public StockSpanner() {
//         stack = new Stack<>();

//     }

//     public int next(int price) {
//         int span = 1;

//         while (!stack.isEmpty() && price >= stack.peek()[0]) {
//             span += stack.pop()[1];

//         }
//         stack.push(new int[]{price, span});
//         return stack.peek()[1];
//     }
// }
