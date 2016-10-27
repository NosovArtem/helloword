package ru.sberbank.school.helloworld.tasks.lesson12_ThreadPool.FixedThreadPool;

import java.util.LinkedList;

public class Worker extends Thread {

    private  final LinkedList queue;
    private boolean isStopped = false;

    public Worker(LinkedList queue){
        this.queue = queue;
    }

    public void run() {
        Runnable r;

        while (!isStopped()) {
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
    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }


}