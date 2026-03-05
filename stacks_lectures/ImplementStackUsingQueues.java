package stacks_lectures;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
     MyNewStack stack=new MyNewStack();
     stack.push(12);
     stack.push(13);
     stack.push(14);
        stack.pop();
        System.out.println(stack.peep());
    }
}

class MyNewStack{
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public void push(int val){
        if(queue1.isEmpty()){
            queue1.offer(val);
        }
        else{
           while (!queue1.isEmpty()){
               queue2.offer(queue1.poll());
           }

           queue1.offer(val);

           while (!queue2.isEmpty()){
               queue1.offer(queue2.poll());
           }
        }
    }

    public int pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            System.out.println("No item to pop");
            return -1;
        }
        return queue1.poll();
    }

    public int peep(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            System.out.println("No item to peek");
            return -1;
        }
        return queue1.peek();
    }
}
