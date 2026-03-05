package stacks_lectures;

public class Implement_Stack_Using_Array {
    public static void main(String[] args) {
        //create an object of MyStack
        MyStack obj = new MyStack();
        obj.push(4);
        obj.push(14);
        obj.push(12);
        obj.push(4);
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
        System.out.println("Current size: "+obj.size());
        System.out.println("Is stack empty: "+obj.isEmpty());
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println("Is stack empty: "+obj.isEmpty());
        System.out.println(obj.peek());
    }
}

    class MyStack{
        int top=-1;
        int stackSize=1000;
        int[] arr=new int[stackSize];

        //to insert elements on top of the stack
        void push(int x){
            if(top>=stackSize-1){
                System.out.println("The stack is full");
            }
           else {
                top++;
                arr[top]=x;
            }
        }

        //to return and remove the top element
        int pop(){
         int popElement= arr[top];
         top--;
         return popElement;
        }


        //to check if the stack is empty or not
        boolean isEmpty(){
          boolean isStackEmpty=false;
          if(top<0) return true;
          return isStackEmpty;
        }

        //to return the top element of the stack
        int peek(){
            if(top<0) {
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return arr[top];
        }

        //to return the number of elements present in the stack
        int size(){
            return top+1;
        }
    }

