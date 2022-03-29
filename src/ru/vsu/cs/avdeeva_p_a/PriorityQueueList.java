package ru.vsu.cs.avdeeva_p_a;

public class PriorityQueueList<T extends Comparable<T>> {

    private class ListNode {
        public T value;
        public ListNode next;

        public ListNode(T value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public ListNode(T value) {
            this(value, null);
        }

        public int compareTo(ListNode a) {
            return value.compareTo(a.value);
        }
    }

    private ListNode head = null;  // first, top
    private ListNode tail = null;  // last
    private int count = 0;

    public void add(T value) {
        ListNode newNode = new ListNode(value);
        if (count == 0) {
            head = tail = newNode;
        } else if (newNode.compareTo(head) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode node = getPrevNode(newNode);
            if (node.equals(tail)) {
                tail.next = newNode;
                tail = newNode;
            } else {
                newNode.next = node.next;
                node.next = newNode;
            }
        }
        count++;
    }

    public ListNode getPrevNode(ListNode newNode) {
        ListNode out = new ListNode(null);
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (newNode.compareTo(curr) < 0) {
                out = curr;
            }
        }
        return out;
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

    @Override
    public String toString() {
        ListNode value = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (value != null) {
            stringBuilder.append(value.value).append(" ");
            value = value.next;
        }
        return stringBuilder.toString();
    }

    public int count() {
        return count;
    }

    public boolean isEmpty() {
        return count() == 0;
    }
}
