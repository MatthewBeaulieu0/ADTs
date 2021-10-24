public class Queue
{
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;



    public Queue(int size){
        this.arr=new int[size];
        this.capacity=size;
        this.front=0;
        this.rear=-1;

    }

    public int size(){
        return (((capacity-front)+rear)%capacity)+1;
    }
    public boolean isEmpty() {
        return (this.size()==0);
    }
    public boolean isFull() {
        return(this.capacity==this.size());
    }
    public void enqueue(int item) {
        if(isFull() &&this.arr!=null) {
         System.out.print("?");
        }
        this.rear=(this.rear+1)%capacity;
        arr[rear]=item;

    }

    /**
     * Dequeue function which only dequeues the value does not return it
     * @throws EmptyQueueException
     */
    public void dequeue()throws EmptyQueueException{
        if(this.isEmpty()) {
            throw new EmptyQueueException("Underflow\nProgram Terminated");
        }
        this.front=(this.front+1)%capacity;


    }

    /**
     * Function that returns the front of the Queue
     * @return int front
     * @throws EmptyQueueException
     */
    public int front() throws EmptyQueueException {
        if (isEmpty())
        {
            System.err.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
        return arr[front];
    }

    /**
     * Optional could simply use the clear method from the Collection interface
     */
    public void clear(){
        if(isEmpty()){
            System.out.println("It is already empty");
            return ;
        }
        for(int i=0;i<this.arr.length;i++ ){
           arr[i]= 0;
        }
    }
}