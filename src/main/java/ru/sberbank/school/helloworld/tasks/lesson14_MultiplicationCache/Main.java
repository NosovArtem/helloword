package ru.sberbank.school.helloworld.tasks.lesson14_MultiplicationCache;


import org.apache.log4j.Logger;
import ru.sberbank.school.helloworld.tasks.lesson07.Calculator;
import ru.sberbank.school.helloworld.tasks.lesson07.MyCalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        Calculator calculator = new MyCalculator();
        Calculator myProxy = (Calculator) MultiplicationCacheProxy.newInstance(calculator);

    /*    System.out.println(myProxy.sum(3, 3));
        System.out.println(myProxy.sum(3, 2));
        System.out.println(myProxy.sum(3, 3));
        System.out.println(myProxy.sum(3, 2));*/


        List<Thread> threads = IntStream.range(0, 6)
                .mapToObj(value -> new Thread(() -> {
                    Object res;
                    if (value % 2 == 0) {
                        res = myProxy.sum(3, 3);
                    }else {
                        res = myProxy.sum(3, 0);
                    }
                    System.out.println("RESULT : " + "-" + Thread.currentThread().getName() + "-" + " result = " + res);
                })).collect(Collectors.toList());

        threads.stream().forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}