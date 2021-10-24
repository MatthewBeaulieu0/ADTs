import QueueExceptions.EmptyQueueException;
import StacksException.*;

import java.util.LinkedList;

//Named Stacks since there is already Stack on Java
public class StacksLinkedList {

    private LinkedList<Integer> arr;

    public Integer getRear() {
        return arr.getFirst();
    }

    public Integer getFront() {
        return arr.getLast();
    }

    public void push(int Element) {
        arr.add((Integer) Element);
    }

    public boolean isEmpty() {
        return (this.arr.isEmpty());
    }

    public Integer pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException("Stack is Empty");
        }
        Integer pop = this.getFront();
        this.arr.removeLast();
        return pop;
    }

    public Integer peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException("Stack is Empty");
        }
        return this.getFront();
    }
    public int size(){
        return (this.arr.size());
    }

}
