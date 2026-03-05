package queue_lectures;

public class DequeImplementationUsingCircularArray {
    public static void main(String[] args) {
        Deque d=new Deque(5);
        d.insertFront(5);
        d.insertFront(10);
        d.insertFront(15);
        d.insertRear(20);

        d.getFront();
        d.getRear();
//        System.out.println(d.deleteRear());

        d.printDeque();

    }
}

class Deque{
    private int capacity, size, rear, front;
    private int[] Deque;

    //constructor to initialize
    public Deque(int capacity){
        this.capacity=capacity;
        Deque=new int[capacity];
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

    //getFront()
    public void getFront(){ //we can make it to throw exception using custom exception
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj= new QueueIsEmptyException("Cannot peek as deque is empty");
        }
        else System.out.println(Deque[front]);
    }

    //getRear()
    public void getRear(){ //we can make it to throw exception using custom exception
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj= new QueueIsEmptyException("Cannot peek as deque is empty");
        }
        else System.out.println(Deque[rear]);
    }

    //insertFront()
    public void insertFront(int val){
        QueueIsFullException obj;
        if(isFull()){
            throw obj=new QueueIsFullException("Cannot insert as deque is full");
        }
        else if(isEmpty()){
            front=0; //we move it one index forward
            rear=0; //we move it one index forward
        }
        else if(front==0 && rear!=capacity-1) { //rear!=capacity-1, ie there is space to insert
            front=capacity-1; //we move left
        }
        else {
            front--; //move left
        }
        Deque[front]=val;
        size++;
    }

    //insertRear()
    public void insertRear(int val){
        QueueIsFullException obj;
        if(isFull()){
            throw obj=new QueueIsFullException("Cannot insert as deque is full");
        }
        else if(isEmpty()){
            front=0; //we move it one index forward
            rear=0; //we move it one index forward
        }
        else if(rear==capacity-1 && front!=0) {// front!=0, ie there is space to insert
            rear=0; //we move right
        }
        else {
            rear++; //we move right
        }
        Deque[rear]=val;
        size++;
    }

    //deleteFront()
    public int deleteFront(){
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj=new QueueIsEmptyException("Cannot delete as deque is empty");
        }

        int val=Deque[front];

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
            front++; //we move right
            size--;
        }
        return val;
    }

    //deleteRear()
    public int deleteRear(){
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj=new QueueIsEmptyException("Cannot delete as deque is empty");
        }

        int val=Deque[rear];

        if(front==rear) { //that is only one element is present in queue
            front=-1;
            rear=-1;
            size=0;
        }
        else if(rear==0){ //circular deletion
            rear=capacity-1;
            size--;
        }
        else {
            rear--; //we move left
            size--;
        }
        return val;
    }

    //size()
    public int size(){
        return size;
    }

    public void printDeque(){
        QueueIsEmptyException obj;
        if(isEmpty()){
            throw obj=new QueueIsEmptyException("Cannot print as deque is empty");
        }
        if(rear<=front) { //this is the circular case
            for(int i=0;i<=rear;i++){
                System.out.print(Deque[i]+" ");
            }
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(Deque[i] + " ");
            }
        }
        else{ //normal case when rear>front
            for(int i=front;i<=rear;i++){
                System.out.print(Deque[i]+" ");
            }

        }

    }
}

