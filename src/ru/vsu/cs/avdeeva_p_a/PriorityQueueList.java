package ru.vsu.cs.avdeeva_p_a;

public class PriorityQueueList<T extends Comparable<T>> implements PriorityQueue<T> {

    private class SimpleLinkedPriorityListNode {
        public T value;
        public SimpleLinkedPriorityListNode next;//ссылка на следующий элемент

        public SimpleLinkedPriorityListNode(T value, SimpleLinkedPriorityListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedPriorityListNode(T value) {
            this(value, null);
        }

        public int compareTo(T a,T b) {
            return a.compareTo(b);
        }
    }



    private SimpleLinkedPriorityListNode head = null;  // first, top
    private SimpleLinkedPriorityListNode tail = null;  // last
    private int count = 0;

    @Override
    public void add(T value) {
        if (count == 0) {
            head = tail = new SimpleLinkedPriorityListNode(value);
        } else {
            tail.next = new SimpleLinkedPriorityListNode(value);
            tail = tail.next;
        }
        count++;
    }

    @Override
    public T remove() throws Exception {
        T result = element();
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return result;
    }

    @Override
    public T element() throws Exception {
        if (count() == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean empty() {
        return count() == 0;
    }
}
