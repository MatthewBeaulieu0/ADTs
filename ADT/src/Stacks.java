import StacksException.*;
import com.sun.source.tree.EmptyStatementTree;

public class Stacks {

    private int[] arr;
    private int last;


    public Stacks(int capacity) {
        this.arr = new int[capacity];
        last = -1;
    }

    public int pop() throws EmptyStackException {
        if (last == -1) throw new EmptyStackException("Stack is empty");
        int holder = this.arr[this.last];
        last--;
        return holder;
    }

    public void push(int element) throws FullStackException {
        last++;
        if (last == this.arr.length) throw new FullStackException("Full Stack ");
        this.arr[last] = element;

    }

    public static void main(String[] args) {
        Stacks s = new Stacks(5);
        try {
            s.push(3);
            s.push(4);
            s.push(5);
            s.push(6);
            s.push(7);
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
        } catch (FullStackException e) {
            System.err.println(e.getMessage());
        } catch (EmptyStackException e) {
            System.err.println(e.getMessage());
        }

    }
}
