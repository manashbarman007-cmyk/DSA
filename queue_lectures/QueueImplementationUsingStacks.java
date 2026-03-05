package queue_lectures;

import java.util.Stack;

public class QueueImplementationUsingStacks {
    public static void main(String[] args) {
    MyQueue obj=new MyQueue();
    obj.enqueue(12);
    obj.enqueue(13);
    obj.enqueue(14);
    obj.dequeue();
    obj.dequeue();
    obj.dequeue();
    obj.dequeue();obj.enqueue(11);
        System.out.println(obj.peek());
    }
}

//Solution1: We compromise the dequeue and peek operations
class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //enqueue operation
    public void enqueue(int val) {
        stack1.push(val);
    }

    //dequeue operation
    public int dequeue() {
        int val;
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("No elements to dequeue");
            return -1;
        }
        else {
            while (!stack1.isEmpty()){ //popping elements from stack1 to stack2
                stack2.push(stack1.pop());
            }

            val=stack2.pop();

            while (!stack2.isEmpty()){//popping elements back to stack1 from stack2
                stack1.push(stack2.pop());
            }
        }
        return val;
    }

    //peek operation
    public int peek() {
        int val;
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("No elements to peek");
            return -1;
        }
        else {
            while (!stack1.isEmpty()){ //popping elements from stack1 to stack2
                stack2.push(stack1.pop());
            }

            val=stack2.peek();

            while (!stack2.isEmpty()){ //popping elements back to stack1 from stack2
                stack1.push(stack2.pop());
            }
        }
        return val;
    }
}


//Solution2: We compromise the enqueue operation only
//class MyQueue {
//    Stack<Integer> stack1 = new Stack<>();
//    Stack<Integer> stack2 = new Stack<>();
//
//    //enqueue operation
//    public void enqueue(int val) {
//        if (stack1.isEmpty()) { //
//            stack1.push(val);
//        } else {
//            while (!stack1.isEmpty()) { //popping elements from stack1 to stack2
//                stack2.push(stack1.pop());
//            }

//            stack1.push(val);

//            while (!stack2.isEmpty()) {  //popping elements back to stack1 from stack2
//                stack1.push(stack2.pop());
//            }
//        }
//    }
//
//    //dequeue operation
//    public int dequeue() {
//        if (stack1.isEmpty()) {
//            System.out.println("No elements to dequeue");
//            return -1;
//        }
//        return stack1.pop(); //else we return and remove the top element of stack1
//    }
//
//    //peek operation
//    public int peek() {
//        if (stack1.isEmpty()) {
//            System.out.println("No elements to peek");
//            return -1;
//        }
//        return stack1.peek(); //else we return and remove the top element of stack1
//    }
//}
