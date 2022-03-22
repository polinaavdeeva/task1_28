package ru.vsu.cs.avdeeva_p_a;

public class Main {

    public static <T extends Comparable<T>> void main(String[] args) throws Exception {
        PriorityQueue<Integer> priorityQueue = new PriorityQueueList<>();
        priorityQueue.add(4);
        priorityQueue.add(15);
        priorityQueue.add(24);
        priorityQueue.add(5);

        while (!priorityQueue.empty()) {
            System.out.println(priorityQueue.remove());
        }
    }

}


