package ru.sberbank.school.helloworld.tasks.lesson06;

public interface Factorable {

    <T> T getBean(Class<T> cls);

    void close();

    void registryShutdownHook();
}
