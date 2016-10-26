package ru.sberbank.school.helloworld.tasks.lesson12_ThreadPool.FixedThreadPool;


import ru.sberbank.school.helloworld.tasks.lesson12_ThreadPool.ThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FixedThreadPool implements ThreadPool {
    private final int nThreads;
    private final List<Worker> threads;
    private final LinkedList queue;

    public FixedThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedList();
        threads = new ArrayList<>(nThreads);
    }
    @Override
    public void start() {
        for (int i = 0; i < nThreads; i++) {
            threads.add(new Worker());
        }
        for (Worker thread:threads) {
            thread.start();
        }
    }
    @Override
    public void execute(Runnable r) {
        synchronized (queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    private class Worker extends Thread {
        public void run() {
            Runnable r;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }

                    r = (Runnable) queue.removeFirst();
                }

                try {
                    r.run();
                } catch (RuntimeException e) {

                }
            }
        }
    }
}