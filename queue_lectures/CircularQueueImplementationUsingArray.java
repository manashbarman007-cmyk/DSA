package queue_lectures;
//import queue_lectures.QueueIsEmptyException;
//import queue_lectures.QueueIsFullException;

public class CircularQueueImplementationUsingArray {
    public static void main(String[] args) {
        CircularQueue cQ=new CircularQueue(5);
        cQ.enqueue(10);
        cQ.enqueue(20);
        cQ.enqueue(30);
        cQ.enqueue(40);
        cQ.enqueue(50);
        cQ.dequeue();
        cQ.dequeue();
        cQ.enqueue(60);
        cQ.enqueue(70);
        System.out.println(cQ.isFull());
        cQ.printCircularQueue();

    }
}

class CircularQueue{
    private int capacity, size, rear, front;
    private int[] circularQueue;

    //constructor to initialize
    public CircularQueue(int capacity){
        this.capacity=capacity;
        circularQueue=new int[capacity];
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
        if((rear==capacity-1 && front==0) || (front!=0 && rear==front-1)){
            return true;
        }
        return false; //else it will return false
    }

    //peek()
    public void peek(){ //we can make it to throw exception using custom exception
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj= new QueueIsEmptyException("Cannot peek as deque is empty");
        }
        else System.out.println(circularQueue[front]);
    }

    //enqueue()
    public void enqueue(int val){
        QueueIsFullException obj;
        if(isFull()){
            throw obj=new QueueIsFullException("Cannot enqueue as deque is full");
        }
        else if(isEmpty()){
            front=0; //we move it one index forward
            rear=0; //we move it one index forward
        }
        else if(rear==capacity-1 && front!=0) { //circular insertion
           rear=0;
        }
        else {
            rear++;
        }
        circularQueue[rear]=val;
        size++;
    }

    //dequeue()
    public int dequeue(){
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj=new QueueIsEmptyException("Cannot dequeue as circular queue is empty");
        }

        int val=circularQueue[front];

        if(front==rear) { //that is only one element is present in queue
            front=-1;
            rear=-1;
            size=0;
        }
        else if(front==capacity-1){ //circular deletion
            front=0;
            size--;
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

    public void printCircularQueue(){
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj=new QueueIsEmptyException("Cannot print as circular queue is empty");
        }
        if(rear<=front) { //this is the circular case
            for(int i=0;i<=rear;i++){
                System.out.print(circularQueue[i]+" ");
            }
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(circularQueue[i] + " ");
            }
        }
        else{ //normal case when rear>front
            for(int i=front;i<=rear;i++){
                System.out.print(circularQueue[i]+" ");
            }

        }

    }
}



