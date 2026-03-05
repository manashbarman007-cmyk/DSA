package queue_lectures;


public class QueueImplementationUsingArray {
    public static void main(String[] args) {
      Queue q=new Queue(5);
      q.enqueue(3);
      q.enqueue(4);
      q.enqueue(5);
      q.enqueue(6);
      q.enqueue(7);
      q.dequeue();
      q.dequeue();
      q.dequeue();
      q.dequeue();
      q.dequeue();
        System.out.println(q.size());
    }
}
class Queue{
    private int capacity, size, rear, front;
    private int[] queue;

    //constructor to initialize
    public Queue(int capacity){
        this.capacity=capacity;
        queue=new int[capacity];
        rear=front=-1;
        size=0;
    }

    //isEmpty()
     public boolean isEmpty(){
        if(rear==-1) {
            return true;
        }
        return false; //else it will return false
     }

     //isFull()
     public boolean isFull(){
        if(rear==capacity-1){
            return true;
        }
        return false; //else it will return false
     }

     //peek()
     public void peek(){ //we can make it to throw exception using custom exception
        QueueIsEmptyException obj;
        if(isEmpty()){
          throw obj= new QueueIsEmptyException("Cannot peek as queue is empty");
        }
        else System.out.println(queue[front]);
     }

     //enqueue()
     public void enqueue(int val){
        QueueIsFullException obj;
        if(isFull()){
            throw obj=new QueueIsFullException("Cannot enqueue as queue is full");
        }
        else if(isEmpty()){
            front=0; //we move it one index forward
            rear=0; //we move it one index forward
        }
        else {
            rear++;
        }
         queue[rear]=val;
         size++;
     }

     //dequeue()
     public int dequeue(){
       QueueIsEmptyException obj;
       if(isEmpty()){
           throw obj=new QueueIsEmptyException("Cannot deque as queue is empty");
       }

       int val=queue[front];

       if(front==rear) { //that is only one element is present in queue
           front=-1;
           rear=-1;
           size=0;
       }
       else {
           front++; //we move the front one index forward
           size--;
       }
       return val;
     }

     //size()
     public int size(){
        return size;
     }

     public void printQueue(){
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj=new QueueIsEmptyException("Cannot print as queue is empty");
        }
        for(int i=front;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }

     }
}

//custom exception
class QueueIsEmptyException extends RuntimeException{
    QueueIsEmptyException(String msg){
        super(msg);
    }
}

//custom exception
class QueueIsFullException extends RuntimeException {
    QueueIsFullException(String msg) {
        super(msg);
    }
}
