package ru.sberbank.school.helloworld.tasks.lesson13_JMM.Task;


public class Main {

    public static void main(String[] args)  {
        Task<String> task = new Task<>(new MyCallable());
        Runnable r = () -> System.out.println(task.get());

        for (int i = 5; i > 0; i--) {
            new Thread(r).start();
        }
    }
}
