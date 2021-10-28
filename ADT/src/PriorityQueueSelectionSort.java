import QueueExceptions.*;


public class PriorityQueueSelectionSort {
    /**
     * Inner Element Class
     */
    public static class ElementPQS {
        private int key;
        private int element;
        private ElementPQS next;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }


        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }


        public ElementPQS() {
            this(0, 0, null);
        }

        public ElementPQS(int key, int element, ElementPQS next) {
            this.key = key;
            this.element = element;
            this.next = next;
        }

    }

    /**
     * Start of PQ selection sort class
     */
    private ElementPQS head;

    public PriorityQueueSelectionSort() {
        this.head = null;
    }

    public void enqueue(ElementPQS elementPQS) {
        if (this.head == null) {
            this.head = elementPQS;
            return;
        }
        ElementPQS holder = head;
        while (holder.next != null) {
            holder = holder.next;
        }
        holder.next = elementPQS;
    }

    /**
     * Dequeue function which removes a certain key from the PQ
     *
     * @throws EmptyQueueException
     */
    public void dequeue(int SKey) throws EmptyQueueException, AbsentKeyException {
        if (this.head == null) throw new EmptyQueueException("Empty Queue");
        if (this.head.key == SKey) {
            head = head.next;
            return;
        }
        ElementPQS holder = head;
        while (holder.next.key != SKey) {
            if (holder.next == null) throw new AbsentKeyException("Key is not part of the PQ");
            holder = holder.next;
        }
        if(holder.next!=null){
            holder.next = holder.next.next;
        }



    }

    /**
     * Function that returns the front of the Queue
     *
     * @return int front
     * @throws EmptyQueueException
     */
    public ElementPQS show(int SKey) throws EmptyQueueException, AbsentKeyException {
        if (this.head == null) throw new EmptyQueueException("Empty Queue");
        if (this.head.key == SKey) {
            return head;
        }
        ElementPQS holder = head;
        while (holder.next != null && holder.next.key != SKey) {
            holder = holder.next;
        }
        if (holder.next == null) throw new AbsentKeyException("Key is not part of the PQ");
        holder = holder.next;
        return holder;
        //Can implement method that will select a random one from all the same keys

    }
    public ElementPQS removeMin()throws EmptyQueueException{
        ElementPQS holder=this.head;
        ElementPQS holder1=this.head,holder2=this.head;
        if (this.head == null) throw new EmptyQueueException("Empty Queue");
        while(holder.next!=null){
            if(holder.next.element<holder1.element){
                holder1=holder;// We are going to skip to next after to destroy the link
                holder2=holder.next;
            }
            holder=holder.next;
        }
        if(holder1.next!=null){
            holder1.next=holder1.next.next;
        }

        return holder2;
    }

    public static void main(String[] args) {
        PriorityQueueSelectionSort pqs = new PriorityQueueSelectionSort();
        ElementPQS a = new ElementPQS(1, 50, null);
        ElementPQS b = new ElementPQS(3, 3, null);
        ElementPQS c = new ElementPQS(4, 10, null);
        ElementPQS d = new ElementPQS(5, 100, null);
        pqs.enqueue(a);
        pqs.enqueue(b);
        pqs.enqueue(c);
        pqs.enqueue(d);
        System.out.println("Here is my implementation of the PQ ADT");
        try {


            System.out.println("Here is the value attached to key 3 : " + pqs.show(3).getElement());
            pqs.dequeue(3);
            System.out.println("Remove minimum " + pqs.removeMin().getElement());
            System.out.println("Remove minimum " + pqs.removeMin().getElement());
        } catch (AbsentKeyException e) {
            System.err.println(e.getMessage());
        } catch (EmptyQueueException e) {
            System.err.println(e.getMessage());
        }
    }


}