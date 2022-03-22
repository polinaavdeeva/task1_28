package ru.vsu.cs.avdeeva_p_a;

public class PriorityQueueList<T extends Comparable<T>> {

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

        public int compareTo(SimpleLinkedPriorityListNode a) {
            return value.compareTo(a.value);
        }
    }


    private SimpleLinkedPriorityListNode head = null;  // first, top
    private SimpleLinkedPriorityListNode tail = null;  // last
    private int count = 0;

    public void add(T value) {
        SimpleLinkedPriorityListNode newNode = new SimpleLinkedPriorityListNode(value);
        if (count == 0) {
            head = tail = newNode;
        } else {
            if (newNode > tail) {
                tail  = newNode;
            }  else {
                tail.next =newNode;
            }
            tail = tail.next;
        }

        count++;
    }

    public SimpleLinkedPriorityListNode getNextNode(SimpleLinkedPriorityListNode newNode) {
        SimpleLinkedPriorityListNode curr = head;
        for (;curr.next != null ; curr = curr.next) {
            if (newNode.compareTo(curr) == 1) {
                return curr;
            }
        }
    }

    public T remove() throws Exception {
        T result = element();
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return result;
    }

    public T element() throws Exception {
        if (count() == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }

    public int count() {
        return count;
    }


    public boolean empty() {
        return count() == 0;
    }
}
