package ru.vsu.cs.avdeeva_p_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random RND = new Random();

    public static void main(String[] args) throws Exception {
        PriorityQueueList<Integer> priorityQueue = new PriorityQueueList<>();

        createSeq().forEach(priorityQueue::add);

        System.out.println("Priority queue :\n" + priorityQueue);

    }

    public static List<Integer> createSeq() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            list.add(RND.nextInt(256));
        }
        return list;
    }

}


