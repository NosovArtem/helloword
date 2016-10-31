package ru.sberbank.school.helloworld.tasks.lesson13_JMM.Task;

import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<? extends T> callable;
    private volatile T result;
    private volatile ExecutionRuntimeException exception;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }


    public T get() {
        System.out.println(Thread.currentThread().getName() + " вызвал метод get");
        T temp;
        if (result == null) {
            System.out.println(Thread.currentThread().getName() + " для данног потока результат не известен");
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "  в области synchronized");
                try {
                    temp = callable.call();
                    System.out.println(Thread.currentThread().getName() + " получил значение result: " + temp);
                    result = temp;
                } catch (Exception e) {
                    throw new ExecutionRuntimeException("Ошибка во время выполнения расчета", e);
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " Результат уже известен. Возвращаем результат без входа в область synchronized ");
            temp = result;
        }
        return temp;
    }

}