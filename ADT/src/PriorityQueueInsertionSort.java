import QueueExceptions.*;

import javax.swing.text.Element;

public class PriorityQueueInsertionSort {
    public static class ElementPQIS {
        private int key;
        private int element;
        private ElementPQIS next;

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


        public ElementPQIS() {
            this(0, 0, null);
        }

        public ElementPQIS(int key, int element, ElementPQIS next) {
            this.key = key;
            this.element = element;
            this.next = next;
        }

    }

    private ElementPQIS head;

    public PriorityQueueInsertionSort() {
        this.head = null;
    }

    public void enqueue(ElementPQIS elementPQIS) {
        if (this.head == null ) {
            this.head = elementPQIS;
            return;
        }
        ElementPQIS holder = this.head;
        if (elementPQIS.key <= holder.key) {
            elementPQIS.next = holder;
            this.head = elementPQIS;
            return;
        } else {
            while (holder.next != null && holder.next.key< elementPQIS.key) {
             holder=holder.next;
            }
            elementPQIS.next=holder.next;
            holder.next=elementPQIS;

        }
    }

    public ElementPQIS removeMin() throws EmptyQueueException {
        if (this.head == null) throw new EmptyQueueException("Empty Queue");
        ElementPQIS holder = this.head;
        this.head = holder.next;
        return holder;
    }

    public static void main(String[] args) {
        PriorityQueueInsertionSort pqis = new PriorityQueueInsertionSort();
        ElementPQIS a = new ElementPQIS(1, 50, null);
        ElementPQIS w = new ElementPQIS(1, 100, null);
        ElementPQIS f = new ElementPQIS(0, 50, null);
        ElementPQIS b = new ElementPQIS(3, 3, null);
        ElementPQIS c = new ElementPQIS(4, 10, null);
        ElementPQIS d = new ElementPQIS(5, 100, null);
        ElementPQIS j = new ElementPQIS(2, 6, null);
        pqis.enqueue(a);
        pqis.enqueue(b);
        pqis.enqueue(c);
        pqis.enqueue(d);
        pqis.enqueue(f);
        pqis.enqueue(w);
        pqis.enqueue(j);
        System.out.println("Removing the elements");
        try {
            for (int i = 0; i < 4; i++) {
                ElementPQIS currMin= pqis.removeMin();
                System.out.println("Key "+currMin.key + " min :" + currMin.element);
            }
        } catch (EmptyQueueException e) {
            System.err.print(e.getMessage());
        }
    }
}
