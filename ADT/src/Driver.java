public class Driver {
    public static void main(String[] args) {
        Queue q = new Queue(6);
        System.out.println(q.size());

        System.out.println("The size of the queue is : " + q.size());
        try {
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);
            System.out.println("The front element is: " + q.front());
            q.dequeue();
            System.out.println("The front element after dequeue is: " + q.front());
            q.enqueue(1);
            q.enqueue(2);

            q.enqueue(5);
            for (int i = 0; i < 5; i++) {
                System.out.println("The front element is: " + q.front());
                q.dequeue();
            }
        } catch (EmptyQueueException e) {
            System.err.println(e.getMessage());
        } catch (FullQueueException e) {
            System.err.println(e.getMessage());
        }
    }
}
